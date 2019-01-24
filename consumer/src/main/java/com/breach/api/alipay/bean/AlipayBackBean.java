package com.breach.api.alipay.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @program: demoqq
 * @description:
 * @author: shaokang
 * @create: 2019-01-23 22:19
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AlipayBackBean {
    // 商户订单编号
    private String out_trade_no;
    // 付款总额
    private BigDecimal total_amount;
    // 支付宝订单编号
    private String trade_no;
    // 应用id
    private String auth_app_id;
    private String seller_id;
    // 版本
    private String version;
    // 时间
    private String timestamp;
}
