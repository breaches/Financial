package com.breach.huajinbao.service.audit.impl;

import com.breach.common.entity.*;
import com.breach.huajinbao.mapper.audit.IAuditMapper;
import com.breach.huajinbao.service.audit.IAuditService;
import com.breach.huajinbao.util.audit.*;
import com.breach.huajinbao.util.base.EmployeeSessionUtil;
import com.breach.huajinbao.util.verify.NewsMode;
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

    /**
     *
     * 满标初审列表（分页和查询）
     * @param
     * @return
     *
     */
    @Override
    public Map<String, Object> getFullScaleList(AuditQuery audit) {

        List<Map<String, Object>> fullScaleList = auditMapper.getFullScaleList(audit);
        Integer total = auditMapper.getFullScaleTotal(audit);

        Map<String,Object> map = new HashMap<>();
        map.put("auditdata", fullScaleList);
        map.put("audittotal", total);
        return map;
    }
    /**
     * 投标人信息列表
     * @param
     * @return
     *
     */
    @Override
    public Map<String, Object> getTenderList(String borrowNumber) {

        List<Map<String, Object>> tenderList = auditMapper.getTenderList(borrowNumber);


        Map<String,Object> map = new HashMap<>();
        map.put("dataList", tenderList);
        map.put("borrowNumber",tenderList.get(0).get("borrow_number"));
        return map;
    }
    /**
     * 满标初审通过时，
     *  1.插入初审记录，返回id
     *  2.插入总记录表中初审id
     *  3.发送信息给用户满标初审通过
     *
     *
     * @param
     * @return
     *
     */
    @Override
    public Result goFullScalePass(PassQuery passQuery) {


        EmployeeInfo emp = EmployeeSessionUtil.getEmp();
        //满标初审对象
        UserBorrowBidFullTrials Info = new UserBorrowBidFullTrials();

        Info.setBorrowNumber(passQuery.getBorrowNumber());
        Info.setReason(passQuery.getText());
        Info.setEmployeeId(emp.getId());
        Info.setVerifyTime(TimeUtil.getSqlTimeStamp());
        Info.setState(1);
        //插入表数据返回主键id
        auditMapper.insertTrials(Info);


        //插入总记录表中初审id（关联）
        auditMapper.setTralsId(passQuery.getBorrowNumber(), Info.getId());

        //回复招标申请不通过信息给用户
        Integer consumerId = auditMapper.selectUserId(passQuery.getBorrowNumber());
        auditMapper.insertNews(NewsMode.SUCCESS_TITLE_AUDIT_FULL_SCALE, NewsMode.SUCCESS_CONTENT_AUDIT_FULL_SCALE, consumerId,new Date());


      return new Result(200,"满标初审通过");

    }
    /**
     * 满标初审不通过时，
     *
     * 1.插入操作人的信息，返回id（状态2）
     * 2.修改招标申请表的（招标审核关联）
     * 3.回复招标申请失败 通知信息给用户
     * 4.给用户增加上原来的信用额度
     * 5.投标用户的钱返回
     * 6.返回通过提示
     * @param
     * @return
     *
     */
    @Override
    public Result noFullScalePass(PassQuery passQuery) {
        EmployeeInfo emp =EmployeeSessionUtil.getEmp();
        //满标初审对象
        UserBorrowBidFullTrials Info = new UserBorrowBidFullTrials();

        Info.setBorrowNumber(passQuery.getBorrowNumber());
        Info.setReason(passQuery.getText());
        Info.setEmployeeId(emp.getId());
        Info.setVerifyTime(TimeUtil.getSqlTimeStamp());
        Info.setState(2);
        //插入表数据返回主键id
        auditMapper.insertTrials(Info);
        //插入总记录表中初审id（关联）
        auditMapper.setTralsId(passQuery.getBorrowNumber(),Info.getId());
        //回复不通过信息给用户

        Integer consumerId = auditMapper.selectUserId(passQuery.getBorrowNumber());
        auditMapper.insertNews(NewsMode.DEDEAT_TITLE_AUDIT_FULL_SCALE, NewsMode.DEFEAT_CONTENT_AUDIT_FULL_SCALE, consumerId, new Date());

        //给用户增加上原来的信用额度
        BigDecimal money = auditMapper.getBorrowMoney(passQuery.getBorrowNumber());
        //找到用户id
        Integer  userId =auditMapper.getUserInfoId(passQuery.getBorrowNumber());
        //找到用户账户的id
        Integer accountId =auditMapper.getAccountId(userId);
        //加上减去的额度
        auditMapper.addCreditLimit(money,accountId);
        //投标人的投资回去，冻结资金解除
        auditMapper.addUserMoney(passQuery.getBorrowNumber());

        return new Result(200,"满标初审未通过");


    }
    /**
     *
     * 满标复审列表（分页和查询）
     * @param
     * @return
     *
     */
    @Override
    public Map<String, Object> getReFullScaleList(AuditQuery audit) {

        List<Map<String, Object>> fullScaleList = auditMapper.getReFullScaleList(audit);
        Integer total = auditMapper.getReFullScaleTotal(audit);

        Map<String,Object> map = new HashMap<>();
        map.put("auditdata", fullScaleList);
        map.put("audittotal", total);
        return map;
    }
    /**
     * 满标复审投标人信息
     *
     * @param
     * @return
     *
     */
    @Override
    public Map<String, Object> getReTenderList(String borrowNumber) {

        List<Map<String, Object>> tenderList = auditMapper.getReTenderList(borrowNumber);


        Map<String,Object> map = new HashMap<>();
        map.put("dataList", tenderList);
        map.put("borrowNumber",tenderList.get(0).get("borrow_number"));
        return map;
    }

    /**
     * 满标复审通过时，
     *  1.插入复审记录，返回id
     *  2.插入总记录表中复审id
     *  3.发送信息给用户满标复审通过
     *     ￥给借款用户打款
     *
     * @param
     * @return
     *
     */
    @Override
    public Result goReFullScalePass(PassQuery passQuery) {

        EmployeeInfo emp = EmployeeSessionUtil.getEmp();
        //满标初审对象
        UserBorrowBidFullRetrials Info = new UserBorrowBidFullRetrials();

        Info.setBorrowNumber(passQuery.getBorrowNumber());
        Info.setReason(passQuery.getText());
        Info.setEmployeeId(emp.getId());
        Info.setVerifyTime(TimeUtil.getSqlTimeStamp());
        Info.setState(1);
        //插入表数据返回主键id
        auditMapper.insertReTrials(Info);


        //插入总记录表中初审id（关联）()
        auditMapper.setReTralsId(passQuery.getBorrowNumber(), Info.getId());

        //回复信息给用户
        Integer consumerId = auditMapper.selectUserId(passQuery.getBorrowNumber());
        auditMapper.insertNews(NewsMode.SUCCESS_TITLE_AUDIT_RE_FULL_SCALE, NewsMode.SUCCESS_CONTENT_AUDIT_RE_FULL_SCALE, consumerId,new Date());
        //￥给借款用户打款
        BigDecimal money = auditMapper.getBorrowMoney(passQuery.getBorrowNumber());
        //找到用户账户的id
        Integer accountId =auditMapper.getAccountId(consumerId);

        //修改借款人账户可用余额

        auditMapper.setAvailableBalance(accountId,money);

        return new Result(200,"满标复审通过");

    }


    /**
     * 满标复审不通过时，
     *
     * 1.插入操作人的信息，返回id（状态2）
     * 2.修改招标申请表的（招标审核关联）
     * 3.回复招标申请失败 通知信息给用户
     * 4.给用户增加上原来的信用额度
     * 5.投标用户的钱返回
     * 6.返回通过提示
     * @param
     * @return
     *
     */
    @Override
    public Result noReFullScalePass(PassQuery passQuery) {
        EmployeeInfo emp =EmployeeSessionUtil.getEmp();
        //满标初审对象
        UserBorrowBidFullRetrials Info = new UserBorrowBidFullRetrials();

        Info.setBorrowNumber(passQuery.getBorrowNumber());
        Info.setReason(passQuery.getText());
        Info.setEmployeeId(emp.getId());
        Info.setVerifyTime(TimeUtil.getSqlTimeStamp());
        Info.setState(2);
        //插入表数据返回主键id
        auditMapper.insertReTrials(Info);
        //插入总记录表中初审id（关联）
        auditMapper.setReTralsId(passQuery.getBorrowNumber(), Info.getId());
        //回复不通过信息给用户

        Integer consumerId = auditMapper.selectUserId(passQuery.getBorrowNumber());
        auditMapper.insertNews(NewsMode.DEDEAT_TITLE_AUDIT_RE_FULL_SCALE, NewsMode.DEFEAT_CONTENT_AUDIT_RE_FULL_SCALE, consumerId, new Date());

        //给用户增加上原来的信用额度

        BigDecimal money = auditMapper.getBorrowMoney(passQuery.getBorrowNumber());
        //找到用户id
        Integer  userId =auditMapper.getUserInfoId(passQuery.getBorrowNumber());
        //找到用户账户的id
        Integer accountId =auditMapper.getAccountId(userId);
        //加上减去的额度
        auditMapper.addCreditLimit(money,accountId);

        //投标人的投资回去，冻结资金解除
        auditMapper.addUserMoney(passQuery.getBorrowNumber());

        return new Result(200,"满标复审未通过");


    }

    @Override
    public Map<String, Object> getFailure(AuditQuery audit) {

        LocalDateTime sqlTimeStamp = TimeUtil.getSqlTimeStamp();
        List<Map<String, Object>> List = auditMapper.getFailureList(audit,sqlTimeStamp);

        Integer total = auditMapper.getFailureTotal(audit,sqlTimeStamp);

        Map<String,Object> map = new HashMap<>();
        map.put("auditdata", List);
        map.put("audittotal", total);
        return map;
    }
    /**
     *同意流标时
     *
     * 1.插入操作记录 返回id
     * 2.修改总记录 流标id
     * 3.回复消息给用户
     * 4.给用户增加上原来的信用额度
     * 5.投标用户的钱返回
     * 6.返回通过提示
     *
     * @param
     * @return
     *
     */
    @Override
    public Result goFailurePass(PassQuery passQuery) {
        EmployeeInfo emp =EmployeeSessionUtil.getEmp();
        //满标初审对象
        UserBorrowBidAbandonVerify Info = new UserBorrowBidAbandonVerify();

        Info.setBorrowNumber(passQuery.getBorrowNumber());
        Info.setReason(passQuery.getText());
        Info.setEmployeeId(emp.getId());
        Info.setVerifyTime(TimeUtil.getSqlTimeStamp());
        Info.setState(1);
        //插入表数据返回主键id
        auditMapper.insertFailure(Info);
        //修改总记录 流标id
        auditMapper.setAbandonId(passQuery.getBorrowNumber(), Info.getId());

        //回复消息
        Integer consumerId = auditMapper.selectUserId(passQuery.getBorrowNumber());
        auditMapper.insertNews(NewsMode.FAILURE_TITLE, NewsMode.FAILURE_CONTENT, consumerId, new Date());
        //给用户增加上原来的信用额度

        BigDecimal money = auditMapper.getBorrowMoney(passQuery.getBorrowNumber());
        //找到用户id
        Integer  userId =auditMapper.getUserInfoId(passQuery.getBorrowNumber());
        //找到用户账户的id
        Integer accountId =auditMapper.getAccountId(userId);
        //加上减去的额度
        auditMapper.addCreditLimit(money,accountId);

        //投标人的投资回去，冻结资金解除
        auditMapper.addUserMoney(passQuery.getBorrowNumber());

        return new Result(200,"流标操作成功");
    }


}
