package com.myshop.cm.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.myshop.cm.dao.CartDAO;
import com.myshop.cm.model.CartVO;

@Service
public class CartService {

	@Inject
	private CartDAO cartDAO;
	
	//카트 담기
	public int cartInsert(CartVO cartVO) throws Exception {
		return cartDAO.cartInsert(cartVO);
	}
	
	//gdsviewyn 찾아오기
	public String selectGdsviewyn(CartVO cartVO) throws Exception {
		return cartDAO.selectGdsviewyn(cartVO);
	}
	
	//동일 상품 존재 여부 조회
	public CartVO cartSelect(CartVO cartVO) throws Exception {
		return cartDAO.cartSelect(cartVO);
	}
}
