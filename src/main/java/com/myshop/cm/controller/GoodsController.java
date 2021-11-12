package com.myshop.cm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GoodsController {
	
	@Autowired
	// private GoodsService goodsService;
	
	
	@RequestMapping(value = "/goodsuploadform")
	public String goods_upload_form() {
		
		return "goods/goodsuploadform";
	}
	
	
}
