package com.myshop.cm.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.myshop.cm.model.CartVO;
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
		MemberVO memberVO = (MemberVO)session.getAttribute("member");
		System.out.println("CartList 들어왔냐");
		
		
	}
	
	//카트 담기
	@ResponseBody
	@PostMapping("cartInsert")
	public int cartInsert(CartVO cartVO, HttpSession session) throws Exception {
		System.out.println("CartInsert 들어왔냐");
		
		MemberVO memberVO = (MemberVO)session.getAttribute("member");
		int result = 0;
		String gds_viewyn = null;
		
		//if(memberVO != null) {
			gds_viewyn = cartService.selectGdsviewyn(cartVO);
			//System.out.println(gds_viewyn);
			cartVO.setMem_num(1);
			cartVO.setGds_viewyn(gds_viewyn);
			result = cartService.cartInsert(cartVO);
			//System.out.println(result);
		//}
			
		return result;
	}
	
	//동일 상품 존재 여부 조회
	@ResponseBody
	@PostMapping("cartSelect")
	public void cartSelect(CartVO cartVO, Model model, HttpSession session) throws Exception {
		MemberVO memberVO = (MemberVO)session.getAttribute("member");
		int result = 0;
		
		//if(memberVO != null) {
			//cartVO.setMem_num(memberVO.getMem_num());
			
			cartVO.setMem_num(1);
			cartVO = cartService.cartSelect(cartVO);
			
			if(cartVO != null) {
				result = 1; //동일 상품 존재 O
				model.addAttribute("cart_num", cartVO.getCart_num());
				model.addAttribute("cart_count", cartVO.getCart_count());
			}else {
				result = 2; //동일 상품 존재 X
			}
		//}
			model.addAttribute("result", result);
	}
	
}
