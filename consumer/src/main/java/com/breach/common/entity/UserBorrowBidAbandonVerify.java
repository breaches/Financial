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
public class UserBorrowBidAbandonVerify extends Model<UserBorrowBidAbandonVerify> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 绑定发标/招标的信息表的 信息记录编号
     */
    private String borrowNumber;

    /**
     * 操作这条记录的员工id
     */
    private Integer employeeId;

    /**
     * 审核时间，流标的审核时间
     */
    private LocalDateTime verifyTime;

    /**
     * 流标理由，废弃理由(系统发现此标已经超了招募的时间，并且没有达到满标的条件，此时，系统应把此标放入此表）
     */
    private String reason;

    /**
     * 流标（废标）的状态 1：废弃 2：没有废弃（一般如果这个标流标了，就会存到这张表中，一般都是废弃表存进来）
     */
    private Integer state;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
