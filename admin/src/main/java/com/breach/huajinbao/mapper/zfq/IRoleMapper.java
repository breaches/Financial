package com.breach.huajinbao.mapper.zfq;

import com.breach.common.entity.EmployeeRole;
import com.breach.huajinbao.util.base.Result;
import com.breach.huajinbao.util.zfq.RoleQuery;
import com.breach.huajinbao.vo.EmpRole;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface IRoleMapper {
    //获取
    Map getRole(RoleQuery e);
    //
    List<Map> getEmp(RoleQuery e);

    Integer getEmpTotal(RoleQuery e);

    void addRole(EmpRole e);


    void deleteRole(int[] ids);

    EmpRole getEditRole(int id);

    void editRole(EmpRole e);
}
