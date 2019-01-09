package com.breach.huajinbao.controller.zfq;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class JumpController {

    @RequestMapping("/toRole")
    public String toRole(){
        return "zfq/role";
    }
    @RequestMapping("/toConsumer")
    public String toConsumer(){
        return "zfq/consumer";
    }



}
