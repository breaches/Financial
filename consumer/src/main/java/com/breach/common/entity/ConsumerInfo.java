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
 * @since 2019-01-24
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class ConsumerInfo extends Model<ConsumerInfo> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 用户名
     */
    private String nickname;

    /**
     * 用户真实姓名
     */
    private String name;

    /**
     * 性别 0：女 1：男
     */
    private Boolean sex;

    /**
     * 绑定的手机号码
     */
    private String phone;

    /**
     * 头像
     */
    private String avatar;

    private Boolean isCar;

    /**
     * 是否有房
     */
    private Boolean isHouse;

    /**
     * 婚姻状态
     */
    private Boolean isMarry;

    /**
     * 用户关联的账户信息
     */
    private Integer accountId;

    /**
     * 关联用户地址表
     */
    private Integer addressId;

    /**
     * 关联用户学历信息表
     */
    private Integer educationId;

    /**
     * 关联用户的工作信息表
     */
    private Integer wordId;

    /**
     * 关联vip信息表 超级用户 VIP
     */
    private Integer vipId;

    /**
     * 关联用户身份证表
     */
    private Integer cardId;

    /**
     * 用户审额的状态 1：未审额/从未申请 2：已提交/待审核/已申请 3：未通过 4：已通过
     */
    private Integer verifyState;

    /**
     * 表示当前用户的状态 1：正常 2：冻结
     */
    private Integer state;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
