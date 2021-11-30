package com.myshop.cm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.myshop.cm.service.GoodsService;

@Controller
public class GoodsController {
	@Autowired
	private GoodsService goodsService;
}
