package com.myshop.cm.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.myshop.cm.model.OrderListVO;
import com.myshop.cm.model.OrderVO;

@Repository
public class OrderDAO {
	
	@Autowired
	private SqlSession sqlSession;

	//리뷰페이지 ord_num값 구하기
	public OrderListVO getOrdReview(int ol_num)throws Exception {
		OrderListVO orderrev = sqlSession.selectOne("orderMapper.review_ord", ol_num);
		return orderrev;
	}
	// 마이페이지 주문내역 갯수 가져오기
	@Transactional
	public int getHistoryListCount(int mem_num) throws Exception{
		return sqlSession.selectOne("orderMapper.history_list_count", mem_num);
	}
	// 마이 페이지 주문내역
	@Transactional
	public List<OrderVO> getHistoryList(Map<String, Object> indexMap) {
		return sqlSession.selectList("orderMapper.history_list",indexMap);
	}
	
	// 판매자페이지에서 주문정보 불러오기
	public OrderListVO getOrderDetail(int ol_num) throws Exception{
		OrderListVO order = sqlSession.selectOne("orderMapper.select_order_detail", ol_num);
		return order;
	}
	
	// 판매자 페이지에서 주문리스트 갯수 가져오기
	public int getOrderListCount(String sel_name) throws Exception{
		return sqlSession.selectOne("orderMapper.select_order_list_count", sel_name);
	}
	
	// 판매자 페이지에서 주문리스트 가져오기
	public List<OrderVO> getOrderList(Map<String, Object> listIndexMap) throws Exception{
		return sqlSession.selectList("orderMapper.select_order_list", listIndexMap);
	}

}
