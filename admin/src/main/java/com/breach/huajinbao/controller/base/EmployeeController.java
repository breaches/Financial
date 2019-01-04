package com.breach.huajinbao.controller.base;

import java.util.List;
import java.util.Map;

import com.breach.common.entity.EmployeeAccount;
import com.breach.common.entity.EmployeeInfo;
import com.breach.huajinbao.util.base.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.breach.huajinbao.util.base.EmployeeQuery;
import com.breach.huajinbao.service.base.IEmployeeService;


@RestController
@RequestMapping("/emp")
public class EmployeeController {

    // test
    @Autowired
    private IEmployeeService empService;

    //test2
    @RequestMapping("/login")
    public Result empLogin(@RequestBody EmployeeAccount login) {
        return empService.empLogin(login);
    }

    // chen
    @RequestMapping("/getPermission")
    public List<Map> getPermission() {
        return empService.getPermission();
    }

    @RequestMapping("/getEmp")
    public Map getEmp(@RequestBody EmployeeQuery query) {
        return empService.getEmp(query);
    }

    // agaaaqaaaasdasd
    @RequestMapping("/getDeptAndRole")
    public Map getDeptAndRole() {
        return empService.getDeptAndRole();
    }
    //qqqq
    @RequestMapping("/addEmp")
    public Result addEmp(@RequestBody EmployeeInfo e) {
        return empService.addEmp(e);
    }

    @RequestMapping("/deleteEmp")
    public Result deleteEmp(@RequestBody int[] ids) {
        return empService.deleteEmp(ids);
    }

    @RequestMapping("/getEditEmp")
    public EmployeeInfo getEditEmp(int id) {
        return empService.getEditEmp(id);
    }

    @RequestMapping("/editEmp")
    public Result editEmp(@RequestBody EmployeeInfo e) {
        return empService.editEmp(e);
    }

}










