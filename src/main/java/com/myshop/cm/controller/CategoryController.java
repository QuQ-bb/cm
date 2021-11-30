package com.myshop.cm.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.myshop.cm.model.LCateVO;
import com.myshop.cm.model.MCateVO;
import com.myshop.cm.model.SCateVO;
import com.myshop.cm.service.CategoryService;

@Controller
public class CategoryController {
	@Autowired
	private CategoryService categoryService;
	@Autowired
	CategoryService categoryservice;
	
	// 카테고리 리스트(대)
	@RequestMapping(value = "/lcatelist")
	private String lcatelist(LCateVO lcateVo , Model model) throws Exception{
		System.out.println("대컨트롤러 진입");
		List<LCateVO> lcatelist = categoryservice.lcatelist(lcateVo);		
		System.out.println("대컨트롤러진입2");
							 //key, 	   value
		model.addAttribute("lcatelist" , lcatelist);
		System.out.println("대컨트롤러진입3");
		return "admin/lcatelist";
	}
	// 카테고리 리스트(중)
	@RequestMapping(value = "/mcatelist")
	private String mcatelist(MCateVO mcateVO , Model model) throws Exception{
		System.out.println("중컨트롤러 진입");
		List<MCateVO> mcatelist = categoryservice.mcatelist(mcateVO);
		System.out.println("중컨트롤러진입2");
		model.addAttribute("mcatelist" , mcatelist); 
		System.out.println("중컨트롤러진입3");
		return "admin/mcatelist";
	}
	// 카테고리 리스트(소)
	@RequestMapping(value = "/scatelist")
	private String scatelist(SCateVO scateVO , Model model) throws Exception{
		System.out.println("소컨트롤러 진입");
		List<SCateVO> scatelist = categoryservice.scatelist(scateVO);
		System.out.println("소컨트롤러진입2");
		model.addAttribute("scatelist" , scatelist);
		System.out.println("소컨트롤러진입3");
		return "admin/scatelist";
	}
	// 카테고리 등록폼(중)
	@RequestMapping(value = "/addmcate")
	private String addmcate(MCateVO mcateVO , Model model) throws Exception{
		System.out.println("1111");
		List<MCateVO> mcatelist = categoryservice.mcatelist(mcateVO);
		model.addAttribute("mcatelist", mcatelist);
		return "admin/addmcate";
	}
	// 카테고리 등록(중)
	@RequestMapping(value = "/insertmcate")
	private String insertmcate(MCateVO mcateVO , Model model , HttpServletRequest request) throws Exception{
		 mcateVO.setMcate_code(Integer.parseInt(request.getParameter("mcatecode")));
		 mcateVO.setMcate_name(request.getParameter("mcatename"));
		 mcateVO.setLcate_code(Integer.parseInt(request.getParameter("lcatecode")));
		 int mcateInsert = categoryservice.McateInsert(mcateVO);
		 model.addAttribute("mcateInsert",mcateInsert);
		return "admin/mcatelist";
	}
	// 카테고리 등록폼(소)
	@RequestMapping(value ="/addscate")
	private String addscate(SCateVO scateVO , Model model) throws Exception{
		System.out.println("등록폼소컨트롤러진입");
		List<SCateVO> scatelist = categoryservice.scatelist(scateVO);
		model.addAttribute("scatelist", scatelist);
		return "admin/addscate";
	}
	// 카테고리 등록(소)
	@RequestMapping(value = "/insertscate")
	private String insertscate(SCateVO scateVO , Model model , HttpServletRequest request) throws Exception{
		System.out.println("3333");
		 scateVO.setScate_code(Integer.parseInt(request.getParameter("scatecode")));
		 scateVO.setScate_name(request.getParameter("scatename"));
		 scateVO.setLcate_code(Integer.parseInt(request.getParameter("lcatecode")));
		 scateVO.setMcate_code(Integer.parseInt(request.getParameter("mcatecode")));
		 int scateInsert = categoryservice.ScateInsert(scateVO);
		 model.addAttribute("scateInsert",scateInsert);
		return "admin/scatelist";
	}
	// 카테고리 등록폼
	@RequestMapping(value = "/addcategory")
	private String addcategory(LCateVO lcateVO , Model model) throws Exception{
		System.out.println("1111");
		List<LCateVO> lcatelist = categoryservice.lcatelist(lcateVO);
		model.addAttribute("lcatelist", lcatelist);
		return "admin/addcategory";
	}
	// 카테고리 등록
//	@RequestMapping(value = "/insertcategory")
//	private String insertcategory(LCateVO lcateVO , Model model) throws Exception{
//		System.out.println("3333");
//		 int cateInsert = categoryservice.LcateInsert(lcateVO);
//		 model.addAttribute("cateInsert",cateInsert);
//		System.out.println("4444");
//		return "admin/addcategory";
//	}
	
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
