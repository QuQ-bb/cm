package com.myshop.cm.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.w3c.dom.NodeList;

import com.myshop.cm.model.MemberVO;
import com.myshop.cm.model.SellerVO;
import com.myshop.cm.service.AdminService;
import com.myshop.cm.service.MemberService;

@Controller
public class AdminController {
	@Autowired
	AdminService adminservice;
	@RequestMapping(value = "/adminmain")
	public String AdminMain() throws Exception{
		System.out.println("admin탔음!");
		return "/admin/adminmain";
	}
	// 판매자 신청 목록
	@RequestMapping(value = "/chglist")
	public String Chglist(SellerVO sellerVO , Model model) throws Exception{
		System.out.println("전환신청컨트롤러");
		List<MemberVO> chglist = adminservice.chglist(sellerVO);
		System.out.println("전환신청컨트롤러2");
		model.addAttribute("chglist", chglist);
		System.out.println("전환신청컨트롤러3");
		return "/admin/chglist";
	}
	// 판매자 신청 목록 상세조회
	@RequestMapping(value = "/chgdetail")
	public String chgdetail(@RequestParam(value="sel_num") int sel_num ,
			@RequestParam("page") String page,
			@RequestParam("state") String state,
			Model model) throws Exception{
		System.out.println("상세보기 탔냐?");
		SellerVO sellerVO = adminservice.chgdetail(sel_num);
		System.out.println("상세보기 탔냐2?");
		
		model.addAttribute("chgdetail", sellerVO);
		model.addAttribute("page", page);
		System.out.println("상세보기 탔냐3?");
		if(state.equals("chgdetail")) {  // 내용보기 일때 
			return "/admin/chgdetail"; // 내용보기 페이지 설정
		} else if(state.equals("accept")) {  // 전환 승낙시
			return "/admin/chgaccept";
		}
		
		if(state.equals("chgdetail")) {
		System.out.println("상세보기 탔냐4?");
			return "/admin/chglist";
		}
		return null;
	}
}
