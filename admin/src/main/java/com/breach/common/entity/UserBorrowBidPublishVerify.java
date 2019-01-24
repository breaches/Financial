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
 * @since 2019-01-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class UserBorrowBidPublishVerify extends Model<UserBorrowBidPublishVerify> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 关联申请发标/招标信息表的订单号（记录编号）
     */
    private String borrowNumber;

    /**
     * 审核人id，操作这条记录的员工id
     */
    private Integer employeeId;

    /**
     * 审核时间，
     */
    private LocalDateTime verifyTime;

    /**
     * 理由，招标发布的审核理由，不管有没有通过，这里有一个当时操作这条记录的员工留下来的审核理由
     */
    private String reason;

    /**
     * 招标发标审核 1：通过 2：不通过（控制是否发布这条标）
     */
    private Integer state;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
