package com.myshop.cm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.myshop.cm.model.LcateVO;
import com.myshop.cm.model.McateVO;
import com.myshop.cm.model.ScateVO;
import com.myshop.cm.service.CategoryService;
@Controller
public class CategoryController {
	@Autowired
	CategoryService categoryservice;
	// 카테고리 리스트(대)
	@RequestMapping(value = "/lcatelist")
	private String lcatelist(LcateVO lcateVo , Model model) throws Exception{
		System.out.println("대컨트롤러 진입");
		
		List<LcateVO> lcatelist = categoryservice.lcatelist(lcateVo);		
		
		System.out.println("대컨트롤러진입2");
							 //key, 	   value
		model.addAttribute("lcatelist" , lcatelist);
		
		System.out.println("대컨트롤러진입3");
		
		return "admin/lcatelist";
	}
	// 카테고리 리스트(중)
	@RequestMapping(value = "/mcatelist")
	private String mcatelist(McateVO mcateVO , Model model) throws Exception{
		System.out.println("중컨트롤러 진입");
		
		List<McateVO> mcatelist = categoryservice.mcatelist(mcateVO);
		
		System.out.println("중컨트롤러진입2");
		model.addAttribute("mcatelist" , mcatelist); 
		
		System.out.println("중컨트롤러진입3");
		
		return "admin/mcatelist";
	}
	// 카테고리 리스트(소)
	@RequestMapping(value = "/scatelist")
	private String scatelist(ScateVO scateVO , Model model) throws Exception{
		System.out.println("소컨트롤러 진입");
		
		List<ScateVO> scatelist = categoryservice.scatelist(scateVO);
		
		System.out.println("소컨트롤러진입2");
		model.addAttribute("scatelist" , scatelist);
		
		System.out.println("소컨트롤러진입3");
		
		return "admin/scatelist";
	}
	
	// 카테고리 등록폼
	@RequestMapping(value = "/addcategory")
	private String addcategory(LcateVO lcateVO , Model model) throws Exception{
		System.out.println("1111");
		
		List<LcateVO> lcatelist = categoryservice.lcatelist(lcateVO);
		model.addAttribute("lcatelist", lcatelist);
		
		return "admin/addcategory";
	}
	// 카테고리 등록
	@RequestMapping(value = "/insertcategory")
	private String insertcategory(LcateVO lcateVO , Model model) throws Exception{
		System.out.println("3333");
		
		 int cateInsert = categoryservice.LcateInsert(lcateVO);
		 model.addAttribute("cateInsert",cateInsert);
		 
		System.out.println("4444");
		return "admin/addcategory";
	}
}