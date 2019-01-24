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
 * @since 2019-01-24
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class UserBorrowBidFullTrials extends Model<UserBorrowBidFullTrials> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 关联招标记录的编号
     */
    private String borrowNumber;

    /**
     * 操作的员工id
     */
    private Integer employeeId;

    /**
     * 满标初审时间
     */
    private LocalDateTime verifyTime;

    /**
     * 满标初审的审核理由
     */
    private String reason;

    /**
     * 满标初审状态(1：通过，2：不通过）
     */
    private Integer state;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
