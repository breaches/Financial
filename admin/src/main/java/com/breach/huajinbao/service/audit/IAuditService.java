package com.breach.huajinbao.service.audit;

import com.breach.huajinbao.util.audit.AuditQuery;
import com.breach.huajinbao.util.audit.Result;

import java.util.Map;

/**
 * Created by wanghehe on 2019年01月05日
 * 审核业务接口
 */
public interface IAuditService {
    /**
     * @Description:  招标初审订单信息
     * @Param:  * @param
     * @return:
     * @Author: wanghe
     * @Date: 2019/1/5 21:02
     */
    Map<String,Object> auditTenderee(AuditQuery audit);

    /**
     * @Description:  招标初审订单信息详情
     * @Param:  * @param
     * @return:
     * @Author: wanghe
     * @Date: 2019/1/5 21:02
     */
    Map<String, Object> getAudit();
}