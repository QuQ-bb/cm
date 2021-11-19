package com.myshop.cm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myshop.cm.dao.SellerDAO;
import com.myshop.cm.model.SellerVO;

@Service
public class SellerService {
	
	@Autowired
	private SellerDAO sellerDao;

	//판매자 전환 신청
	public void registerSeller(SellerVO seller) throws Exception {
		sellerDao.registerSeller(seller);
		System.out.println("서비스");
	}
	//판매자 전환신청 

}
