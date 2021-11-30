package com.myshop.cm.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.myshop.cm.model.GoodsVO;

@Repository
public class GoodsDAO {
	@Autowired
	private SqlSession sqlSession;

	//리뷰에 gds_num가져가기
	public GoodsVO getGdsReview(int gds_num) {
		return sqlSession.selectOne("goodsMapper.review_gds", gds_num);
	}

//	public GoodsVO orderGoods(int ord_gdsnum)throws Exception {
//		GoodsVO goods = sqlSession.selectOne("", ord_gdsnum);
//		return null;
//	}
}
