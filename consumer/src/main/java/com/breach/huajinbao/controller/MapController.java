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
    @RequestMapping({"/index", "/"})
    public String index1() {
        return "index";
    }

    /** 用户个人主页 shaokang **/
    @RequestMapping("/consumerCenter")
    public String consumerCenter() {
        return "/consumer/consumerCenter";
    }

    /** 用户实名认证页面 shaokang **/
    @RequestMapping("/consumerCenter/verifyInfomation")
    public String verifyInfomation() {
        return "/consumer/verifyInfomation";
    }

    @RequestMapping("/myborrow")
    public String myborrow() {
        return "/consumer/myborrow";
    }

    /** 产品 展示借款/借贷产品 shaokang **/
    @RequestMapping("/product/loan")
    public String product() {
        return "/product/loan";
    }

    /** 产品 展示借出/投标产品 shaokang **/
    @RequestMapping("/product/borrow")
    public String productBorrow() {
        return "/product/borrow";
    }

    /** 产品/信贷 shaokang **/
    @RequestMapping("/product/loan/creditOfBorrow")
    public String creditOfLoans() {
        return "/product/creditOfBorrow";
    }

}
