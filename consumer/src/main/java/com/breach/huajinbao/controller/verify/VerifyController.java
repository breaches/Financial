package com.breach.huajinbao.controller.verify;

import com.breach.huajinbao.service.verify.IVerifyService;
import com.breach.huajinbao.util.sign.ReturnUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: Financial
 * @description: 认证
 * @author: shaokang
 * @create: 2019-01-10 19:26
 **/
@RestController
@RequestMapping("/verify")
public class VerifyController {

    @Autowired
    IVerifyService verifyService;

    @RequestMapping("/listAllProvince")
    public ReturnUtil listAllProvince() {
        return verifyService.listAllProvince();
    }

    @RequestMapping("/listAllRegions")
    public ReturnUtil listAllRegions() {
        return verifyService.listAllRegions();
    }

}
