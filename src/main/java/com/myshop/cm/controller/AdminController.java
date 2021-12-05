package com.myshop.cm.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
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
	public String chgdetail(@RequestParam(value="sel_name") String sel_name ,
//			@RequestParam(value="page", defaultValue="1") String page,
			@RequestParam("state") String state,
			Model model) throws Exception{
		System.out.println("상세보기 탔냐?");
		SellerVO sellerVO = adminservice.chgdetail(sel_name);
		System.out.println("상세보기 탔냐2?");
		
		model.addAttribute("sellerVO", sellerVO);
//		model.addAttribute("mem_grade", memberVO.getMem_grade());
//		model.addAttribute("page", page);
		System.out.println("상세보기 탔냐3?");
		if(state.equals("chgdetail")) {  // 내용보기 일때 
			return "/admin/chgdetail"; // 내용보기 페이지 설정
		} 
		if(state.equals("chgdetail")) {
		System.out.println("상세보기 탔냐4?");
			return "/admin/chglist";
		}
		return null;
	}
	// 판매자 리스트(admin용)
	@RequestMapping(value = "/sellist")
	public String Sellerist(SellerVO sellerVO , Model model) throws Exception{
		System.out.println("판매자리스트진입");
		List<SellerVO> sellist = adminservice.sellist(sellerVO);
		System.out.println("판매자리스트1");
		model.addAttribute("sellist", sellist);
		return "/admin/sellerlist";
	}
	// 판매자 리스트 상세조회
		@RequestMapping(value = "/seldetail")
		public String seldetail(@RequestParam(value="sel_name") String sel_name ,
//				@RequestParam(value="page", defaultValue="1") String page,
				@RequestParam("state") String state,
				Model model) throws Exception{
			System.out.println("상세보기 탔냐1?");
			SellerVO sellerVO = adminservice.seldetail(sel_name);
			System.out.println("상세보기 탔냐2?");
			
			model.addAttribute("sellerVO", sellerVO);
//			model.addAttribute("page", page);
			System.out.println("상세보기 탔냐3?");
			if(state.equals("seldetail")) {  // 내용보기 일때 
				return "/admin/seldetail"; // 내용보기 페이지 설정
			}
			return null;
		}
	// 판매자 전환승인
		@RequestMapping(value = "/chgaccess" , method = RequestMethod.POST)
		public ModelAndView chgaccess(int mem_num , MemberVO memberVO , HttpServletRequest request) throws Exception{
			System.out.println("1111");
			ModelAndView mv = new ModelAndView();
			System.out.println("2222");
			memberVO.setMem_num(Integer.parseInt(request.getParameter("mem_num")));
			System.out.println("3333");
			adminservice.UpdateMemgrade(memberVO);  // 업데이트라 리턴이 필요없음
			System.out.println("4444");
			mv.setViewName("redirect:/sellist");
			System.out.println(mv.getViewName()+ mv);
			return mv;
		}
}
