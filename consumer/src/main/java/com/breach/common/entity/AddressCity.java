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
 * @since 2019-01-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class AddressCity extends Model<AddressCity> {

    private static final long serialVersionUID = 1L;

    private String id;

    /**
     * 城市代码
     */
    @TableId(value = "code_city", type = IdType.AUTO)
    private String codeCity;

    /**
     * 城市名
     */
    private String name;

    /**
     * 所属省份的省份代码
     */
    private String codeProvince;


    @Override
    protected Serializable pkVal() {
        return this.codeCity;
    }

}
