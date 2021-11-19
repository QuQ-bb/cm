package com.myshop.cm.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
	
	// 배송사 카테고리 구해오기
	@RequestMapping(value = "/sellerdeliverytemplate")
	public ModelAndView sellerdeliverytemplate(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		Map<String, Object> getdeliverycatelist = deliveryCategoryService.getDeliveryCateList(request, response);
		
		ModelAndView deliverytemplateM = new ModelAndView("seller/sellerdeliverytemplate");

		deliverytemplateM.addAllObjects(getdeliverycatelist);
		
		return deliverytemplateM;
	}
	
	@RequestMapping(value = "/deliverytemplateupload", method = RequestMethod.POST)
	public String deliverytemplateupload(@RequestParam("del_info") String del_info, DeliveryTemplateVO deliverytemplate) throws Exception{
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

		System.out.println(deliverytemplate.getDeltem_num());
		System.out.println(deliverytemplate.getDeltem_name());
		System.out.println(deliverytemplate.getSel_num());
		System.out.println(deliverytemplate.getDel_code());
		System.out.println(deliverytemplate.getDel_name());
		System.out.println(deliverytemplate.getDeltem_delfee());
		System.out.println(deliverytemplate.getDeltem_redelfee());
		System.out.println(deliverytemplate.getDeltem_exdelfee());
		System.out.println(deliverytemplate.getDeltem_freedel());
		System.out.println(deliverytemplate.getDeltem_repost());
		System.out.println(deliverytemplate.getDeltem_readd1());
		System.out.println(deliverytemplate.getDeltem_readd2());
		
		deliveryTemplateService.insert(deliverytemplate);  // 저장메소드 호출

		return "/";
	}

}
