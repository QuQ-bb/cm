package com.myshop.cm.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.myshop.cm.model.GoodsVO;

@Repository
public class SellerDAO {

	@Autowired
	private SqlSession sqlSession;
	
	// 상품 등록
	@Transactional
	public void insertGoods(GoodsVO goods) throws Exception {
		sqlSession.insert("goodsMapper.goods_insert", goods);
	}

	// 상품 목록 총 개수
	@Transactional
	public int getListCount() throws Exception{
		int count = 0;
		count = ((Integer)sqlSession.selectOne("goodsMapper.seller_goods_count")).intValue();
		
		return count;
	}

	// 판매자 상품 리스트
	@Transactional
	public List<GoodsVO> getSellerGoodsList(int pageIndex) throws Exception{
		List<GoodsVO> list = sqlSession.selectList("goodsMapper.seller_goods_list", pageIndex);
		
		return list;
	}
	
	// 판매자 상품 디테일
	@Transactional
	public GoodsVO getGoodsContent(int gds_num) throws Exception{
		return (GoodsVO) sqlSession.selectOne("goodsMapper.goods_detail", gds_num);
	}

	public void updateGoods(GoodsVO goods) {
		sqlSession.update("goodsMapper.goods_update", goods);
	}

}
