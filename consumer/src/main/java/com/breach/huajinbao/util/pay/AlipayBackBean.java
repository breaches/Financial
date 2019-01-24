package com.breach.huajinbao.util.pay;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @program: Financial
 * @description:
 * @author: shaokang
 * @create: 2019-01-24 22:54
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AlipayBackBean {

     private Integer consumer_id;
     private String out_trade_no;
     private String trade_no;
     private BigDecimal total_amount;
     private String auth_app_id;
     private String app_id;
     private String seller_id;
     private String sign_type;
//     private LocalDateTime timestamp;
     private String method;

}
