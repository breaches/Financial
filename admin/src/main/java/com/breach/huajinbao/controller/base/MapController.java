package com.breach.huajinbao.controller.base;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MapController {

	// shaokang
	@RequestMapping("/toHome")
	public String toHome(){
		return "base/home";
	}

	// shaokang
	@RequestMapping("/toEmp")
	public String toEmp(){
		return "base/employee";
	}

}
