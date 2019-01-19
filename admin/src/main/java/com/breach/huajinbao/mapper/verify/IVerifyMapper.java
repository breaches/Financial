package com.breach.huajinbao.mapper.verify;

import com.breach.common.entity.ConsumerActivateVerifyRecord;
import com.breach.common.entity.ConsumerAddress;
import com.breach.huajinbao.util.verify.VerifyQuery;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by wanghehe on 2019年01月05日
 * 认证信息dao接口
 */
@Repository
public interface IVerifyMapper {

    /**
     * 搜索所有的待审核的实名认证表
     * @param
     * @return
     *
     */
    List<Map<String, Object>> getAuthentication(VerifyQuery info);
    /**
     * 获取总个数
     * @param
     * @return
     *
     */
    Integer getTotal(VerifyQuery info);
    /**
     * 由认证订单的编号，获取信息
     * @param
     * @return
     *
     */
    ConsumerActivateVerifyRecord getDetailed(String record);
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
     *  1.身份证信息（关联表）插入，返回插入id
     * @param
     * @return
     *
     */
    Integer insertConsumerCard(ConsumerActivateVerifyRecord per);
    /**
     *  2.现住址地址表（关联表）插入，返回插入id
     * @param
     * @return
     *
     */
    Integer insertAddress(ConsumerAddress address);
    /**
     * 修改基本信息consumer_info表
     * @param
     * @return
     *
     */
    void updateInfo(@Param("per") ConsumerActivateVerifyRecord per, @Param("cardId") Integer cardId,@Param("addressId") Integer addressId);
    /**
     * 给用户回复消息consumer_message表
     * @param
     * @param date
     * @return
     *
     */
    void insertNews(@Param("title") String successTitle, @Param("content") String successContent, @Param("consumerId") Integer consumerId,@Param("date") Date date);

    /**
     *修改审核记录的信息（人，时间，审核状态）通过2222
     * @param
     * @return
     *
     */
    void setStateForConsumer(@Param("employeeId") Integer id, @Param("operateTime") Date date,@Param("recordNumber") String recordNumber);
    /**
     *修改审核记录的信息（人，时间，审核状态）不通过33333
     * @param
     * @return
     *
     */
    void setStateForConsumerAgain(@Param("employeeId") Integer employeeAccountId, @Param("operateTime") Date date,@Param("recordNumber") String recordNumber);
    /**
     * 插入银行卡号
     * @param
     * @return
     *
     */
    void insertBank(@Param("bankCode") String bankCode,@Param("consumerId") Integer consumerId);

     /**
      * 获取账户id
      * @param
      * @return
      *
      */
    Integer getAccountId(Integer consumerId);
    /**
     * 激活信用额度
     * @param
     * @return
     *
     */
    void setCreditLine(Integer accountId);


}
