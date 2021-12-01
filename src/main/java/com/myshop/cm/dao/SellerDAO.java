package com.myshop.cm.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.myshop.cm.model.GoodsVO;
import com.myshop.cm.model.MemberVO;
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
	public MemberVO getMember(MemberVO member) {
		return sqlSession.selectOne("sellerMapper.selectMemNum", member);
	}
	
	// 상품 등록
	public void insertGoods(GoodsVO goods) throws Exception {
		sqlSession.insert("sellerMapper.goods_insert", goods);
	}

	// 상품 목록 총 개수
	public int getListCount(String sel_name) throws Exception{
		return ((Integer)sqlSession.selectOne("sellerMapper.seller_goods_count", sel_name)).intValue();
	}

	// 판매자 상품 리스트
	public List<GoodsVO> getSellerGoodsList(Map<String, Object> listIndexMap) throws Exception{
		List<GoodsVO> list = sqlSession.selectList("sellerMapper.seller_goods_list", listIndexMap);
		
		return list;
	}
	
	// 판매자 상품 상세정보
	public GoodsVO getGoodsContent(int gds_num) throws Exception{
		return (GoodsVO) sqlSession.selectOne("sellerMapper.goods_detail", gds_num);
	}

	// 상품 수정
	public void updateGoods(GoodsVO goods) throws Exception{
		sqlSession.update("sellerMapper.goods_update", goods);
	}

	// 상품 삭제
	public void deleteGoods(int gds_num) throws Exception{
		sqlSession.delete("sellerMapper.goods_delete", gds_num);
	}

	// 상품 정지
	public void goodshide(int gds_num) throws Exception{
		sqlSession.update("sellerMapper.goods_update_viewn", gds_num);
	}

	// 상품 노출
	public void goodsview(int gds_num) throws Exception{
		sqlSession.update("sellerMapper.goods_update_viewy", gds_num);
	}
	
	// 세션값의 mem_num으로 판매자정보 가져오기
	public SellerVO getSellerInfo(int mem_num) {
		return sqlSession.selectOne("sellerMapper.seller_select", mem_num);
	}
}
