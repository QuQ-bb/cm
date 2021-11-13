package com.myshop.cm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.myshop.cm.model.GoodsVO;
import com.myshop.cm.service.GoodsService;

@Controller
public class SellerController {
	
	@Autowired
	private GoodsService goodsService;
	
	// 상품 등록 폼으로 이동
	@RequestMapping(value = "/goodsuploadform")
	public String goodsuploadform() {
		
		return "goods/goodsuploadform";
	}
	
	// 상품 등록
	@RequestMapping(value = "/goodsupload", method = RequestMethod.POST)
	public String goodsupload(@ModelAttribute GoodsVO goods) throws Exception{
		
		goodsService.insert(goods);// 저장 메소드 호출
		
		return "seller/sellergoodslist";
	}
	
	
	
}
