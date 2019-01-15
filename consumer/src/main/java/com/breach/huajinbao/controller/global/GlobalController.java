package com.breach.huajinbao.controller.global;

import com.breach.huajinbao.service.global.IGlobalService;
import com.breach.huajinbao.util.global.GlobalData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: Financial
 * @description:
 * @author: shaokang
 * @create: 2019-01-08 12:58
 **/
@RestController
public class GlobalController {

    @Autowired
    private IGlobalService globalService;

    @RequestMapping("/consumer/getUserInfoAfterLogin")
    public GlobalData getUserInfoAfterLogin() {
        return globalService.getUserInfoAfterLogin();
    }

    @RequestMapping("/consumer/getAmount")
    public GlobalData getAmount() {
        return globalService.getAmount();
    }
}
