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
 * @since 2019-01-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class ConsumerCard extends Model<ConsumerCard> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 身份证号码
     */
    private String idNumber;

    /**
     * 身份证正面照片
     */
    private String frontOfIdNumber;

    /**
     * 身份证反面照片
     */
    private String reverseOfIdNumber;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
