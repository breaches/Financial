package com.breach.huajinbao.service.record;

import com.breach.huajinbao.util.record.EmpMonery;

import java.util.Map;

public interface IEmpService {

    Map<String, Object> getEmp(EmpMonery query);

    /**
     * 根据id获取用户
     * @param id
     * @return
     */
    EmpMonery getEditEmp(int id);
}
