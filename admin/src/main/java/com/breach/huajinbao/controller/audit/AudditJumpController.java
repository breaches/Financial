package com.breach.huajinbao.controller.audit;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by wanghehe on 2019年01月05日
 */
@Controller
public class AudditJumpController {
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

    /**跳转满标初审界面
     *
     * @param
     * @return
     *
     */
    @RequestMapping("/toFullScale")
    public String toFullScale(){

        return "audit/fullScale";

    }

    /**跳转满标复审界面
     *
     * @param
     * @return
     *
     */
    @RequestMapping("/reFullScale")
    public String reFullScale(){

        return "audit/reFullScale";

    }
    /**跳转流标界面
     *
     * @param
     * @return
     *
     */
    @RequestMapping("/toFlowStandard")
    public String toFlowStandard(){

        return "audit/toFlowStandard";

    }




}
