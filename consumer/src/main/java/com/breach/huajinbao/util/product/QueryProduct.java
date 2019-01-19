package com.breach.huajinbao.util.product;

import ch.qos.logback.core.rolling.helper.IntegerTokenConverter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.awt.print.PrinterGraphics;
import java.io.Serializable;

/**
 * @program: Financial
 * @description:
 * @author: shaokang
 * @create: 2019-01-19 14:33
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class QueryProduct implements Serializable {

    private static final long serialVersionUID = 1L;

    /**分页条件**/
    private Integer pageCurrent;
    private Integer pageSize;

    /**项目期限**/
    private Integer defaultTerm;
    private Integer minTerm;
    private Integer maxTerm;

    /**参考利率**/
    private Integer defaultTAnnualRate;
    private Integer minAnnualRate;
    private Integer maxAnnualRate;

    /**还款方式**/
    private Integer defaultRepayType;
    private Integer repayType;

    /**剩余金额**/
    private Integer defaultSurplusAmount;
    private Integer minSurplusAmount;
    private Integer maxSurplusAmount;

    /**默认排序**/
    private Integer normalSort;

    /**参考利率排序方式**/
    private Integer annualRateSort;

    /**期限排序方式**/
    private Integer termSort;

    /**剩余金额排序方式**/
    private Integer surplusAmountSort;

    public Integer getPageCurrent() {
        return (this.pageCurrent - 1) * this.pageSize;
    }
}

