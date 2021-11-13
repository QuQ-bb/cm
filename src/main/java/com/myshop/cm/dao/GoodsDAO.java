package com.myshop.cm.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.myshop.cm.model.GoodsVO;

@Repository
public class GoodsDAO {

	@Autowired
	private SqlSession sqlSession;
	
	// 상품 등록
	public void insertGoods(GoodsVO goods) {
		sqlSession.insert("goodsMapper.goods_insert", goods);
	}

}
