package com.breach.huajinbao.controller.sign;

import com.breach.common.entity.ConsumerAccount;
import com.breach.huajinbao.service.sign.ISignUpService;
import com.breach.huajinbao.util.sign.RegisterData;
import com.breach.huajinbao.util.sign.ReturnUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: Financial
 * @description: 注册
 * @author: shaokang
 * @create: 2019-01-05 09:37
 **/
@RestController
@RequestMapping("/consumer")
public class SignUpController {

    @Autowired
    ISignUpService signUpService;

    @RequestMapping("/join")
    public ReturnUtil join(ConsumerAccount consumerAccount) {
        return signUpService.join(consumerAccount);
    }

    @RequestMapping("/register/sendMessage")
    public ReturnUtil sendMessage(@RequestBody RegisterData registerData) {
        return signUpService.sendMessage(registerData);
    }

    @RequestMapping("/register/verifyCode")
    public ReturnUtil verifyCode(@RequestBody RegisterData registerData) {
        return signUpService.verifyCode(registerData);
    }

    @RequestMapping("/register")
    public ReturnUtil register(@RequestBody RegisterData registerData) {
        return signUpService.register(registerData);
    }
}
