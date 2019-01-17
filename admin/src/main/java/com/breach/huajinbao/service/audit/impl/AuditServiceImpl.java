package com.breach.huajinbao.service.audit.impl;

import com.breach.common.entity.ConsumerActivateVerifyRecord;
import com.breach.common.entity.EmployeeInfo;
import com.breach.common.entity.UserBorrowBidPublishVerify;
import com.breach.huajinbao.mapper.audit.IAuditMapper;
import com.breach.huajinbao.service.audit.IAuditService;
import com.breach.huajinbao.util.audit.AuditQuery;
import com.breach.huajinbao.util.audit.EditQuery;
import com.breach.huajinbao.util.audit.PassQuery;
import com.breach.huajinbao.util.audit.Result;
import com.breach.huajinbao.util.base.EmployeeSessionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
     * 1.凭id编号，找到用户的身份信息，
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
     * 1.插入操作人的信息，返回id
     * 2.修改招标申请表的（招标审核关联）
     * 3.回复招标申请通过信息给用户
     * 4.返回通过提示
     *
     * @param passQuery 招标单号和同意理由（实体）
     * @return
     *
     */
    @Override
    public Result goPass(PassQuery passQuery){
        //插入操作人的信息，返回id
        UserBorrowBidPublishVerify operator = new UserBorrowBidPublishVerify();
        EmployeeInfo emp =EmployeeSessionUtil.getEmp();

        operator.setBorrowNumber(passQuery.getBorrowNumber());
        operator.setEmployeeId(emp.getId());
        operator.setReason(passQuery.getText());
        //operator.setVerifyTime(new Date());


        //修改
        //auditMapper.setBorrowNumber(borrowNumber);
        return new Result(200,"招标审核通过");
    }
}
