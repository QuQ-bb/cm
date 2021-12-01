package com.myshop.cm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myshop.cm.dao.SellerDAO;
import com.myshop.cm.model.MemberVO;
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
	//mem_num가져오기
	public MemberVO getMember(MemberVO member) {
		return sellerDao.getMember(member);
	}
	
	// 세션값의 mem_num으로 판매자정보 가져오기
	public SellerVO getSellerInfo(int mem_num) {
		return sellerDao.getSellerInfo(mem_num);
	}
	

}
