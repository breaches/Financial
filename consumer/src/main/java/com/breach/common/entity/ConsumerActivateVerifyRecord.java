package com.breach.common.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.time.LocalDate;
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
 * @since 2019-01-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class ConsumerActivateVerifyRecord extends Model<ConsumerActivateVerifyRecord> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 表示订单编号 审核单的编号
     */
    private String recordNumber;

    /**
     * 关联的用户id，是哪一个用户提交的额度申请
     */
    private Integer consumerId;

    /**
     * 用户的真实姓名
     */
    private String name;

    /**
     * 身份证号码
     */
    private String code;

    /**
     * 存放银行卡号码
     */
    private String bankCode;

    /**
     * 性别 0：女 1：男
     */
    private Boolean sex;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 生日
     */
    private LocalDate birthday;

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
     * 是否单身 0：否 1：是
     */
    private Boolean isSingle;

    /**
     * 是否有车 0 无 1 有
     */
    private Boolean isHaveCar;

    /**
     * 是否有房 0：无 1：有
     */
    private Boolean isHaveHouse;

    /**
     * 关联学历表
     */
    private Integer educationId;

    /**
     * 关联收入范围表 填写对应的主键即可
     */
    private Integer incomeRangeId;

    /**
     * 详细联系地址
     */
    private String address;

    /**
     * 与紧急联系人的关系
     */
    private String contactsRelation;

    /**
     * 紧急联系人姓名
     */
    private String contactsName;

    /**
     * 紧急联系人的联系方式
     */
    private String contactsPhone;

    /**
     * 省份代码
     */
    private Integer codeProvince;

    /**
     * 城市代码
     */
    private Integer codeCity;

    /**
     * 地区代码
     */
    private Integer codeArea;

    /**
     * 身份证正面图片
     */
    private String idCardFrontImage;

    /**
     * 身份证背面图片
     */
    private String idCardBackImage;

    /**
     * 操作这条数据的员工
     */
    private Integer employeeId;

    /**
     * 申请额度的状态 1：未审核 2：通过 3：不通过
     */
    private Integer state;

    /**
     * 额度申请的创建时间
     */
    private LocalDateTime createTime;

    /**
     * 操作时间、审核时间
     */
    private LocalDateTime operateTime;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
