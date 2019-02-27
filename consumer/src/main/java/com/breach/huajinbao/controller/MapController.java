package com.breach.huajinbao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    /** 产品 展示借款（借出）/借贷产品 shaokang **/
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
    @RequestMapping("/product/borrow/creditOfBorrow")
    public String creditOfLoans() {
        return "/product/borrow/creditOfBorrow";
    }

    /** 产品/信贷（借入） 散标 shaokang **/
    @RequestMapping("/product/borrow/personBorrowBid")
    public String personBorrow() {
        return "/product/borrow/personBorrowBid";
    }

    /** 产品/信贷（借入） 散标商品列表页面 shaokang **/
    @RequestMapping("/product/loan/personBid")
    public String personBid() {
        return "/product/loan/personBid";
    }

    /** 产品/信贷（借入） 详情页面 商品列表页请求跳转到商品详情页面 shaokang **/
    @RequestMapping("/product/loan/common/{a}")
    public String commonBid() {
        return "/product/loan/personBidDetail";
    }
    /**用户问卷调查表**/
    @RequestMapping("/question")
    public String question(){
        return "/consumer/Questionnaire";
    }

}
