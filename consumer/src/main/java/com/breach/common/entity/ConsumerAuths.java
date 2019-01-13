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
 * 用户登录授权表
目前两种方式直接进行登录：
用户名
手机号码
 * </p>
 *
 * @author shaokang
 * @since 2019-01-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class ConsumerAuths extends Model<ConsumerAuths> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 关联用户信息表，当前账号绑定的是哪个用户
     */
    private Integer consumerId;

    /**
     * 客户状态 1：可用 2：冻结
     */
    private Integer state;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
