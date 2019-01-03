package com.breach.huajinbao.mapper.base;

import java.util.List;
import java.util.Map;

import com.breach.common.entity.EmployeeAccount;
import com.breach.common.entity.EmployeeInfo;
import com.breach.huajinbao.util.base.EmployeeQuery;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface IEmployeeMapper {

    @Select("select id from employee_account where employee_username=#{employeeUsername} and employee_password=#{employeePassword}")
    Integer empLogin(EmployeeAccount login);

    EmployeeInfo getEmpByLoginID(Integer id);

    List<Map> getPermission(int roleID);

    List<Map> getEmp(EmployeeQuery query);

    Integer getEmpTotal(EmployeeQuery query);

    List<Map> getDept();

    List<Map> getRole();

    void addLoginAccount(EmployeeAccount login);

    void addEmp(EmployeeInfo e);

    void deleteEmp(int[] ids);

    EmployeeInfo getEmpByID(int id);

    void editEmp(EmployeeInfo e);
}
