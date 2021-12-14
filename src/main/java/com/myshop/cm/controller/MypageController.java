package com.myshop.cm.controller;

import java.util.ArrayList;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.OrderComparator.OrderSourceProvider;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.myshop.cm.model.DeliveryAddressVO;
import com.myshop.cm.model.DeliveryTemplateVO;
import com.myshop.cm.model.GoodsQnaVO;
import com.myshop.cm.model.GoodsVO;
import com.myshop.cm.model.MemberVO;
import com.myshop.cm.model.OptionVO;
import com.myshop.cm.model.OrderListVO;
import com.myshop.cm.model.OrderVO;
import com.myshop.cm.model.ReviewVO;
import com.myshop.cm.service.DeliveryAddressService;
import com.myshop.cm.service.DeliveryTemplateService;
import com.myshop.cm.service.GoodsService;
import com.myshop.cm.service.MemberService;
import com.myshop.cm.service.MypageService;
import com.myshop.cm.service.OptionService;
import com.myshop.cm.service.OrderService;
import com.myshop.cm.service.GoodsQnaService;

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
	@Autowired
	private OptionService optionService;
	@Autowired
	private DeliveryAddressService deliveryAddressService;
	@Autowired
	private DeliveryTemplateService deliveryTemplateService;
	@Autowired
	private GoodsQnaService goodsQnaService;

		//회원 주문내역 목록
		@RequestMapping(value = "/order_history")
		public ModelAndView order_history(HttpServletRequest request, HttpServletResponse response,HttpSession session) throws Exception{
			// 주문리스트 받아오기
			Map<String, Object> historylist = orderService.getHistoryList(request, response, session);
			// 
			ModelAndView historylistM = new ModelAndView("mypage/order_history");
			historylistM.addAllObjects(historylist);
			
			return historylistM;
		}
		//마이페이지 회원 주문 상세내역 페이지
		@RequestMapping(value = "/history_detail")
		public ModelAndView sellerorderdetail(HttpServletRequest request, HttpServletResponse response) throws Exception{
			int ol_num = Integer.parseInt(request.getParameter("ol_num"));		
			String page = request.getParameter("page");
			
			// 주문 상세정보 구해오기
			OrderListVO order = orderService.getOrderDetail(ol_num);
			
			// 주문 상세정보의 gds_num으로 상품정보 불러오기
			GoodsVO goods = goodsService.goodsdetail(order.getGds_num());
			
			// 주문 상세정보의 ord_gdsoption 으로 옵션정보 불러오기
			OptionVO option = optionService.getoption(order.getOpt_num());
			
			// 상품 상세정보의 deltem_num 으로 배송탬플릿 정보 불러오기
			DeliveryTemplateVO deliverytemplate = deliveryTemplateService.getTemplate(goods.getDeltem_num());
			
			// 주문 상세정보의 mem_num으로 구매자 상세정보 불러오기
			MemberVO member = memberService.getmemberinfo(order.getMem_num());
			
			// 주문 상세정보의 mem_num으로 배송지 상세정보구하기
			DeliveryAddressVO deliveryAddress = deliveryAddressService.getdeliveryAddress(order.getMem_num());
			
			
			ModelAndView sellerorderdetailM = new ModelAndView("mypage/history_detail");
			sellerorderdetailM.addObject("page", page);
			sellerorderdetailM.addObject("order", order);
			sellerorderdetailM.addObject("goods", goods);
			sellerorderdetailM.addObject("option", option);
			sellerorderdetailM.addObject("deliverytemplate", deliverytemplate);
			sellerorderdetailM.addObject("member", member);
			sellerorderdetailM.addObject("deliveryAddress", deliveryAddress);
			
			return sellerorderdetailM;
		}
		//내가 쓴 상품문의 목록
		@RequestMapping(value = "/mygoodsqnalist")
		public ModelAndView mygoodsqnalist(HttpServletRequest request, HttpServletResponse response,HttpSession session) throws Exception{
			ModelAndView sellergoodsqnalistM = new ModelAndView("mypage/mygoodsqnalist");
			
			// 문의 리스트 받아오기
			Map<String, Object> goodsqnalist = goodsQnaService.getMyGoodsQnaList(request, response, session);

			sellergoodsqnalistM.addAllObjects(goodsqnalist);
			
			return sellergoodsqnalistM;
		}
		//내가 쓴 상품문의 상세페이지
		@RequestMapping(value = "/showgoodsQnadetail")
		public String showgoodsQnadetail(@RequestParam("gdsqna_num") int gdsqna_num, Model model) throws Exception{
			
			// 답변이 달렸는지 확인하기
			int answer = goodsQnaService.getmyGoodsQnaAnswer(gdsqna_num);
			model.addAttribute("answer", answer);
			
			// 문의 확인하기
			GoodsQnaVO goodsquestion = goodsQnaService.getmyGoodsQuestionDetail(gdsqna_num);
			model.addAttribute("goodsquestion", goodsquestion);
			
			// 답변이 있다면 답변 확인하기
			if(answer == 1) {
				GoodsQnaVO goodsanswer = goodsQnaService.getmyGoodsAnswerDetail(gdsqna_num);
				model.addAttribute("goodsanswer", goodsanswer);
			}
			return "mypage/ajaxmygoodsqnadetail";
		}
		//내 상품문의 수정 폼
		@RequestMapping(value="/updatemygoodsqnaform")
		public String updatemygoodsqnaform(@RequestParam(value="gdsqna_num") int gdsqna_num, Model model) throws Exception {
			
			//gdqna_num으로 문의정보 불러오기
			GoodsQnaVO goodsquestion = goodsQnaService.getmyGoodsQuestionDetail(gdsqna_num);
			
			model.addAttribute("goodsquestion", goodsquestion);
			
			return "mypage/ajaxupdatemygoodsqna";
		}
		//내 상품문의 수정
		@RequestMapping(value="/mygoodsqnaupdate")
		public String mygoodsqnaupdate(@ModelAttribute GoodsQnaVO goodsqna, Model model)throws Exception {
			
			//수정 메서드 호출
			goodsQnaService.updateMyGoodsQna(goodsqna);
			System.out.println("내 상품문의 수정 왜안돼?");
		
			return "redirect:/mygoodsqnalist?gdsqna_num=" + goodsqna.getGdsqna_num();
		}
		//내 상품문의 삭제
		@RequestMapping(value="/mygoodsqna_delete")
		public String goodsqna_out(@RequestParam("gdsqna_num") int gdsqna_num) throws Exception {
			
			goodsQnaService.myGoodsQnaDelete(gdsqna_num);
			System.out.println("상품문의 삭제 괜찮으시겠어요?");
			
			return "redirect:/mygoodsqnalist";
		}
		


}
