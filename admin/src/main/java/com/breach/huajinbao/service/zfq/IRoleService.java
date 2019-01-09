package com.breach.huajinbao.service.zfq;

import com.breach.common.entity.EmployeeRole;
import com.breach.huajinbao.util.base.Result;
import com.breach.huajinbao.util.zfq.RoleQuery;
import com.breach.huajinbao.vo.EmpRole;

import java.util.Map;

public interface IRoleService {
    Map getRole(RoleQuery e);

    Result addRole(EmpRole e);

    Result deleteRole(int[] ids);

    EmpRole getEditRole(int id);

    Result editRole(EmpRole e);
}
