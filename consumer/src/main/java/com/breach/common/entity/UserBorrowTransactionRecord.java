package com.breach.common.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
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
 * @since 2019-01-22
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class UserBorrowTransactionRecord extends Model<UserBorrowTransactionRecord> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 用户id,是谁购买的标
     */
    private Integer consumerId;

    /**
     * 订单编号
     */
    private Integer borrowNumber;

    /**
     * 订单的id
     */
    private Integer borrowId;

    /**
     * 交易总额
     */
    private BigDecimal tradingAmount;

    /**
     * 什么时间购买的标
     */
    private LocalDateTime createTime;

    /**
     * 存储ip地址
     */
    private String ip;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
