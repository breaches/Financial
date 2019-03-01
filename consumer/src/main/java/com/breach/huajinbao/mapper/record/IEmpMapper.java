package com.breach.huajinbao.mapper.record;

import com.breach.huajinbao.util.record.EmpMonery;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
@Repository
public interface IEmpMapper {

    List<Map<String,Object>> getEmp(EmpMonery query);

    Integer getEmpTotal(EmpMonery query);

    EmpMonery getEmpByID(int id);
}
