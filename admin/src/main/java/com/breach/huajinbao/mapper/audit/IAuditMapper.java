package com.breach.huajinbao.mapper.audit;

import com.breach.common.entity.ConsumerActivateVerifyRecord;
import com.breach.common.entity.UserBorrowBidPublishVerify;
import com.breach.huajinbao.util.audit.AuditQuery;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
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
//    /**
//     * 把投标申请剪掉的额度加上去
//     * @param
//     * @return
//     *
//     */
//    void addCreditLimit(BigDecimal money);
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

}
