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
 * 
 * </p>
 *
 * @author shaokang
 * @since 2019-01-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class ConsumerRepaymentType extends Model<ConsumerRepaymentType> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 还款方式描述
     */
    private String repaymentDescription;

    /**
     * 详细描述，本字段没有啥用，就是详细描述.
     */
    private String detail;

    /**
     * 还款的算法
     */
    private String algorithm;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
