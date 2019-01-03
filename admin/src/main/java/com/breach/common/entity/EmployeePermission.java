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
 * @since 2019-01-03
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class EmployeePermission extends Model<EmployeePermission> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 父权限
     */
    private Integer parentId;

    /**
     * 目标链接
     */
    private String url;

    /**
     * 权限名
     */
    private String name;

    /**
     * 描述
     */
    private String description;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
