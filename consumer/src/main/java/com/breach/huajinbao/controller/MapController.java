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

    /** 主页 shaokang **/
    @RequestMapping("/index")
    public String index1() {
        return "index";
    }

    /** 主页 shaokang **/
    @RequestMapping("/")
    public String index2() {
        return "index";
    }

    /** 主页 shaokang **/
    @RequestMapping("/consumerCenter")
    public String consumerCenter() {
        return "/consumer/consumerCenter";
    }

    /** 用户实名认证页面 shaokang **/
    @RequestMapping("/verifyInfomation")
    public String verifyInfomation() {
        return "/consumer/verifyInfomation";
    }

    @RequestMapping("/myborrow")
    public String myborrow() {
        return "/consumer/myborrow";
    }

}
