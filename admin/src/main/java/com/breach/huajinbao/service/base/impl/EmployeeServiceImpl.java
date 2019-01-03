package com.breach.huajinbao.service.base.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.breach.common.entity.EmployeeAccount;
import com.breach.common.entity.EmployeeInfo;
import com.breach.huajinbao.util.base.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.breach.huajinbao.mapper.base.IEmployeeMapper;
import com.breach.huajinbao.util.base.EmployeeQuery;
import com.breach.huajinbao.service.base.IEmployeeService;
import com.breach.huajinbao.util.base.EmployeeSessionUtil;



@Service
public class EmployeeServiceImpl implements IEmployeeService {

	@Autowired
	private IEmployeeMapper empMapper;

    /**
     * 1 数据库 校验 账号密码是否正确 如果不正确 返回 400
     * 2 如果正确 返回 登录id 再根据登录id 获取当前登录用户信息
     * 3 判断当前用户的状态 是否为 离职 如果离职 返回 300
     * 4 如果没有离职 则将当前用户存储到session 并返回200
     */
	public Result empLogin(EmployeeAccount login) {

		Integer id = empMapper.empLogin(login);

		if(id == null) {
			return new Result(400, "对不起 账号或密码错误");
		}

		EmployeeInfo emp = empMapper.getEmpByLoginID(id);

		if(emp.getEmployeeState() == 0){
			return new Result(300, "对不起 账号被冻结 请联系管理员");
		}

		EmployeeSessionUtil.setEmp(emp);

		return new Result(200, "登录成功");
	}

	/**
	 * 1 获取session中的用户
	 * 2 根据用户的roleID 获取对应的权限
	 */
	public List<Map> getPermission() {
		EmployeeInfo emp = EmployeeSessionUtil.getEmp();
		return empMapper.getPermission(emp.getEmployeeRoleId());
	}

    /**
     * 分页 +  搜索
     * 1 查询符合 搜索+分页 的 员工数据
     * 2 查询符合 搜索 的 员工 总数
     * 3 将其封装到 map中并返回
     *   {
     *      empData：[{},{},{}],
     *      empTotal:15
     *   }
     */
	public Map getEmp(EmployeeQuery query) {

		List<Map> data =  empMapper.getEmp(query);
		Integer total =  empMapper.getEmpTotal(query);

		HashMap map = new HashMap();

		map.put("empData", data);
		map.put("empTotal", total);

		return map;
	}

	@Override
	public List<Map> getDept() {
		return empMapper.getDept();
	}

	@Override
	public List<Map> getRole() {
		return empMapper.getRole();
	}

	@Override
	public Map getDeptAndRole() {

		Map map = new HashMap<>();

		map.put("dept", empMapper.getDept());
		map.put("role", empMapper.getRole());

		return map;
	}

    /**
     *  添加员工
     *  0 手机号唯一性校验
     *  1 添加 账号 密码 并获取 主键
     *    账号 ： 手机号              密码：123456
     *  2 添加员工 和 loginID
     *  3 返回结果
     */
	@Override
	public Result addEmp(EmployeeInfo e) {

		EmployeeAccount employeeAccount = new EmployeeAccount();
		employeeAccount.setId(0);
		employeeAccount.setEmployeeUsername(e.getEmployeeTelephone());
		employeeAccount.setEmployeePassword("123456");

		empMapper.addLoginAccount(employeeAccount);

	    e.setEmployeeAccountId(employeeAccount.getId());
	    empMapper.addEmp(e);

		return new Result(200, "添加成功");
	}

	@Override
	public Result deleteEmp(int[] ids) {
		empMapper.deleteEmp(ids);
		return new Result(200, "删除成功");
	}

	@Override
	public EmployeeInfo getEditEmp(int id) {
		return empMapper.getEmpByID(id);
	}

	@Override
	public Result editEmp(EmployeeInfo e) {
		empMapper.editEmp(e);
		return new Result(200, "修改成功");
	}

}
















