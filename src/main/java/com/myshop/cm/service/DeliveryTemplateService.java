package com.myshop.cm.service;

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
	

}
