package com.myshop.cm.model;

import java.util.Date;

public class CartListVO {

	//CartVO
	private int cart_num;	//카트 번호(PK)
	private int mem_num;	//주문한 유저 번호
	private int gds_num;	//상품 번호
	private int opt_num;	//옵션 번호
	private int cart_count;	//주문 수량
	private Date cart_date;	//주문 날짜
	
	//추가
	private int cartList_num;	//카트 리스트 번호
	private String gds_name;	//상품 이름
	private OptionVO optionVO;	//상품 옵션
	private int gds_price;		//상품 가격
	private String gds_thumbimg;//상품 썸네일 이미지
}
