package com.myshop.cm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/order/**")
public class OrderController {

	@GetMapping("orderList")
	public void orderList() throws Exception {
		System.out.println("OrderList 들어왔냐");
	}
}
