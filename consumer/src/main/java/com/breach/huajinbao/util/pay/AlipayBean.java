package com.breach.huajinbao.util.pay;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @program: Financial
 * @description:
 * @author: shaokang
 * @create: 2019-01-24 10:13
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AlipayBean {
    private BigDecimal amount;
    private Integer consumerID;
    private Integer accountID;
}
