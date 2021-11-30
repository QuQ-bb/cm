package com.myshop.cm.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.myshop.cm.model.GoodsVO;
import com.myshop.cm.model.OptionVO;
import com.myshop.cm.util.Pager;

@Repository
public class StoreDAO {

	@Inject
	private SqlSession sqlSession;
	private final static String NAMESPACE = "storeMapper.";
	
	// 상품 리스트
	public List<GoodsVO> storeList(Pager pager) throws Exception {
		return sqlSession.selectList(NAMESPACE+"storeList", pager);
	}
	
	// 상품 상세
	public GoodsVO storeSelect(GoodsVO goodsVO) throws Exception {
		return sqlSession.selectOne(NAMESPACE+"storeSelect", goodsVO);
	}
	
	//옵션2 가져오는 거
	public List<OptionVO> option2Select(OptionVO optionVO) throws Exception {
		return sqlSession.selectList(NAMESPACE+"option2Select", optionVO);
	}
}
