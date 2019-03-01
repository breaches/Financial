package com.breach.huajinbao.controller.topup;

import com.alipay.api.AlipayApiException;
import com.breach.huajinbao.util.pay.AlipayBackBean;
import com.breach.huajinbao.service.topup.ITopUpService;
import com.breach.huajinbao.util.pay.AlipayBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description: 充值页面跳转
 * @Param:
 * @return:  
 * @Author: wanghe
 * @Date:
 */ 
@Controller
public class JumpForController {

    @Autowired
    ITopUpService topUpService;

    /** 充值页面 wanghe **/
    @RequestMapping("/topup")
    public String index1() {
        return "topup/consumerTopUp";
    }
    /** 支付宝充值 **/
    @RequestMapping("/zhifubao")
    public String index2() {
        return "/topup/consumer_zhifubao";
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
    /** 系统通知界面 **/
    @RequestMapping("/message")
    public String index6() {
        return "message/messagePage";
    }
    @RequestMapping("/moneyrecord")
    public String index7(){ return "record/MoneryRecord";}

    /**
     * 调用支付接口
     * @param alipayBean
     * @return
     */
    @ResponseBody
    @RequestMapping("/pay/alipay")
    public String alipay( AlipayBean alipayBean) {
        System.out.println("0000000000000000000000000000000000000000");
        System.out.println("alipay");
        System.out.println("0000000000000000000000000000000000000000");
        try {
            return topUpService.alipay(alipayBean);
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        return "11111";
    }

    @RequestMapping("/pay/alipay/back")
    public String alipayBack(AlipayBackBean alipayBackBean) {
        return topUpService.alipayBack(alipayBackBean);
    }


}
