package com.myshop.cm.controller;

import javax.servlet.http.HttpServletRequest;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.myshop.cm.model.DeliveryAddressVO;
import com.myshop.cm.model.MemberVO;
import com.myshop.cm.service.MemberService;

@Controller
public class MemberController {

	@Autowired
	private MemberService memberService;
	
	//이용약관 동의 폼
	@RequestMapping("/step1")
	public String step1() throws Exception {
		return "member/step1";
	}

	
	
	
	//id유효성 검사 ajax부분 
	/*
	 * @RequestMapping(value="/member_idCheck", method=RequestMethod.POST) public
	 * String member_idcheck(@RequestParam("") String mem_id, Model model) throws
	 * Exception{
	 * 
	 * System.out.println("mem_id:" +mem_id);
	 * 
	 * int result = memberService.memberIdCheck(mem_id);
	 * model.addAttribute("result", result);
	 * 
	 * return "member/idCheckResult";
	} */
	@RequestMapping(value="/idCheck", method= RequestMethod.POST)
	@ResponseBody
	public int idCheck(@RequestParam("mem_id") String mem_id) {
		System.out.println("id유효성 컨트롤러");
			return memberService.memberIdCheck(mem_id);
	}
	
	
	//회원가입 폼
	@RequestMapping(value = "/member_join")
	public String member_join() {
	return "member/member_join";
		//member폴더  member_join.jsp 실행
	}

	//회원가입 저장
	 @RequestMapping(value= "/join_ok", method =RequestMethod.POST) 
	 public String join_ok(MemberVO member, DeliveryAddressVO deliveryaddress,
			 				 Model model)throws Exception {
		 memberService.insertMember(member);
		
		 // id값으로 mem_num구하기
		 int mem =  memberService.selectMemNum(member);
		 deliveryaddress.setMem_num(mem);
		 memberService.insertDelivery(deliveryaddress);
		 
	  return "redirect:member_login";
			  
	  }
	
	//로그인 폼
	@RequestMapping(value = "/member_login")
	public String member_login() {
		return "member/member_login";
		//member폴더  member_login.jsp 실행
	}
	
	//로그인 저장
	@RequestMapping(value = "/login_ok", method = RequestMethod.POST)
	public String login_ok(@RequestParam("mem_id") String mem_id,
						   @RequestParam("mem_pass")String mem_pass,
						   HttpSession session,	//세션객체 생성
						   Model model) throws Exception {
		int result = 0;
		MemberVO mv = memberService.loginCheck(mem_id);
		
		if(mv == null) {	//등록되지 않은 회원일때

			result = 1;
			model.addAttribute("result", result);
			System.out.println("등록되지 않은 회원입니다.");
			
			return "member/loginOk";
			
		}else {			//등록된 회원일때
			if(mv.getMem_pass().equals(mem_pass)) {	//비밀번호가 같을 떄
				session.setAttribute("mem_id", mem_id);	//세션으로 공유설정
				System.out.println("등록된 ID입니다.");
				
				return "home";
				
			}else {		//비번이 다를때
				result = 2;
				model.addAttribute("result", result);
				
				System.out.println("비밀번호가 틀렸습니다.");
				return "member/loginOk";
			}
			
		}
	}
	
	//로그아웃
	@RequestMapping("member_logout")
	public String logout(HttpSession session) {
		session.invalidate();
		
		return "./member/member_logout";
	}
	
	//회원정보 수정 폼
	

}
