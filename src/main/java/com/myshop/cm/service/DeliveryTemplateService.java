package com.myshop.cm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myshop.cm.dao.DeliveryTemplateDAO;
import com.myshop.cm.model.DeliveryTemplateVO;

@Service
public class DeliveryTemplateService {
	
	@Autowired
	private DeliveryTemplateDAO deliverytemplateDAO;

	// 배송 템플릿 등록
	public void insert(DeliveryTemplateVO deliverytemplate) throws Exception{
		System.out.println("Service");
		deliverytemplateDAO.insertTemplate(deliverytemplate);
		
	}

	public List<DeliveryTemplateVO> getTemplateList() {
		List<DeliveryTemplateVO> list = deliverytemplateDAO.getTemplateList();
		return list;
	}

	public DeliveryTemplateVO getTemplate(int deltem_num) {
		DeliveryTemplateVO gettemplate = deliverytemplateDAO.getTemplate(deltem_num);
		return gettemplate;
	}
	
	// 배송 템플릿 불러오기
	

}
