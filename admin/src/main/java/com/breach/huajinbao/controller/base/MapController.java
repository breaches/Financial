package com.breach.huajinbao.controller.base;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MapController {
	
	@RequestMapping("/toHome")
	public String toHome(){
		return "base/home";
	}
	
	@RequestMapping("/toEmp")
	public String toEmp(){
		return "base/employee";
	}

}
