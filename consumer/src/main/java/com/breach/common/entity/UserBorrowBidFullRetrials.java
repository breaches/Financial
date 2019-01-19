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
 * @since 2019-01-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class UserBorrowBidFullRetrials extends Model<UserBorrowBidFullRetrials> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 绑定发标的申请编号
     */
    private String borrowNumber;

    /**
     * 操作的员工id
     */
    private Integer employeeId;

    /**
     * 满标复审的审核时间
     */
    private LocalDateTime varifyTime;

    /**
     * 满标复审的审核理由
     */
    private String reason;

    /**
     * 满标复审，满标再审，1：通过 2：不通过
     */
    private Integer state;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
