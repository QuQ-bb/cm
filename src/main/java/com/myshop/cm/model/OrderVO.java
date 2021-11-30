package com.myshop.cm.model;

public class OrderVO {
	private int ord_num;
	private int ord_memnum;
	private int ord_gdsnum;
	private int ord_gdsoption;
	private int ord_gdscount;
	private int ord_delfee;
	private String ord_request;
	private int ord_totalprice;
	
	// 주문정보를 토대로 받아올 추가정보들
    private String gds_thumbnail;
    private String gds_name;
    private String mem_id;
    private String opt_1stname;
    private String opt_1stval; 
    private String opt_2ndname;
    private String opt_2ndval;
	
	public int getOrd_num() {
		return ord_num;
	}
	public void setOrd_num(int ord_num) {
		this.ord_num = ord_num;
	}
	public int getOrd_memnum() {
		return ord_memnum;
	}
	public void setOrd_memnum(int ord_memnum) {
		this.ord_memnum = ord_memnum;
	}
	public int getOrd_gdsnum() {
		return ord_gdsnum;
	}
	public void setOrd_gdsnum(int ord_gdsnum) {
		this.ord_gdsnum = ord_gdsnum;
	}
	public int getOrd_gdsoption() {
		return ord_gdsoption;
	}
	public void setOrd_gdsoption(int ord_gdsoption) {
		this.ord_gdsoption = ord_gdsoption;
	}
	public int getOrd_gdscount() {
		return ord_gdscount;
	}
	public void setOrd_gdscount(int ord_gdscount) {
		this.ord_gdscount = ord_gdscount;
	}
	public int getOrd_delfee() {
		return ord_delfee;
	}
	public void setOrd_delfee(int ord_delfee) {
		this.ord_delfee = ord_delfee;
	}
	public String getOrd_request() {
		return ord_request;
	}
	public void setOrd_request(String ord_request) {
		this.ord_request = ord_request;
	}
	public int getOrd_totalprice() {
		return ord_totalprice;
	}
	public void setOrd_totalprice(int ord_totalprice) {
		this.ord_totalprice = ord_totalprice;
	}
	
	public String getGds_thumbnail() {
		return gds_thumbnail;
	}
	public void setGds_thumbnail(String gds_thumbnail) {
		this.gds_thumbnail = gds_thumbnail;
	}
	public String getGds_name() {
		return gds_name;
	}
	public void setGds_name(String gds_name) {
		this.gds_name = gds_name;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
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

}
