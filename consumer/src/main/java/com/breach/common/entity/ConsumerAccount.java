package com.breach.common.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 账户表
包含该用户的：全部余额，可用余额，冻结金额，
全部余额 = 可用余额 + 冻结金额
可用余额 = 全部余额 - 冻结金额
冻结金额 = 投标空缺期
 * </p>
 *
 * @author shaokang
 * @since 2019-01-15
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class ConsumerAccount extends Model<ConsumerAccount> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 信用额度，总信用额度，总共可用的信用额度，赊账金额
     */
    private BigDecimal creditAmount;

    /**
     * 信用额度，剩余额度
     */
    private BigDecimal creditBalance;

    /**
     * 可用余额，包括充值、还我的钱、收益
     */
    private BigDecimal availableBalance;

    /**
     * 表示借出去的钱，还有多少未还给我，每还一次这里都会进行一次更新
     */
    private BigDecimal principalMoney;

    /**
     * 主要入息，也就是将要收的红利，利润，收益。每收到一笔收益，这里都会进行更新
     */
    private BigDecimal principalIncome;

    /**
     * 冻结资金
     */
    private BigDecimal frozenCapital;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
