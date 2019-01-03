package com.breach.huajinbao.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.breach.common.entity.EmployeeInfo;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.breach.huajinbao.util.base.EmployeeSessionUtil;

public class LoginInterceptor implements HandlerInterceptor {

	
	public boolean preHandle(HttpServletRequest arg0, HttpServletResponse resp,
			Object arg2) throws Exception {
		EmployeeInfo emp = EmployeeSessionUtil.getEmp();

		if(emp == null){
			resp.sendRedirect("/ssm");
			return false;
		}
		
		return true;
	}

	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		
	}

	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		
	}

	
}
