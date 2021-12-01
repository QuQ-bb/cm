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

	// 배송템플릿 리스트 불러오기
	public List<DeliveryTemplateVO> getTemplateList(int sel_num) throws Exception{
		List<DeliveryTemplateVO> list = deliverytemplateDAO.getTemplateList(sel_num);
		return list;
	}

	// 배송템플릿 상세정보 불러오기
	public DeliveryTemplateVO getTemplate(int deltem_num) throws Exception{
		DeliveryTemplateVO gettemplate = deliverytemplateDAO.getTemplate(deltem_num);
		return gettemplate;
	}

	// 배송템플릿 개수 구하기
	public int gettemplatecount(int sel_num) throws Exception{
		int gettemplatecount = deliverytemplateDAO.getTemplateCount(sel_num);
		return gettemplatecount;
	}

	// 배송템플릿 수정하기
	public void editdeltem(DeliveryTemplateVO deliverytemplate) throws Exception{
		deliverytemplateDAO.editdeltem(deliverytemplate);
	}

	// 배송템플릿 삭제하기
	public void deletedelitem(int deltem_num) {
		deliverytemplateDAO.deletedelitem(deltem_num);
	}
}
