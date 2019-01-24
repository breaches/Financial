package com.breach.common.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.time.LocalDate;
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
public class ConsumerCard extends Model<ConsumerCard> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 真实姓名
     */
    private String name;

    /**
     * 身份证号码
     */
    private String code;

    /**
     * 性别 0：女 1：男
     */
    private Boolean sex;

    /**
     * 出生日期
     */
    private LocalDate brithday;

    /**
     * 省份
     */
    private String province;

    /**
     * 城市
     */
    private String city;

    /**
     * 地区
     */
    private String area;

    /**
     * 身份证正面照
     */
    private String frontImage;

    /**
     * 身份证反面照
     */
    private String backImage;

    /**
     * 证件状态 0：失效 1：有效
     */
    private Boolean state;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
