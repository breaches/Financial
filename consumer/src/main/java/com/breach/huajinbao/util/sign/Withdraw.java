package com.breach.huajinbao.util.sign;

import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;

/**
 * @program: Financial
 * @description:
 * @author: shaokang
 * @create: 2019-02-22 15:46
 **/
@Data
@ToString
public class Withdraw {
    private String name;
    private String card;
    private BigDecimal money;
    private BigDecimal commission;
}
