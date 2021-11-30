package com.myshop.cm.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.myshop.cm.model.MemberVO;
import com.myshop.cm.service.CartService;

@Controller
@RequestMapping("/cart/**")
public class CartController {

	@Inject
	private CartService cartService;
	
	//장바구니 목록
	@GetMapping("cartList")
	public void cartList(Model model, HttpSession session) throws Exception {
//		MemberVO memberVO = (MemberVO)session.getAttribute("member");
		System.out.println("CartList 들어왔냐");
		
		
	}
}
