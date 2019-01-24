package com.breach.huajinbao.util.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @program: Financial
 * @description:
 * @author: shaokang
 * @create: 2019-01-22 20:22
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TradingInfo {
//    private Integer consumerId;
    private String borrowNumber;
    private BigDecimal amount;
    private Integer pageCurrent;
    private Integer pageSize;

    public Integer getPageCurrent() {
        return (pageCurrent-1) * this.pageSize;
    }

    /**保留两位小数**/
    public BigDecimal getAmount() {
        return amount.setScale(2, BigDecimal.ROUND_HALF_UP);
    }
}
