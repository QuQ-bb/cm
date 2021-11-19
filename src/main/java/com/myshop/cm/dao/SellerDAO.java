package com.myshop.cm.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.myshop.cm.model.SellerVO;

@Repository
public class SellerDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	//판매자 전환 신청
	@Transactional
	public void registerSeller(SellerVO seller) throws Exception {
		sqlSession.insert("register", seller);
		System.out.println("dao");
	}

}
