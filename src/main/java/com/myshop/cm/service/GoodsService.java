package com.myshop.cm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myshop.cm.dao.GoodsDAO;
import com.myshop.cm.model.GoodsVO;

@Service
public class GoodsService {
	
	@Autowired
	private GoodsDAO goodsDao;
	
	// 상품 등록
	public void insert(GoodsVO goods) throws Exception{
		
		goodsDao.insertGoods(goods);
	}

}
