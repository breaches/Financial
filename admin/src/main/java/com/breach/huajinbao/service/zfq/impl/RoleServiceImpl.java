package com.breach.huajinbao.service.zfq.impl;

import com.breach.common.entity.EmployeeRole;
import com.breach.huajinbao.mapper.zfq.IRoleMapper;
import com.breach.huajinbao.service.zfq.IRoleService;
import com.breach.huajinbao.util.base.Result;
import com.breach.huajinbao.util.zfq.RoleQuery;
import com.breach.huajinbao.vo.EmpRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class RoleServiceImpl implements IRoleService {



    @Autowired
    private IRoleMapper roleMapper;
    @Override
    public Map getRole(RoleQuery e) {

        List<Map> data =  roleMapper.getEmp(e);
        Integer total =  roleMapper.getEmpTotal(e);

        HashMap map = new HashMap();

        map.put("empData", data);
        map.put("empTotal", total);

        return map;
    }

    @Override
    public Result addRole(EmpRole e) {
        roleMapper.addRole(e);
        return new Result(200,"添加成功");
    }

    @Override
    public Result deleteRole(int[] ids) {
        roleMapper.deleteRole(ids);
        return new Result(200,"删除成功");
    }

    @Override
    public EmpRole getEditRole(int id) {
        return roleMapper.getEditRole(id);
    }

    @Override
    public Result editRole(EmpRole e) {
        roleMapper.editRole(e);
        return new Result(200,"修改成功");

    }

}
