package com.myshop.cm.dao;

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

}