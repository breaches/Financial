package com.breach.huajinbao.service.base;

import java.util.List;
import java.util.Map;

import com.breach.common.entity.EmployeeAccount;
import com.breach.common.entity.EmployeeInfo;
import com.breach.huajinbao.util.base.EmployeeQuery;

import com.breach.huajinbao.util.base.Result;

public interface IEmployeeService {

	/**
	 * 用户登录
	 * @param login
	 * @return
	 */
	Result empLogin(EmployeeAccount login);

	/**
	 * 获取当前登录用户的权限
	 * @return
	 */
	List<Map> getPermission();

	/***
	 * 分页 +  搜索 获取员工
	 * @param query
	 * @return wanghehe test
	 */
	Map getEmp(EmployeeQuery query);

	
	/**
	 * 获取部门数据
	 * @return
	 */
	List<Map> getDept();
    /**
     * 获取 角色信息
     * @return
     */
	List<Map> getRole();
    /**
     * 获取 部门和 角色
     * @return
     */
	Map getDeptAndRole();
    /**
     * 添加员工
     * @param e
     * @return
     */
	Result addEmp(EmployeeInfo e);
     
	/**
	 * 批量删除员工
	 * @param ids
	 * @return
	 */
	Result deleteEmp(int[] ids);
    /**
     * 
     * 根据id获取员工
     * @param id
     * @return
     */
	EmployeeInfo getEditEmp(int id);
    /**
     * 修改员工
     * @param e
     * @return
     */
	Result editEmp(EmployeeInfo e);

}











