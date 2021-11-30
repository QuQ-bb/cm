package com.myshop.cm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.myshop.cm.service.OrderService;

@Controller
public class OrderController {

	@Autowired
	private OrderService orderService;
}
