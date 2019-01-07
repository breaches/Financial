package com.breach.huajinbao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @program: Financial
 * @description:
 * @author: shaokang
 * @create: 2019-01-05 11:05
 **/
@Controller
public class MapController {

    /** 登录 shaokang **/
    @RequestMapping("/login")
    public String login() {
        return "/sign/login";
    }

    /** 注册 shaokang **/
    @RequestMapping("/register")
    public String register() {
        return "/sign/register";
    }

    /** 个人中心 shaokang **/
    @RequestMapping("/account")
    public String account() {
        return "/sign/account";
    }

}
