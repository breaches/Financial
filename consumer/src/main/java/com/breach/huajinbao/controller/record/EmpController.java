package com.breach.huajinbao.controller.record;

import com.breach.huajinbao.service.record.IEmpService;
import com.breach.huajinbao.util.record.EmpMonery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/emp")
public class EmpController {
    @Autowired
    private IEmpService empService;
    @RequestMapping("/getEmp")
    public Map<String, Object> getEmp(@RequestBody EmpMonery query){
        System.out.println(query.toString());
        return empService.getEmp(query);
    }
    @RequestMapping("/getEditEmp")
    public EmpMonery  getEditEmp(int id){
        return empService.getEditEmp(id);
    }


}
