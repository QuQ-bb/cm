package com.myshop.cm.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.OrderComparator.OrderSourceProvider;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.myshop.cm.model.GoodsVO;
import com.myshop.cm.model.MemberVO;
import com.myshop.cm.model.OrderVO;
import com.myshop.cm.model.ReviewVO;
import com.myshop.cm.service.GoodsService;
import com.myshop.cm.service.MemberService;
import com.myshop.cm.service.MypageService;
import com.myshop.cm.service.OrderService;

@Controller
public class MypageController {

	@Autowired
	private MypageService mypageService;
	@Autowired
	private OrderService orderService;
	@Autowired
	private GoodsService goodsService;
	@Autowired
	private MemberService memberService;

	//판매자 주문내역 목록으로 이동
		@RequestMapping(value = "/order_history")
		public ModelAndView order_history(HttpServletRequest request, HttpServletResponse response) throws Exception{
			// 주문리스트 받아오기
			Map<String, Object> historylist = orderService.getHistoryList(request, response);
			// 
			ModelAndView historylistM = new ModelAndView("mypage/order_history");
			historylistM.addAllObjects(historylist);
			
			return historylistM;
		}
		@RequestMapping(value = "mypage", method = RequestMethod.GET)
		public String mypage(Locale locale, Model model) {
			return "layout/mypage";
		}

}
