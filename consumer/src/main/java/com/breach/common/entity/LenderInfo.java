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
public class LenderInfo extends Model<LenderInfo> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 发标人ID
     */
    @TableField("borrowId")
    private Integer borrowId;

    @TableField("consumerID")
    private Integer consumerID;

    /**
     * 投标金额
     */
    private Integer money;

    /**
     * 投标时间
     */
    private LocalDate time;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
