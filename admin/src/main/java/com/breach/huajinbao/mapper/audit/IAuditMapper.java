package com.breach.huajinbao.mapper.audit;

import com.breach.common.entity.ConsumerActivateVerifyRecord;
import com.breach.huajinbao.util.audit.AuditQuery;
import org.springframework.stereotype.Repository;

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
}
