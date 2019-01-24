package com.breach.common.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableId;
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
 * @since 2019-01-24
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class ConsumerTopUpAlipayRecord extends Model<ConsumerTopUpAlipayRecord> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 用户的id编号
     */
    private Integer consumerId;

    /**
     * 我们的订单编号
     */
    private String outTradeNo;

    /**
     * 支付宝的订单编号
     */
    private String tradeNo;

    /**
     * 本此充值金额
     */
    private BigDecimal totalAmount;

    /**
     * 授权应用id
     */
    private String authAppId;

    /**
     * 应用id
     */
    private String appId;

    /**
     * 商户id，不清楚啥意思
     */
    private String sellerId;

    /**
     * 加密方式
     */
    private String signType;

    /**
     * 充值成功的时间
     */
    private LocalDateTime timestamp;

    /**
     * 方法，是用什么方法
     */
    private String method;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
