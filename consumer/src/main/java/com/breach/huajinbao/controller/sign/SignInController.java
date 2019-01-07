package com.breach.huajinbao.controller.sign;

import com.breach.common.entity.ConsumerAuths;
import com.breach.huajinbao.service.sign.ISignInService;
import com.breach.huajinbao.util.sign.ReturnUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: Financial
 * @description: 登录业务
 * @author: shaokang
 * @create: 2019-01-05 09:37
 **/
@RestController
@RequestMapping("/consumer")
public class SignInController {

    @Autowired
    ISignInService signInService;

    @RequestMapping("/login")
    public ReturnUtil login(@RequestBody ConsumerAuths consumerAuths) {
        return signInService.login(consumerAuths);
    }


}
