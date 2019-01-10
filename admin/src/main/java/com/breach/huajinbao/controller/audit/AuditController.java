package com.breach.huajinbao.controller.audit;

import com.breach.huajinbao.service.audit.IAuditService;
import com.breach.huajinbao.service.base.IEmployeeService;
import com.breach.huajinbao.util.audit.AuditQuery;
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
     * @Date: 2019/1/5 11:05
     */ 
    @RequestMapping("/auditTenderee")

    public Map<String,Object> auditTenderee(@RequestBody AuditQuery audit){
        // System.out.println(audit.toString());
        return auditService.auditTenderee(audit);
    }
    /**
     * @Description:  招标初审订单信息详情
     * @Param:  * @param
     * @return:
     * @Author: wanghe
     * @Date: 2019/1/5 21:02
     */
    @RequestMapping("/getAudit")
    public Map<String,Object> getAudit(int uid){
        return auditService.getAudit();

    }
}
