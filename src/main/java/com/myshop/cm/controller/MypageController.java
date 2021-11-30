package com.myshop.cm.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.OrderComparator.OrderSourceProvider;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
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
	 
	
	
	//주문내역 폼
//	@RequestMapping(value="/order_history")
//	public String order_histroy() {
//		return "mypage/order_history";
//	}
//	//주문내역 출력
//	// 판매자 정산내역 리스트
//		@RequestMapping(value = "/sellercalculatelist")
//		public ModelAndView sellercalculatelist(HttpServletRequest request, HttpServletResponse response) throws Exception {
//
//			Map<String, Object> historylist = mypageService.historylist(request, response);
//			
//			ModelAndView historylistM = new ModelAndView("mypage/order_history");
//			
//			historylistM.addAllObjects(historylist);
//
//			return historylistM;
//		}
//		// 판매자 정산내역 상세페이지
//		@RequestMapping(value = "/showcalculdetail")
//		public ModelAndView showcalculdetail(@RequestParam("ord_num") int ord_num, Model model) throws Exception {
//			
//			// calcul_num으로 정산정보 불러오기
//			OrderVO order = mypageService.getHistoryDetail(ord_num);
//			//mem_num구하기
//			MemberVO member = memberService.orderMember(order.getMem_id());
//			// 정산정보의 gds_num으로 상품정보 불러오기
//			GoodsVO goods = goodsService.orderGoods(order.getOrd_gdsnum());
//			
//			// modelAndView 객체 생성과 동시에 패스설정
//			ModelAndView showhistorydetailM = new ModelAndView("mypage/history_detail");
//			
//			showhistorydetailM.addObject("order", order);
//			showhistorydetailM.addObject("member", member);
//			showhistorydetailM.addObject("goods", goods);
//			
//			return showhistorydetailM;
//		}
		
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
		
}
