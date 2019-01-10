package com.breach.huajinbao.controller.topup;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description: 充值页面跳转
 * @Param:
 * @return:  
 * @Author: wanghe
 * @Date:
 */ 
@Controller
public class TopUpController {

    /** 充值页面 wanghe **/
    @RequestMapping("/topup")
    public String index1() {
        return "topup/consumerTopUp";
    }
    /** 支付宝充值 **/
    @RequestMapping("/zhifubao")
    public String index2() {
        return "topup/consumer_zhifubao";
    }
    /** 微信充值 **/
    @RequestMapping("/weixin")
    public String index3() {
        return "topup/consumer_weixin";
    }
    /** 银联充值 **/
    @RequestMapping("/yinlian")
    public String index4() {
        return "topup/consumer_yinlian";
    }

    /** 提现页面 **/
    @RequestMapping("/withdrawalpage")
    public String index5() {
        return "withdrawal/withdrawal";
    }

}
