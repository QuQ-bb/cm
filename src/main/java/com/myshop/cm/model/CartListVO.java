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
	
	public int getCart_num() {
		return cart_num;
	}
	public void setCart_num(int cart_num) {
		this.cart_num = cart_num;
	}
	public int getMem_num() {
		return mem_num;
	}
	public void setMem_num(int mem_num) {
		this.mem_num = mem_num;
	}
	public int getGds_num() {
		return gds_num;
	}
	public void setGds_num(int gds_num) {
		this.gds_num = gds_num;
	}
	public int getOpt_num() {
		return opt_num;
	}
	public void setOpt_num(int opt_num) {
		this.opt_num = opt_num;
	}
	public int getCart_count() {
		return cart_count;
	}
	public void setCart_count(int cart_count) {
		this.cart_count = cart_count;
	}
	public Date getCart_date() {
		return cart_date;
	}
	public void setCart_date(Date cart_date) {
		this.cart_date = cart_date;
	}
	public int getCartList_num() {
		return cartList_num;
	}
	public void setCartList_num(int cartList_num) {
		this.cartList_num = cartList_num;
	}
	public String getGds_name() {
		return gds_name;
	}
	public void setGds_name(String gds_name) {
		this.gds_name = gds_name;
	}
	public OptionVO getOptionVO() {
		return optionVO;
	}
	public void setOptionVO(OptionVO optionVO) {
		this.optionVO = optionVO;
	}
	public int getGds_price() {
		return gds_price;
	}
	public void setGds_price(int gds_price) {
		this.gds_price = gds_price;
	}
	public String getGds_thumbimg() {
		return gds_thumbimg;
	}
	public void setGds_thumbimg(String gds_thumbimg) {
		this.gds_thumbimg = gds_thumbimg;
	}
	
	
}
