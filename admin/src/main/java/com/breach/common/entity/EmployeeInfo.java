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
 * @since 2019-01-17
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class EmployeeInfo extends Model<EmployeeInfo> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String employeeName;

    private String employeeTelephone;

    /**
     * 入职时间
     */
    private LocalDateTime employeeHiredate;

    /**
     * 状态 离职-在职-
     */
    private Integer employeeState;

    /**
     * 部门ID
     */
    private Integer departmentId;

    /**
     * 角色ID
     */
    private Integer employeeRoleId;

    /**
     * 绑定员工登陆账号
     */
    private Integer employeeAccountId;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
