package com.breach.common.entity;

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
 * @since 2019-01-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class ConsumerAccount extends Model<ConsumerAccount> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
