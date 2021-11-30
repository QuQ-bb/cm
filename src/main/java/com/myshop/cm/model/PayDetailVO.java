package com.myshop.cm.model;

import java.sql.Timestamp;

public class PayDetailVO {
	private int pay_num;			//결제 번호
	private String pay_method;		//결제 수단
	private String pay_info;		//결제 정보
	private Timestamp pay_orddate;	//주문일
	private Timestamp pay_paydate;	//결제일
	private int pay_payment;		//총 결제 금액
	private String pay_status;		//결제 상태
	private String pay_appnum;		//결제 승인번호
	
	public int getPay_num() {
		return pay_num;
	}
	public void setPay_num(int pay_num) {
		this.pay_num = pay_num;
	}
	public String getPay_method() {
		return pay_method;
	}
	public void setPay_method(String pay_method) {
		this.pay_method = pay_method;
	}
	public String getPay_info() {
		return pay_info;
	}
	public void setPay_info(String pay_info) {
		this.pay_info = pay_info;
	}
	public Timestamp getPay_orddate() {
		return pay_orddate;
	}
	public void setPay_orddate(Timestamp pay_orddate) {
		this.pay_orddate = pay_orddate;
	}
	public Timestamp getPay_paydate() {
		return pay_paydate;
	}
	public void setPay_paydate(Timestamp pay_paydate) {
		this.pay_paydate = pay_paydate;
	}
	public int getPay_payment() {
		return pay_payment;
	}
	public void setPay_payment(int pay_payment) {
		this.pay_payment = pay_payment;
	}
	public String getPay_status() {
		return pay_status;
	}
	public void setPay_status(String pay_status) {
		this.pay_status = pay_status;
	}
	public String getPay_appnum() {
		return pay_appnum;
	}
	public void setPay_appnum(String pay_appnum) {
		this.pay_appnum = pay_appnum;
	}
}
