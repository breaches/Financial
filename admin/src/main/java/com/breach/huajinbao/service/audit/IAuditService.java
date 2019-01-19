package com.breach.huajinbao.service.audit;

import com.breach.huajinbao.util.audit.AuditQuery;
import com.breach.huajinbao.util.audit.EditQuery;
import com.breach.huajinbao.util.audit.PassQuery;
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
     * @Date:
     */
    Map<String,Object> auditTenderee(AuditQuery audit);
    /**
     * @Description:  招标初审身份信息详情
     * @Param:  * @param
     * @return:
     * @Author: wanghe
     * @Date:
     */
    Map<String, Object> getAudit(EditQuery editQuery);
    /**
     *  招标通过信息
     * @param
     * @return
     *
     */
    Result goPass(PassQuery passQuery);
    /**
     * 招标不通过
     * @param
     * @return
     *
     */
    Result noPass(PassQuery passQuery);
}