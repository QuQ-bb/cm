package com.myshop.cm.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.myshop.cm.model.DeliveryTemplateVO;
import com.myshop.cm.service.DeliveryCategoryService;
import com.myshop.cm.service.DeliveryTemplateService;

@Controller
public class DeliveryTemplateController {
	
	@Autowired
	private DeliveryCategoryService deliveryCategoryService;
	@Autowired
	private DeliveryTemplateService deliveryTemplateService;
	
	// 배송 템플릿 작성 폼으로 이동
	@RequestMapping(value = "/sellerdeliverytemplate")
	public ModelAndView sellerdeliverytemplate(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// 배송 카테고리 목록 불러오기
		Map<String, Object> getdeliverycatelist = deliveryCategoryService.getDeliveryCateList(request, response);
		
		// 경로 설정
		ModelAndView deliverytemplateM = new ModelAndView("seller/sellerdeliverytemplate");

		deliverytemplateM.addAllObjects(getdeliverycatelist);
		
		return deliverytemplateM;
	}
	
	// 배송 템플릿 작성하기
	@RequestMapping(value = "/deliverytemplateupload", method = RequestMethod.POST)
	public String deliverytemplateupload(@RequestParam(value = "del_info", required = false) String del_info, DeliveryTemplateVO deliverytemplate) 
			throws Exception{
		System.out.println("controller");
		
		String[] delinfoarr = del_info.split(",");
		for(int i=0; i<2; i++) {
			System.out.println(i+","+delinfoarr[i]);
		}
		deliverytemplate.setDel_code(Integer.parseInt(delinfoarr[0]));
		deliverytemplate.setDel_name(delinfoarr[1]);
		
		// 배송카테고리에서 배송수단 번호로 배송수단명 가져오기
		// DeliveryCategoryVO getDelname = deliveryCategoryService.getDelName(del_code);
		// System.out.println(getDelname);
		
		// 배송템플릿의 배송수단명에 카테고리에서 가져온 값 넣기
		// deliverytemplate.setDel_name(getDelname);

//		System.out.println(deliverytemplate.getDeltem_num());
//		System.out.println(deliverytemplate.getDeltem_name());
//		System.out.println(deliverytemplate.getSel_num());
//		System.out.println(deliverytemplate.getDel_code());
//		System.out.println(deliverytemplate.getDel_name());
//		System.out.println(deliverytemplate.getDeltem_delfee());
//		System.out.println(deliverytemplate.getDeltem_redelfee());
//		System.out.println(deliverytemplate.getDeltem_exdelfee());
//		System.out.println(deliverytemplate.getDeltem_freedel());
//		System.out.println(deliverytemplate.getDeltem_repost());
//		System.out.println(deliverytemplate.getDeltem_readd1());
//		System.out.println(deliverytemplate.getDeltem_readd2());
		
		deliveryTemplateService.insert(deliverytemplate);  // 저장메소드 호출

		return "redirect:sellerdeliverytemplatelist";
	}
	
	// 상품 업로드 양식에서 배송 템플릿 상세정보 구해오기
	@RequestMapping(value = "/deltemload", method = RequestMethod.POST)
	public ModelAndView deltemload(@RequestParam("deltem_num") int deltem_num, HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
		// 경로설정
		ModelAndView deltemloadM = new ModelAndView("seller/loaddeliverytemplate");
		
		if(deltem_num >= 1) {
			// 베송 템플릿 불러오기
			DeliveryTemplateVO gettemplate = deliveryTemplateService.getTemplate(deltem_num);
			
			// 배송 템플릿 목록 구해오기
			List<DeliveryTemplateVO> deltemlist = deliveryTemplateService.getTemplateList();
			
			deltemloadM.addObject("deltemlist", deltemlist);
			deltemloadM.addObject("gettemplate", gettemplate);
		}
		// 배송 카테고리 목록 불러오기
		Map<String, Object> getdeliverycatelist = deliveryCategoryService.getDeliveryCateList(request, response);
		
		deltemloadM.addAllObjects(getdeliverycatelist);
		
		return deltemloadM;
	}
	
	// 배송 템플릿 리스트로 이동하기
	@RequestMapping(value = "sellerdeliverytemplatelist")
	public String sellerdeliverytemplatelist(Model model) throws Exception  {
		//배송 템플릿 개수 구해오기
		int listcount = deliveryTemplateService.gettemplatecount();
		
		// 배송 템플릿 목록 구해오기
		List<DeliveryTemplateVO> deltemlist = deliveryTemplateService.getTemplateList();
		
		model.addAttribute("listcount", listcount);
		model.addAttribute("deltemlist", deltemlist);
		
		return "seller/sellerdeliverytemplatelist";
	}
	
	// 배송 템플릿 수정폼으로 이동
	@RequestMapping(value = "deltemeditform")
	public ModelAndView deltemeditform(@RequestParam("deltem_num") int deltem_num, HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
		// 베송 템플릿 불러오기
		DeliveryTemplateVO gettemplate = deliveryTemplateService.getTemplate(deltem_num);
		
		// 배송 카테고리 목록 구해오기
		Map<String, Object> getdeliverycatelist = deliveryCategoryService.getDeliveryCateList(request, response);
		
		// 경로설정
		ModelAndView deltemeditformM = new ModelAndView("seller/deltemeditform");
		
		deltemeditformM.addAllObjects(getdeliverycatelist);
		deltemeditformM.addObject("gettemplate", gettemplate);
		
		return deltemeditformM;
	}
	
	// 배송 템플릿 수정하기
	@RequestMapping(value = "deltemedit")
	public String deltemedit(@RequestParam(value = "del_info", required = false) String del_info, DeliveryTemplateVO deliverytemplate) 
			throws Exception{
		String[] delinfoarr = del_info.split(",");
		for(int i=0; i<2; i++) {
			System.out.println(i+","+delinfoarr[i]);
		}
		deliverytemplate.setDel_code(Integer.parseInt(delinfoarr[0]));
		deliverytemplate.setDel_name(delinfoarr[1]);
		
		deliveryTemplateService.editdeltem(deliverytemplate);  // 저장메소드 호출
		
		return "redirect:sellerdeliverytemplatelist";
	}
	
	// 배송템플릿 삭제
	@RequestMapping(value = "deltemdelete")
	public String deltemdelete(@RequestParam("deltem_num") int deltem_num) throws Exception{
		
		deliveryTemplateService.deletedelitem(deltem_num);
		
		return "redirect:sellerdeliverytemplatelist";
	}
	
	
}
