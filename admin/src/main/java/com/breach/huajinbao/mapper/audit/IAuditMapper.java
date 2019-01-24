package com.breach.huajinbao.mapper.audit;

import com.breach.common.entity.*;
import com.breach.huajinbao.util.audit.AuditQuery;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by wanghehe on 2019年01月05日
 * 审核dao层
 */
@Repository
public interface IAuditMapper {


    Integer getAuditTotal(AuditQuery audit);

    List<Map<String, Object>> getAuditTenderee(AuditQuery audit);
    //按uid和state 为2 查身份详情

    ConsumerActivateVerifyRecord getPerInfo(int userId);
    /**
     * 学历
     * @param
     * @return
     *
     */
    String  getEducation(Integer educationId);
    /**
     * 收入
     * @param
     * @return
     *
     */
    String getIncomeRange(Integer incomeRangeId);

    /**
     * 地址获取
     * @param
     * @return
     *
     */
    String getCodeProvince(Integer codeProvince);

    String getCodeCity(Integer codeCity);

    String getCodeArea(Integer codeArea);
    /**
     *  查招标信息
     * @param
     * @return
     *
     */
    Map getBorrowNumber(String borrowNumber);
    /**
     * 插入招标初审表
     * @param
     * @return
     *
     */
    void insertPublishVerify(UserBorrowBidPublishVerify operator);
    /**
     * 修改招标申请表的（招标审核关联）
     * @param
     * @return
     *
     */
    void setBorrowNumber(@Param("borrowNumber") String borrowNumber, @Param("id") Integer id);
    /**
     * 查订单的用户id
     * @param
     * @return
     *
     */
    Integer selectUserId(String borrowNumber);
    /**
     * 给用户回复消息consumer_message表
     * @param
     * @param date
     * @return
     *
     */
    void insertNews(@Param("title") String successTitleAudit,  @Param("content") String successContentAudit, @Param("consumerId") Integer consumerId, @Param("date") Date date);

    /**
     * 找到初审单号的借款金额
     * @param
     * @return
     *
     */
    BigDecimal getBorrowMoney(String borrowNumber);

    /**
     * 获取订单的用户Id
     * @param
     * @return
     *
     */
    Integer getUserInfoId(String borrowNumber);
    /**
     * 找到用户账户id
     * @param
     * @return
     *
     */
    Integer getAccountId(Integer userId);
    /**
     * 不通过，加上借的额度
     * @param
     * @return
     *
     */
    void addCreditLimit(@Param("money") BigDecimal money, @Param("accountId") Integer accountId);
    /**
     * 查询招标天数
     * @param
     * @return
     *
     */
    Integer SelectUserInfo(String borrowNumber);
    /**
     * 插入时间
     * @param
     * @return
     *
     */
    void addTimeList(@Param("borrowNumber") String borrowNumber,@Param("time") LocalDateTime sqlTimeStamp,@Param("beginTime") LocalDateTime localDateTime1,@Param("endTime") LocalDateTime localDateTime);
    /**
     * 获取满标列表
     * @param
     * @return
     *
     */
    List<Map<String, Object>> getFullScaleList(AuditQuery audit);
    /**
     * 满标列表总个数
     * @param
     * @return
     *
     */
    Integer getFullScaleTotal(AuditQuery audit);
    /**
     * 找到投标人列表
     * @param
     * @return
     *
     */
    List<Map<String, Object>> getTenderList(String borrowNumber);
    /**
     * 插入满标初审记录
     * @param
     * @return
     *
     */
    void insertTrials(UserBorrowBidFullTrials info);
    /**
     *插入总记录表中初审id（关联）
     * @param
     * @return
     *
     */
    void setTralsId(@Param("borrowNumber") String borrowNumber,@Param("id") Integer id);
    /**
     * 冻结资金解除，投标金额返回
     * @param
     * @return
     *
     */
    void addUserMoney(String borrowNumber);

    /**
     * 复审分页查询和总数
     * @param
     * @return
     *
     */
    List<Map<String, Object>> getReFullScaleList(AuditQuery audit);
    Integer getReFullScaleTotal(AuditQuery audit);

    /**
     * 满标复审投标人信息
     *
     * @param
     * @return
     *
     */
    List<Map<String, Object>> getReTenderList(String borrowNumber);
    /**
     * 插入满标审核记录
     * @param
     * @return
     *
     */
    void insertReTrials(UserBorrowBidFullRetrials info);
    /**
     * 修改满标复审id（关联）
     * @param
     * @return
     *
     */
    void setReTralsId(@Param("borrowNumber") String borrowNumber,@Param("id") Integer id);
    /**
     * 给借款人打款
     * @param
     * @return
     *
     */
    void setAvailableBalance(@Param("accountId") Integer accountId,@Param("money") BigDecimal money);

    /**
     * 流标分页（关联）
     * @param
     * @param sqlTimeStamp
     * @return
     *
     */
    List<Map<String, Object>> getFailureList(@Param("audit") AuditQuery audit, @Param("time") LocalDateTime sqlTimeStamp);
    Integer getFailureTotal(@Param("audit") AuditQuery auditQuery,@Param("time") LocalDateTime sqlTimeStamp);
    /**
     * 插入流标记录
     * @param
     * @return
     *
     */
    void insertFailure(UserBorrowBidAbandonVerify info);
    /**
     * 修改abandon_id（关联）
     * @param
     * @return
     *
     */
    void setAbandonId(@Param("borrowNumber") String borrowNumber, @Param("id") Integer id);
}
