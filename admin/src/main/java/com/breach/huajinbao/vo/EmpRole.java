package com.breach.huajinbao.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.apache.commons.lang3.builder.ToStringExclude;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author shaokang
 * @since 2019-01-03
 */
@Data
@ToString
public class EmpRole {


    private Integer id;

    /**
     * 角色名
     */
    private String name;

    /**
     * 角色描述信息
     */
    private String description;



}
