package com.myshop.cm.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.myshop.cm.model.OrderVO;

@Repository
public class OrderDAO {
	
	@Autowired
	private SqlSession sqlSession;

	//리뷰페이지 ord_num값 구하기
	public OrderVO getOrdReview(int ord_num)throws Exception {
		OrderVO orderrev = sqlSession.selectOne("orderMapper.review_ord", ord_num);
		return orderrev;
	}
	// 리뷰 페이지에서 주문리스트 갯수 가져오기
	@Transactional
	public int getHistoryListCount() throws Exception{
		return sqlSession.selectOne("orderMapper.history_list_count");
	}
	// 리뷰 페이지에서 주문리스트 가져오기
	@Transactional
	public List<OrderVO> getHistoryList(int pageIndex) {
		return sqlSession.selectList("orderMapper.history_list",pageIndex);
	}
}
