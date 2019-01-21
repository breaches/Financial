package com.breach.huajinbao.service.audit.impl;

import com.breach.common.entity.ConsumerActivateVerifyRecord;
import com.breach.common.entity.EmployeeInfo;
import com.breach.common.entity.UserBorrowBidPublishVerify;
import com.breach.huajinbao.mapper.audit.IAuditMapper;
import com.breach.huajinbao.service.audit.IAuditService;
import com.breach.huajinbao.util.audit.*;
import com.breach.huajinbao.util.base.EmployeeSessionUtil;
import com.breach.huajinbao.util.verify.NewsMode;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wanghehe on 2019年01月05日
 * 审核业务实现类
 *
 */
@Service
public class AuditServiceImpl implements IAuditService {
    @Autowired
    private IAuditMapper auditMapper;

    /**
     * @Description:获取待审核的 招标订单的信息 （分页+查询）
     * @Param:  * @param audit 
     * @return: java.util.Map<java.lang.String,java.lang.Object> 
     * @Author: wanghe
     * @Date:
     */ 
    @Override
    public Map<String,Object> auditTenderee(AuditQuery audit) {
        //获取待审核的全部信息
        List<Map<String, Object>> auditList = auditMapper.getAuditTenderee(audit);
        //获取页码
        Integer total = auditMapper.getAuditTotal(audit);


        Map<String,Object> map = new HashMap<>();
        map.put("auditdata", auditList);
        map.put("audittotal", total);
        return map;
    }
    /**
     * 招标初审订单信息详情(身份详细信息，招标详情信息),
     * 1.凭id编号，找到提交记录中用户的身份信息，
     * 2.通过用户信息找到子集信息，
     * 3.招标信息的查询，
     * 4.返回需求信息
     *
     * @param
     * @return
     *
     */
    @Override
    public Map<String, Object> getAudit(EditQuery editQuery) {

        ConsumerActivateVerifyRecord info =auditMapper.getPerInfo(editQuery.getUserId());
        Map<String, Object> map = new HashMap<>();
        map.put("data", info);
        //学历信息
        map.put("sonInfo1", auditMapper.getEducation(info.getEducationId()));
        //收入信息
        map.put("sonInfo2", auditMapper.getIncomeRange(info.getIncomeRangeId()));
        //地址：
        map.put("sonInfo3", auditMapper.getCodeProvince(info.getCodeProvince()));
        map.put("sonInfo4", auditMapper.getCodeCity(info.getCodeCity()));
        map.put("sonInfo5", auditMapper.getCodeArea(info.getCodeArea()));
        map.put("tender",auditMapper.getBorrowNumber(editQuery.getBorrowNumber()));
        return map;
    }
    /**
     * 招标审核通过时，
     * 1.插入操作人的信息，返回id（状态1）
     * 2.修改招标申请表的（招标审核关联）
     * 3.回复招标申请成功   通知信息给用户
     * 4.{
     *     添加发布时间
     *     添加开始时间
     *     添加结束时间
     * }
     * 5.返回通过提示
     *
     * @param passQuery 招标单号和同意理由（实体）
     * @return
     *
     */
    @Override
    public Result goPass(PassQuery passQuery){


        LocalDateTime sqlTimeStamp = TimeUtil.getSqlTimeStamp();

        //获取天数
        Integer days  = auditMapper.SelectUserInfo(passQuery.getBorrowNumber());

        //插入操作人的信息，返回id
        UserBorrowBidPublishVerify operator = new UserBorrowBidPublishVerify();
        EmployeeInfo emp =EmployeeSessionUtil.getEmp();
        operator.setBorrowNumber(passQuery.getBorrowNumber());
        operator.setEmployeeId(emp.getId());
        operator.setReason(passQuery.getText());
        operator.setVerifyTime(sqlTimeStamp);
        //加时间
        LocalDateTime localDateTime = TimeUtil.addSqlTimeStampByDays(sqlTimeStamp, days);

        LocalDateTime localDateTime1 = TimeUtil.addSqlTimeStampByDays(sqlTimeStamp, 0);
        auditMapper.addTimeList( passQuery.getBorrowNumber(),sqlTimeStamp,localDateTime1,localDateTime);

        operator.setState(1);
        auditMapper.insertPublishVerify(operator);
        //修改修改招标申请表的（招标审核关联）
        auditMapper.setBorrowNumber(passQuery.getBorrowNumber(),operator.getId());
        //回复招标申请通过信息给用户
        Integer consumerId = auditMapper.selectUserId(passQuery.getBorrowNumber());
        auditMapper.insertNews(NewsMode.SUCCESS_TITLE_AUDIT, NewsMode.SUCCESS_CONTENT_AUDIT, consumerId,new Date());
        return new Result(200,"招标审核通过");
    }
    /**
     *   招标审核不通过时，
     *  1.插入操作人的信息，返回id（状态2）
     *  2.修改招标申请表的（招标审核关联）
     *  3.回复招标申请失败 通知信息给用户
     *  4.给用户增加上原来的信用额度
     *  5.返回通过提示
     * @param
     * @return
     *
     */
    @Override
    public Result noPass(PassQuery passQuery) {
        //插入操作人的信息，返回id
        UserBorrowBidPublishVerify operator = new UserBorrowBidPublishVerify();
        EmployeeInfo emp =EmployeeSessionUtil.getEmp();
        operator.setBorrowNumber(passQuery.getBorrowNumber());
        operator.setEmployeeId(emp.getId());
        operator.setReason(passQuery.getText());
        operator.setVerifyTime(TimeUtil.getSqlTimeStamp());
        operator.setState(2);
        auditMapper.insertPublishVerify(operator);
        //修改招标申请表的（招标审核关联）
        auditMapper.setBorrowNumber(passQuery.getBorrowNumber(),operator.getId());
        //回复招标申请不通过信息给用户
        Integer consumerId = auditMapper.selectUserId(passQuery.getBorrowNumber());
        auditMapper.insertNews(NewsMode.DEDEAT_TITLE_AUDIT, NewsMode.DEFEAT_CONTENT_AUDIT, consumerId,new Date());
        //给用户增加上原来的信用额度
        BigDecimal money = auditMapper.getBorrowMoney(passQuery.getBorrowNumber());
        //找到用户id
        Integer  userId =auditMapper.getUserInfoId(passQuery.getBorrowNumber());
        //找到用户账户的id
        Integer accountId =auditMapper.getAccountId(userId);
        //加上减去的额度
        auditMapper.addCreditLimit(money,accountId);
        return new Result(200,"招标审核未通过");
    }
}
