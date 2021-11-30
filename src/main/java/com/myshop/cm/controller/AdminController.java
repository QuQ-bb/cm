package com.myshop.cm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {
	@RequestMapping("adminmain")
	public String AdminMain() throws Exception{
		return "/admin/adminmain";
	}
}
