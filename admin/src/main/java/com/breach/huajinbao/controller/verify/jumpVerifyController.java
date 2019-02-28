package com.breach.huajinbao.controller.verify;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by wanghehe on 2019年01月06日
 */
@Controller
public class jumpVerifyController {


    @RequestMapping("/toVerify")

    public String toAudit(){
        return "verify/verifyInfo";
    }
    @RequestMapping("/getEcharts")

    public String getEcharts(){
        return "verify/echarts";
    }
}
