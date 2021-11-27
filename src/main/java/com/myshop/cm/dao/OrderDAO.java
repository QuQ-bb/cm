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

	// 판매자페이지에서 주문정보 불러오기
	@Transactional
	public OrderVO getOrderDetail(int ord_num) throws Exception{
		OrderVO order = sqlSession.selectOne("orderMapper.select_order_detail", ord_num);
		return order;
	}
	
	// 판매자 페이지에서 주문리스트 갯수 가져오기
	@Transactional
	public int getOrderListCount() throws Exception{
		return sqlSession.selectOne("orderMapper.select_order_list_count");
	}

	// 판매자 페이지에서 주문리스트 가져오기
	@Transactional
	public List<OrderVO> getOrderList(int pageIndex) {
		return sqlSession.selectList("orderMapper.select_order_list",pageIndex);
	}

}
