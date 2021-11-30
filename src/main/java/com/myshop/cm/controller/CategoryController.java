package com.myshop.cm.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

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
	// 카테고리 등록폼(중)
	@RequestMapping(value = "/addmcate")
	private String addmcate(McateVO mcateVO , Model model) throws Exception{
		System.out.println("1111");
		List<McateVO> mcatelist = categoryservice.mcatelist(mcateVO);
		model.addAttribute("mcatelist", mcatelist);
		return "admin/addmcate";
	}
	// 카테고리 등록(중)
	@RequestMapping(value = "/insertmcate")
	private String insertmcate(McateVO mcateVO , Model model , HttpServletRequest request) throws Exception{
		 mcateVO.setMcate_code(Integer.parseInt(request.getParameter("mcatecode")));
		 mcateVO.setMcate_name(request.getParameter("mcatename"));
		 mcateVO.setLcate_code(Integer.parseInt(request.getParameter("lcatecode")));
		 int mcateInsert = categoryservice.McateInsert(mcateVO);
		 model.addAttribute("mcateInsert",mcateInsert);
		return "admin/mcatelist";
	}
	// 카테고리 등록폼(소)
	@RequestMapping(value ="/addscate")
	private String addscate(ScateVO scateVO , Model model) throws Exception{
		System.out.println("등록폼소컨트롤러진입");
		List<ScateVO> scatelist = categoryservice.scatelist(scateVO);
		model.addAttribute("scatelist", scatelist);
		return "admin/addscate";
	}
	// 카테고리 등록(소)
	@RequestMapping(value = "/insertscate")
	private String insertscate(ScateVO scateVO , Model model , HttpServletRequest request) throws Exception{
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
