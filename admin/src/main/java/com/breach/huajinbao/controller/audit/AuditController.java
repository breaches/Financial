package com.breach.huajinbao.controller.audit;

import ch.qos.logback.core.net.SyslogOutputStream;
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

         System.out.println(editQuery.toString());

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
}
