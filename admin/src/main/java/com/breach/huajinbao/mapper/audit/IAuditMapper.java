package com.breach.huajinbao.mapper.audit;

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

    List<Map<String, Object>> getauditTenderee(AuditQuery audit);
}
