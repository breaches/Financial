package com.breach.common.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
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
public class ConsumerAccount extends Model<ConsumerAccount> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 用户账号
     */
    private String consumerUsername;

    /**
     * 用户密码
     */
    private String consumerPassword;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 账号状态 0：冻结 1：可登录
     */
    private Boolean state;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
