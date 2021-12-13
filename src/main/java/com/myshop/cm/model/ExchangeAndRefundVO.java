package com.myshop.cm.model;

import java.sql.Timestamp;

public class ExchangeAndRefundVO {
	
	private int ear_num;			//교환환불번호
	private int pay_num;			//결제번호
	private Timestamp ear_sdate;	//교환환불 신청일
	private Timestamp ear_edate;	//교환환불 완료일
	private String ear_reason;		//교환환불 사유
	private String ear_status;		//교환환불 상태
	private String ear_invoice;		//교환송장번호
	
	public int getEar_num() {
		return ear_num;
	}
	public void setEar_num(int ear_num) {
		this.ear_num = ear_num;
	}
	public int getPay_num() {
		return pay_num;
	}
	public void setPay_num(int pay_num) {
		this.pay_num = pay_num;
	}
	public Timestamp getEar_sdate() {
		return ear_sdate;
	}
	public void setEar_sdate(Timestamp ear_sdate) {
		this.ear_sdate = ear_sdate;
	}
	public Timestamp getEar_edate() {
		return ear_edate;
	}
	public void setEar_edate(Timestamp ear_edate) {
		this.ear_edate = ear_edate;
	}
	public String getEar_reason() {
		return ear_reason;
	}
	public void setEar_reason(String ear_reason) {
		this.ear_reason = ear_reason;
	}
	public String getEar_status() {
		return ear_status;
	}
	public void setEar_status(String ear_status) {
		this.ear_status = ear_status;
	}
	public String getEar_invoice() {
		return ear_invoice;
	}
	public void setEar_invoice(String ear_invoice) {
		this.ear_invoice = ear_invoice;
	}

}
