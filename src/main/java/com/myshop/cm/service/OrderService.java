package com.myshop.cm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myshop.cm.dao.OrderDAO;
import com.myshop.cm.model.OrderVO;

@Service
public class OrderService {
	
	@Autowired
	private OrderDAO orderDAO;

	// 판매자페이지에서 주문 상세내역 불러오기
	public OrderVO getOrderDetail(int ord_num) throws Exception{
		OrderVO order = orderDAO.getOrderDetail(ord_num);
		return order;
	}

}
