package com.myshop.cm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/orders/**")
public class OrdersController {

	@GetMapping("ordersList")
	public void ordersList() throws Exception {
		System.out.println("OrdersList 들어왔냐");
	}
}
