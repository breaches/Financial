package com.breach.common.entity;

import java.math.BigDecimal;
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
 * @since 2019-01-22
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class UserBorrowBidApplyRecord extends Model<UserBorrowBidApplyRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * 编列序号
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 招标申请记录单号
     */
    private String borrowNumber;

    /**
     * 借款人id，发标用户id
     */
    private Integer userId;

    /**
     * 用户的真实姓名
     */
    private String name;

    /**
     * 借款实际金额
     */
    private BigDecimal borrowMoney;

    /**
     * 剩余金额，还差多少钱达到自己需要借钱的总数
     */
    private BigDecimal surplusAmount;

    /**
     * 借款期限，借多久，借多少个月，月单位
     */
    private Integer borrowTimeLimit;

    /**
     * 关联偿还类型表（consumer_repayment_type），还款方式，等额本息，等额本金扽等
     */
    private Integer repayType;

    /**
     * 利率，年利率，使用小数存储百分数
     */
    private BigDecimal lendingRate;

    /**
     * 借款描述，借款人的借款理由
     */
    private String borrowDescription;

    /**
     * 还款来源，一个描述，用户写明的还款来源
     */
    private String payment;

    /**
     * 产品名：个人散标、经营贷等等
     */
    private String productName;

    /**
     * 招标时间期限关联，招标天数，共招多少天
     */
    private Integer biddingTimeLimit;

    /**
     * 招标信息的申请时间，招标信息的创建时间
     */
    private LocalDateTime createTime;

    /**
     * 发布时间(招标通过的时间)，通过后台的审核时间
     */
    private LocalDateTime publishTime;

    /**
     * 招标开始时间，招募开始时间
     */
    private LocalDateTime startBuyTime;

    /**
     * 招标结束时间，招募结束时间
     */
    private LocalDateTime endBuyTime;

    /**
     * 满标时间(yuan)
     */
    private LocalDateTime fullTenderTime;

    /**
     * 期满时间，过期时间（）一个月为一期
     */
    private LocalDateTime expireDate;

    /**
     * 起息日，计息日，生效日(满标日，满标通过）
     */
    private LocalDateTime valueDate;

    /**
     * 招标初审/发布审核的操作表id
     */
    private Integer publishId;

    /**
     * 满标初审/的关联id
     */
    private Integer tralsId;

    /**
     * 满标复审/满标审核表的关联id
     */
    private Integer retralsId;

    /**
     * 流标/废标审核表的关联id
     */
    private Integer abandonId;

    /**
     * 控制版本，为了安全。
     */
    private Integer version;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
