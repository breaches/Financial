package com.breach.huajinbao.controller.zfq;

import com.breach.huajinbao.service.zfq.IRoleService;
import com.breach.huajinbao.util.base.Result;
import com.breach.huajinbao.util.zfq.RoleQuery;
import com.breach.huajinbao.vo.EmpRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/role")
public class RoleController {

@Autowired
private IRoleService roleService ;
        /**
         * @Description:
         * @Param:
         * @return:
         * @Author: 赵富强
         * @Date: 2019-01-08 16:22
         */
    @RequestMapping("/getRole")
    public Map getEmp(@RequestBody RoleQuery e) {
        return roleService.getRole(e);
    }

    @RequestMapping("/addrole")
    public Result addRole(@RequestBody EmpRole e) {
        System.out.println(e);
        return roleService.addRole(e);
    }


    /**
     * @Description:  
     * @Param:  
     * @return:  
     * @Author: 赵富强
     * @Date: 2019-01-08 16:30
     */ 
    
    @RequestMapping("/deleteRole")
    public Result deleteRole(@RequestBody int[] ids) {
        return roleService.deleteRole(ids);
    }

    @RequestMapping("/getEditRole")
    public EmpRole getEditRole(int id) {
        return roleService.getEditRole(id);
    }


    @RequestMapping("/editRole")
    public Result editRole(@RequestBody EmpRole e) {
        return roleService.editRole(e);
    }
}
