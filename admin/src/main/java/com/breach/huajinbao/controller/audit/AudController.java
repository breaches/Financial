package com.breach.huajinbao.controller.audit;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by wanghehe on 2019年01月05日
 */
@Controller
public class AudController {
    /**
     *  跳转投标初审页面
     * @param
     * @return
     *
     */
    @RequestMapping("/toAudit")
    public String toAudit(){
        return "audit/auditInfo";
    }



}
