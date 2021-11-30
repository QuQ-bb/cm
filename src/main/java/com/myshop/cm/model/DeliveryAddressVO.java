package com.myshop.cm.model;

public class DeliveryAddressVO {

	private int deladd_num;
	private int mem_num;	//오헹 요기가 같아도 상관이없나?그러겟지
	private String deladd_post;
	private String deladd_add1;	
	private String deladd_add2;	//상세주소
	private int deladd_mainadd;
	
	public int getDeladd_num() {
		return deladd_num;
	}
	public void setDeladd_num(int deladd_num) {
		this.deladd_num = deladd_num;
	}
	public int getMem_num() {
		return mem_num;
	}
	public void setMem_num(int mem_num) {
		this.mem_num = mem_num;
	}
	public String getDeladd_post() {
		return deladd_post;
	}
	public void setDeladd_post(String deladd_post) {
		this.deladd_post = deladd_post;
	}
	public String getDeladd_add1() {
		return deladd_add1;
	}
	public void setDeladd_add1(String deladd_add1) {
		this.deladd_add1 = deladd_add1;
	}
	public String getDeladd_add2() {
		return deladd_add2;
	}
	public void setDeladd_add2(String deladd_add2) {
		this.deladd_add2 = deladd_add2;
	}
	public int getDeladd_mainadd() {
		return deladd_mainadd;
	}
	public void setDeladd_mainadd(int deladd_mainadd) {
		this.deladd_mainadd = deladd_mainadd;
	}
}
