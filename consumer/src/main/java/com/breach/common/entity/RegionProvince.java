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
 * 该实体为行政区域划分等级
 * </p>
 *
 * @author shaokang
 * @since 2019-01-11
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class RegionProvince extends Model<RegionProvince> {

    private static final long serialVersionUID = 1L;

    private String id;

    /**
     * 省份代码
     */
    @TableId(value = "code_province", type = IdType.AUTO)
    private String codeProvince;

    /**
     * 省份名
     */
    private String name;


    @Override
    protected Serializable pkVal() {
        return this.codeProvince;
    }

}
