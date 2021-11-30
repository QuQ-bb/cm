package com.myshop.cm.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myshop.cm.dao.DeliveryCategoryDAO;
import com.myshop.cm.model.DeliveryCategoryVO;

@Service
public class DeliveryCategoryService {
	@Autowired
	private DeliveryCategoryDAO deliverycategorydao;
	
	// 카테고리 목록 불러오기
	public Map<String, Object> getDeliveryCateList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<DeliveryCategoryVO> getdeliverycatelist = new ArrayList<DeliveryCategoryVO>();
		
		getdeliverycatelist = deliverycategorydao.getCateList();
		
		for(DeliveryCategoryVO c : getdeliverycatelist) {
			System.out.println(c);
		}
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		resultMap.put("getdeliverycatelist", getdeliverycatelist);

		return resultMap;
	}
	
	// 배송사코드로 배송사명 가져오기
//	public DeliveryCategoryVO getDelName(int del_code) {
//		DeliveryCategoryVO getDelName = deliverycategorydao.getDelName(del_code);
//		return getDelName;
//	}

}