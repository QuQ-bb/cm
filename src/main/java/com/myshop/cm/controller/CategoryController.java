package com.myshop.cm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.myshop.cm.model.MCateVO;
import com.myshop.cm.model.SCateVO;
import com.myshop.cm.service.CategoryService;

@Controller
public class CategoryController {
	@Autowired
	private CategoryService categoryService;
	
	// 대분류코드로 중분류 검색하기
	@RequestMapping(value = "mcateload",  method = RequestMethod.POST)
	public String mcateload(@RequestParam(value ="lcate_code") int lcate_code,
							Model model) throws Exception{
		
		//  대분류코드로 중분류 카테고리 리스트 불러오기
		List<MCateVO> mcatelist = categoryService.getMCateList(lcate_code);
		
		model.addAttribute("mcatelist", mcatelist);
		
		return "seller/ajaxmcate";
	}
	
	// 중분류코드로 중분류 검색하기
	@RequestMapping(value = "scateload",  method = RequestMethod.POST)
	public String scateload(@RequestParam(value ="mcate_code") int mcate_code,
							Model model) throws Exception{
		
		// 중분류 코드로 소분류코드 불러오기
		List<SCateVO> scatelist = categoryService.getSCateList(mcate_code);
		
		model.addAttribute("scatelist", scatelist);
		
		return "seller/ajaxscate";
	}

}
