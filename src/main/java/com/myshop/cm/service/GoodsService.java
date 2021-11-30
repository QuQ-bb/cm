package com.myshop.cm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myshop.cm.dao.GoodsDAO;
import com.myshop.cm.model.GoodsVO;

@Service
public class GoodsService {
	
	@Autowired
	private GoodsDAO goodsDao;

	//리뷰에 gds_num가져가기
	public GoodsVO getGdsReview(int gds_num) {
		GoodsVO gdsrev = goodsDao.getGdsReview(gds_num);
		return gdsrev;
	}

//	public GoodsVO orderGoods(int ord_gdsnum)throws Exception {
//		GoodsVO goods =goodsDao.orderGoods(ord_gdsnum);
//		return goods;
//	}
}
