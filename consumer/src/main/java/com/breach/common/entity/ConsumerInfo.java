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
public class ConsumerInfo extends Model<ConsumerInfo> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 用户姓名
     */
    private String name;

    /**
     * 性别 0：女 1：男
     */
    private Boolean sex;

    /**
     * 是否有房
     */
    private Boolean isHouse;

    /**
     * 婚姻状态
     */
    private Boolean isMarry;

    /**
     * 关联用户身份证表
     */
    private Integer cardId;

    /**
     * 关联用户地址表
     */
    private Integer addressId;

    /**
     * 关联用户学历信息表
     */
    private Integer educationId;

    /**
     * 关联vip信息表 超级用户 VIP
     */
    private Integer supperConsumer;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
