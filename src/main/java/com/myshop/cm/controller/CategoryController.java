package com.myshop.cm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.myshop.cm.model.CategoryVO;
import com.myshop.cm.service.CategoryService;
@Controller
public class CategoryController {
	@Autowired
	CategoryService categoryservice;
	// 카테고리 리스트
	@RequestMapping("admin/catelist")
	private String catelist(CategoryVO categoryVO , Model model) throws Exception{
		System.out.println("컨트롤러진입");
		
		List<CategoryVO> catelist = categoryservice.catelist(categoryVO);
							//key, 	   value
		model.addAttribute("catelist",catelist);
		System.out.println("컨트롤러진입2");
		
		return "admin/catelist";
	}
	// 카테고리 등록폼
	@RequestMapping("admin/addcategory")
	private String addcategory(CategoryVO categoryVO , Model model) throws Exception{
		System.out.println("1111");
		
		List<CategoryVO> catelist = categoryservice.catelist(categoryVO);
		model.addAttribute("catelist", catelist);
		
		return "admin/addcategory";
	}
	// 카테고리 등록
	@RequestMapping("admin/insertcategory")
	private String insertcategory(CategoryVO categoryVO , Model model) throws Exception{
		System.out.println("3333");
		
		 int cateInsert = categoryservice.CategoryInsert(categoryVO);
		 model.addAttribute("cateInsert",cateInsert);
		 
		System.out.println("4444");
		return "admin/addcategory";
	}
}
