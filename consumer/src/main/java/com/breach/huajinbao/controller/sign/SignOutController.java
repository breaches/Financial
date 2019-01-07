package com.breach.huajinbao.controller.sign;

import com.breach.huajinbao.service.sign.ISignOutService;
import com.breach.huajinbao.util.sign.ReturnUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: Financial
 * @description: 注销、退出登陆
 * @author: shaokang
 * @create: 2019-01-05 09:38
 **/
@RestController
@RequestMapping("/consumer")
public class SignOutController {

    @Autowired
    ISignOutService signOutService;

    @RequestMapping("/logout")
    public ReturnUtil logout() {
        return signOutService.logout();
    }
}
