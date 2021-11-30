package com.myshop.cm.model;

public class OptionVO {
	private int opt_num;//pk
	private int gds_num;//상품번호
	private String opt_1stname;//옵션 카테고리명1
	private String opt_1stval;//옵션값1
	private String opt_2ndname;//옵션 카테고리명2
	private String opt_2ndval;//옵션값2
	private int opt_count;//재고

	public int getOpt_num() {
		return opt_num;
	}

	public void setOpt_num(int opt_num) {
		this.opt_num = opt_num;
	}

	public int getGds_num() {
		return gds_num;
	}

	public void setGds_num(int gds_num) {
		this.gds_num = gds_num;
	}

	public String getOpt_1stname() {
		return opt_1stname;
	}

	public void setOpt_1stname(String opt_1stname) {
		this.opt_1stname = opt_1stname;
	}

	public String getOpt_1stval() {
		return opt_1stval;
	}

	public void setOpt_1stval(String opt_1stval) {
		this.opt_1stval = opt_1stval;
	}

	public String getOpt_2ndname() {
		return opt_2ndname;
	}

	public void setOpt_2ndname(String opt_2ndname) {
		this.opt_2ndname = opt_2ndname;
	}

	public String getOpt_2ndval() {
		return opt_2ndval;
	}

	public void setOpt_2ndval(String opt_2ndval) {
		this.opt_2ndval = opt_2ndval;
	}

	public int getOpt_count() {
		return opt_count;
	}

	public void setOpt_count(int opt_count) {
		this.opt_count = opt_count;
	}
}