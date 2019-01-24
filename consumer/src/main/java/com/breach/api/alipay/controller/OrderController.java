package com.breach.api.alipay.controller;

import com.alipay.api.AlipayApiException;
import com.breach.api.alipay.bean.AlipayBean;
import com.breach.api.alipay.service.PayService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @program: demoqq
 * @description:
 * @author: shaokang
 * @create: 2019-01-23 21:27
 **/
@RestController()
@RequestMapping("order")
public class OrderController {
    @Resource
    private PayService payService;//调用支付服务

    /*阿里支付*/
    @PostMapping(value = "alipay")
    public String alipay(String out_trade_no, String subject, String total_amount, String body) throws AlipayApiException, AlipayApiException {

        String s = payService.aliPay(new AlipayBean()
                .setBody(body)
                .setOut_trade_no(out_trade_no)
                .setTotal_amount(new StringBuffer().append(total_amount))
                .setSubject(subject));
        System.out.println(s);
        return s;
    }



    @RequestMapping("/aaa")
    public String aaa() {
        return "aaaaaaaaaaaaaaaa";
    }
}
