package com.breach.huajinbao.controller.topup;

import com.breach.huajinbao.service.topup.ITopUpSerivice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Created by wanghehe on 2019年01月11日
 * 支付宝充值控制层
 */
@RequestMapping("/ipay")
@RestController
public class TopUpController {


    @Autowired
    private ITopUpSerivice topUpSerivice;

    /**
     * 生成充值订单编号
     * @param
     * @return
     *
     */
    @RequestMapping("/orderNumber")
    public String orderNumber(){

        return topUpSerivice.orderNumber();

    }



}
