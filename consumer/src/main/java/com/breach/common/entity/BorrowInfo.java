package com.breach.common.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.time.LocalDate;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author shaokang
 * @since 2019-01-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class BorrowInfo extends Model<BorrowInfo> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("consumerID")
    private Integer consumerID;

    /**
     * 发标金额
     */
    private Double money;

    /**
     * 借款日期
     */
    @TableField("beginDate")
    private LocalDate beginDate;

    /**
     * 还款日期
     */
    @TableField("endDate")
    private LocalDate endDate;

    /**
     * 筹资期
     */
    @TableField("collectingTime")
    private Integer collectingTime;

    /**
     * 还款方式
     */
    @TableField("repayWay")
    private Integer repayWay;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
