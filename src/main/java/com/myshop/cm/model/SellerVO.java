package com.myshop.cm.model;

public class SellerVO {
	private int sel_num;			//판매자 번호
	private int mem_num;			//회원번호
	private String sel_bnum;		//판매자 사업자등록번호
	private String sel_name;		//판매자 상호명
	private String sel_ceo;			//판매자 대표자
	private String sel_mobnum;		//판매자 통신판매업번호
	private String sel_post;		//판매자 사업장 우편번호
	private String sel_add;			//판매자 사업장 소재지
	private String sel_tel;			//판매자 사업장 연락처
	private String sel_bank;		//판매자 정산 은행
	private String sel_accholder;	//판매자 정산 계좌예금주
	private String sel_acc;			//판매자 정산 계좌번호
	private String sel_yn;			//판매자 정지y/n
	private String seling_filename;
	
	public String getSeling_filename() {
		return seling_filename;
	}
	public void setSeling_filename(String seling_filename) {
		this.seling_filename = seling_filename;
	}
	public int getSel_num() {
		return sel_num;
	}
	public void setSel_num(int sel_num) {
		this.sel_num = sel_num;
	}
	public int getMem_num() {
		return mem_num;
	}
	public void setMem_num(int mem_num) {
		this.mem_num = mem_num;
	}
	public String getSel_bnum() {
		return sel_bnum;
	}
	public void setSel_bnum(String sel_bnum) {
		this.sel_bnum = sel_bnum;
	}
	public String getSel_name() {
		return sel_name;
	}
	public void setSel_name(String sel_name) {
		this.sel_name = sel_name;
	}
	public String getSel_ceo() {
		return sel_ceo;
	}
	public void setSel_ceo(String sel_ceo) {
		this.sel_ceo = sel_ceo;
	}
	public String getSel_mobnum() {
		return sel_mobnum;
	}
	public void setSel_mobnum(String sel_mobnum) {
		this.sel_mobnum = sel_mobnum;
	}
	public String getSel_post() {
		return sel_post;
	}
	public void setSel_post(String sel_post) {
		this.sel_post = sel_post;
	}
	public String getSel_add() {
		return sel_add;
	}
	public void setSel_add(String sel_add) {
		this.sel_add = sel_add;
	}
	public String getSel_tel() {
		return sel_tel;
	}
	public void setSel_tel(String sel_tel) {
		this.sel_tel = sel_tel;
	}
	public String getSel_bank() {
		return sel_bank;
	}
	public void setSel_bank(String sel_bank) {
		this.sel_bank = sel_bank;
	}
	public String getSel_accholder() {
		return sel_accholder;
	}
	public void setSel_accholder(String sel_accholder) {
		this.sel_accholder = sel_accholder;
	}
	public String getSel_acc() {
		return sel_acc;
	}
	public void setSel_acc(String sel_acc) {
		this.sel_acc = sel_acc;
	}
	public String getSel_yn() {
		return sel_yn;
	}
	public void setSel_yn(String sel_yn) {
		this.sel_yn = sel_yn;
	}

}
