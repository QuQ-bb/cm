package com.myshop.cm.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.myshop.cm.model.MemberVO;
import com.myshop.cm.model.QnaVO;
import com.myshop.cm.service.QnaService;
import com.myshop.cm.util.Pager;

@Controller
@RequestMapping("/qna/**")
public class QnaController {

	@Autowired
	private QnaService qnaService;
	
	//글 작성 폼
	@GetMapping("qnaWrite")
	public void qnaWrite(HttpSession session, Model model) throws Exception {
		MemberVO memberVO = (MemberVO)session.getAttribute("member");
		
		model.addAttribute("writer", "arc0801");
	}
	
	//리스트
	@GetMapping("qnaList")
	public void qnaList(Model model, Pager pager, HttpSession session) throws Exception{
		
		System.out.println("QnaList 들어왔냐");
		
		MemberVO memberVO = (MemberVO)session.getAttribute("member");
		
		List<QnaVO> list = qnaService.qnaList(pager);
		
		model.addAttribute("lists", list);
		model.addAttribute("pager", pager);
//		model.addAttribute("member", memberVO);
	}
}
