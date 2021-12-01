package com.myshop.cm.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.myshop.cm.model.CartVO;

@Repository
public class CartDAO {

	@Inject
	private SqlSession sqlSession;
	private final static String NAMESPACE = "cartMapper.";
	
	//카트 담기
	public int cartInsert(CartVO cartVO) throws Exception {
		return sqlSession.insert(NAMESPACE+"cartInsert", cartVO);
	}
	
	//gds_viewyn 찾아오기
	public String selectGdsviewyn(CartVO cartVO) throws Exception {
		return sqlSession.selectOne(NAMESPACE+"selectGdsviewyn", cartVO);
	}
	
	//동일 상품 존재 여부 조회
	public CartVO cartSelect(CartVO cartVO) throws Exception {
		return sqlSession.selectOne(NAMESPACE+"cartSelect", cartVO);
	}
}
