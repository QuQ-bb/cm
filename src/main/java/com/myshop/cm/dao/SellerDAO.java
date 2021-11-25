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
		sqlSession.insert("sellerMapper.goods_insert", goods);
	}

	// 상품 목록 총 개수
	@Transactional
	public int getListCount() throws Exception{
		int count = 0;
		count = ((Integer)sqlSession.selectOne("sellerMapper.seller_goods_count")).intValue();
		
		return count;
	}

	// 판매자 상품 리스트
	@Transactional
	public List<GoodsVO> getSellerGoodsList(int pageIndex) throws Exception{
		List<GoodsVO> list = sqlSession.selectList("sellerMapper.seller_goods_list", pageIndex);
		
		return list;
	}
	
	// 판매자 상품 상세정보
	@Transactional
	public GoodsVO getGoodsContent(int gds_num) throws Exception{
		return (GoodsVO) sqlSession.selectOne("sellerMapper.goods_detail", gds_num);
	}

	// 상품 수정
	@Transactional
	public void updateGoods(GoodsVO goods) throws Exception{
		sqlSession.update("sellerMapper.goods_update", goods);
	}

	// 상품 삭제
	@Transactional
	public void deleteGoods(int gds_num) throws Exception{
		sqlSession.delete("sellerMapper.goods_delete", gds_num);
	}

	// 상품 정지
	@Transactional
	public void goodshide(int gds_num) throws Exception{
		sqlSession.update("sellerMapper.goods_update_viewn", gds_num);
	}

	// 상품 노출
	@Transactional
	public void goodsview(int gds_num) throws Exception{
		sqlSession.update("sellerMapper.goods_update_viewy", gds_num);
	}


}
