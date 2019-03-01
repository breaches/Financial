package com.breach.huajinbao.service.record.Impl;

import com.breach.huajinbao.mapper.record.IEmpMapper;
import com.breach.huajinbao.service.record.IEmpService;
import com.breach.huajinbao.util.record.EmpMonery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class EmpServiceImpl implements IEmpService {

    @Autowired
    private IEmpMapper empMapper;

   @Override
    public Map<String, Object> getEmp(EmpMonery query){
       List<Map<String, Object>> empList = empMapper.getEmp(query);
       Integer total = empMapper.getEmpTotal(query);
       Map<String, Object> map = new HashMap<>();
       map.put("data",empList);
       map.put("total",total);
           return map;
   }

    @Override
    public EmpMonery getEditEmp(int id) {
        return empMapper.getEmpByID(id);
    }

}
