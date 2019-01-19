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
 * @since 2019-01-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class RegionArea extends Model<RegionArea> {

    private static final long serialVersionUID = 1L;

    private String id;

    /**
     * 地区代码
     */
    @TableId(value = "code_area", type = IdType.AUTO)
    private String codeArea;

    /**
     * 地区名
     */
    private String name;

    /**
     * 所属城市的城市代码
     */
    private String codeCity;


    @Override
    protected Serializable pkVal() {
        return this.codeArea;
    }

}
