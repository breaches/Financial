package com.breach.huajinbao.controller.audit;

import com.breach.huajinbao.service.audit.IAuditService;
import com.breach.huajinbao.util.audit.AuditQuery;
import com.breach.huajinbao.util.audit.EditQuery;
import com.breach.huajinbao.util.audit.PassQuery;
import com.breach.huajinbao.util.audit.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Created by wanghehe on 2019年01月05日
 * 审核控制层
 *
 */
@RequestMapping("/audit")
@RestController
public class AuditController {

    @Autowired
    private IAuditService auditService;
    /**
     * @Description: 招标初审订单信息
     * @return:     初审订单信息（分页和查询）
     * @Param:  * @param 分页实体
     * @Author: wanghe
     * @Date:
     */ 
    @RequestMapping("/auditTenderee")

    public Map<String,Object> auditTenderee(@RequestBody AuditQuery audit){
        return auditService.auditTenderee(audit);
    }
    /**
     * @Description:  招标初审订单信息详情
     * @Param:  * @param
     * @return: 个人信息
     * @Author: wanghe
     * @Date:
     */
    @RequestMapping("/getAudit")
    public Map<String,Object> getAudit(@RequestBody EditQuery editQuery){

        return auditService.getAudit(editQuery);

    }
   /**
    * @Description: 招标信息通过
    * @Param:  * @param null
    * @return:  通过提示
    * @Author: wanghe
    * @Date:
    */
    @RequestMapping("/goPass")
    public Result goPass(@RequestBody PassQuery passQuery){

        return  auditService.goPass(passQuery);
    }
    /**
     * 招标不通过
     * @param
     * @return
     *
     */
    @RequestMapping("/noPass")
    public Result noPass(@RequestBody PassQuery passQuery){

        return  auditService.noPass(passQuery);
    }
    /**
     *
     * 满标初审列表（分页和查询）
     * @param
     * @return
     *
     */
    @RequestMapping("/getFullScaleList")

    public Map<String,Object> getFullScaleList(@RequestBody AuditQuery audit){
        return auditService.getFullScaleList(audit);
    }
    /**
     * 按编号找到投标人信息
     * @param
     * @return
     *
     */
    @RequestMapping("/getTenderList")

    public Map<String,Object> getTenderList(@RequestBody EditQuery editQuery){

        return auditService.getTenderList(editQuery.getBorrowNumber());
    }


    /**
     * 满标初审通过
     * @param passQuery (评论内容和订单编号)
     * @return
     *
     */
    @RequestMapping("/goFullScalePass")
    public Result goFullScalePass(@RequestBody PassQuery passQuery){

        return  auditService.goFullScalePass(passQuery);
    }


    /**
     * 满标初审不通过
     * @param passQuery (评论内容和订单编号)
     * @return
     *
     */
    @RequestMapping("/noFullScalePass")
    public Result noFullScalePass(@RequestBody PassQuery passQuery){

        return  auditService.noFullScalePass(passQuery);
    }

    /**
     *
     * 满标复审列表（分页和查询）
     * @param
     * @return
     *
     */
    @RequestMapping("/getReFullScaleList")

    public Map<String,Object> getReFullScaleList(@RequestBody AuditQuery audit){
        return auditService.getReFullScaleList(audit);
    }
    /**
     * 满标复审投标人
     *getReTenderList
     * @param
     * @return
     *
     */
    @RequestMapping("/getReTenderList")

    public Map<String,Object> getReTenderList(@RequestBody EditQuery editQuery){

        return auditService.getReTenderList(editQuery.getBorrowNumber());
    }

    /**
     * 满标复审通过
     * @param passQuery (评论内容和订单编号)
     * @return
     *
     */
    @RequestMapping("/goReFullScalePass")
    public Result goReFullScalePass(@RequestBody PassQuery passQuery){

        return  auditService.goReFullScalePass(passQuery);
    }

    /**
     * 满标复审不通过
     * @param passQuery (评论内容和订单编号)
     * @return
     *
     */
    @RequestMapping("/noReFullScalePass")
    public Result noReFullScalePass(@RequestBody PassQuery passQuery){

        return  auditService.noReFullScalePass(passQuery);
    }

    /**
     * 流标列表
     * @param
     * @return
     *
     */
    @RequestMapping("/getFailure")

    public Map<String,Object> getFailure(@RequestBody AuditQuery audit){
        return auditService.getFailure(audit);
    }
    /**
     * 同意流标
     * @param
     * @return
     *goFailurePass
     */
    @RequestMapping("/goFailurePass")
    public Result goFailurePass(@RequestBody PassQuery passQuery){

        return  auditService.goFailurePass(passQuery);
    }
}
