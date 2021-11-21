package com.myshop.cm.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.myshop.cm.model.GoodsVO;
import com.myshop.cm.service.StoreService;

@Controller
@RequestMapping("/store/**")
public class StoreController {

	@Inject
	private StoreService storeService;
	
	//상품 선택
	@GetMapping("storeSelect")
	public void storeSelect(GoodsVO goodsVO, Model model) throws Exception {
		System.out.println("StoreSelect 들어왔냐");
	}
	
	//상품 목록
	@GetMapping("storeList")
	public void storeList(GoodsVO goodsVO, Model model) throws Exception {
		
//		List<GoodsVO> list = storeService.
		
		
	}
}
