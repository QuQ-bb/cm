package com.myshop.cm.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.myshop.cm.model.GoodsVO;

@Repository
public class SellerDAO {

	@Autowired
	private SqlSession sqlSession;
	
	// 상품 등록
	public void insertGoods(GoodsVO goods) throws Exception {
		sqlSession.insert("goodsMapper.goods_insert", goods);
	}

	// 상품 목록 총 개수
	public int getListCount() throws Exception{
		int count = 0;
		count = ((Integer)sqlSession.selectOne("goodsMapper.seller_goods_count")).intValue();
		
		return count;
	}

	// 판매자 상품 리스트
	public List<GoodsVO> getSellerGoodsList(int pageIndex) throws Exception{
		List<GoodsVO> list = sqlSession.selectList("goodsMapper.seller_goods_list", pageIndex);
		
		return list;
	}

}
