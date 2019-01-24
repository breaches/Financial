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
    /**
     *
     * 满标初审列表（分页和查询）
     * @param
     * @return
     *
     */
    Map<String, Object> getFullScaleList(AuditQuery audit);
    /**
     * 按编号找到投标人信息
     * @param
     * @return
     *
     */
    Map<String, Object> getTenderList(String borrowNumber);
    /**
     * 满标初审通过
     * @param passQuery (评论内容和订单编号)
     * @return
     *
     */
    Result goFullScalePass(PassQuery passQuery);
    /**
     * 满标初审不通过时
     * @param passQuery (评论内容和订单编号)
     * @return
     *
     */
    Result noFullScalePass(PassQuery passQuery);
    /**
     *
     * 满标复审列表（分页和查询）
     * @param
     * @return
     *
     */
    Map<String, Object> getReFullScaleList(AuditQuery audit);
    /**
     * 满标复审投标人
     *getReTenderList
     * @param
     * @return
     *
     */
    Map<String, Object> getReTenderList(String borrowNumber);
    /**
     * 满标复审通过
     * @param passQuery (评论内容和订单编号)
     * @return
     *
     */
    Result goReFullScalePass(PassQuery passQuery);
    /**
     * 满标复审不通过
     * @param passQuery (评论内容和订单编号)
     * @return
     *
     */
    Result noReFullScalePass(PassQuery passQuery);

    /**
     * 流标列表
     * @param
     * @return
     *
     */

    Map<String, Object> getFailure(AuditQuery audit);
    /**
     * 同意流标
     * @param
     * @return
     *
     */
    Result goFailurePass(PassQuery passQuery);
}