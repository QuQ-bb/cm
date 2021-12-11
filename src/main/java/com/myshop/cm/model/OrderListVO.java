package com.myshop.cm.model;

public class OrderListVO {

//	CREATE TABLE `orderlist` (
//	  `ol_num` 	int(11) NOT NULL AUTO_INCREMENT COMMENT '상품 리스트 번호',
//	  `ord_num` int(11) NOT NULL 				COMMENT '주문번호',
//	  `gds_num` int(11) NOT NULL 				COMMENT '상품번호',
//	  `opt_num` int(11) NOT NULL 				COMMENT '옵션 번호',
//	  `ol_count` int(11) NOT NULL 				COMMENT '주문 수량',
//	  `gds_seller` varchar(20) NOT NULL 		COMMENT '상품 판매',
//	  PRIMARY KEY (`ol_num`)
//	) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='상품 리스트';
  
	private int ol_num;
	private int ord_num;
	private int gds_num;
	private int opt_num;
	private int ol_count;
	private String gds_seller;

	public int getOl_num() {
		return ol_num;
	}

	public void setOl_num(int ol_num) {
		this.ol_num = ol_num;
	}

	public int getOrd_num() {
		return ord_num;
	}

	public void setOrd_num(int ord_num) {
		this.ord_num = ord_num;
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

	public int getOl_count() {
		return ol_count;
	}

	public void setOl_count(int ol_count) {
		this.ol_count = ol_count;
	}

	public String getGds_seller() {
		return gds_seller;
	}

	public void setGds_seller(String gds_seller) {
		this.gds_seller = gds_seller;
	}

}
