package com.myshop.cm.model;

import java.util.Date;

public class CartVO {

//	CREATE TABLE `cart` (
//	  `cart_num` 	int(11) 	NOT NULL AUTO_INCREMENT 	COMMENT '장바구니 번호',
//	  `mem_num` 	int(11) 	NULL 						COMMENT '회원번호',
//	  `gds_num` 	int(11) 	NOT NULL 					COMMENT '상품 번호',
//	  `cart_gdsoption` varchar(50) DEFAULT NULL 			COMMENT '상품 옵션',
//	  `cart_count` 	int(11) 	NOT NULL 					COMMENT '주문 수량',
//	  `cart_date` 	timestamp 	NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '주문 날짜',
//	  PRIMARY KEY (`cart_num`)
//	) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='장바구니';

	private int cart_num;	//카트 번호(PK)
	private int mem_num;	//주문한 유저 번호
	private int gds_num;	//상품 번호
	private int otp_num;	//옵션 번호
	private int cart_count;	//주문 수량
	private Date cart_date;	//주문 날짜
}
