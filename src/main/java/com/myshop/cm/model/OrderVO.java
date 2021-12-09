package com.myshop.cm.model;

import java.util.Date;

public class OrderVO {
	
//	CREATE TABLE `order` (
//	  `ord_num` 		int(11) 	NOT NULL AUTO_INCREMENT COMMENT '주문 번호',
//	  `mem_num` 		int(11) 	NOT NULL 				COMMENT '회원 번호',
//	  `ord_totalprice` 	int(11) 	NOT NULL 				COMMENT '총 결제 금액',
//	  `ord_delnum` 		varchar(45) DEFAULT NULL 			COMMENT '송장번호\n',
//	  `ord_request` 	varchar(200) DEFAULT NULL 			COMMENT '배송 요청 사항',
//	  `ord_status` 		varchar(45) DEFAULT NULL 			COMMENT '주문 상태\n',
//	  `ord_date` 		timestamp 	NULL DEFAULT NULL 		COMMENT '주문 날짜\n',
//	  PRIMARY KEY (`ord_num`)
//	) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='주문';

	private int ord_num;
	private int mem_num;
	private int ord_totalprice;
	private String ord_delnum;
	private String ord_request;
	private String ord_status;
	private Date ord_date;

	public int getOrd_num() {
		return ord_num;
	}

	public void setOrd_num(int ord_num) {
		this.ord_num = ord_num;
	}

	public int getMem_num() {
		return mem_num;
	}

	public void setMem_num(int mem_num) {
		this.mem_num = mem_num;
	}

	public int getOrd_totalprice() {
		return ord_totalprice;
	}

	public void setOrd_totalprice(int ord_totalprice) {
		this.ord_totalprice = ord_totalprice;
	}

	public String getOrd_delnum() {
		return ord_delnum;
	}

	public void setOrd_delnum(String ord_delnum) {
		this.ord_delnum = ord_delnum;
	}

	public String getOrd_request() {
		return ord_request;
	}

	public void setOrd_request(String ord_request) {
		this.ord_request = ord_request;
	}

	public String getOrd_status() {
		return ord_status;
	}

	public void setOrd_status(String ord_status) {
		this.ord_status = ord_status;
	}

	public Date getOrd_date() {
		return ord_date;
	}

	public void setOrd_date(Date ord_date) {
		this.ord_date = ord_date;
	}

}
