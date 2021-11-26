package com.myshop.cm.model;

import java.util.Date;
import java.util.List;

public class GoodsVO {
	private int gds_num;
	private int lcate_code;
	private int mcate_code;
	private int scate_code;
	private String gds_seller;
	private String gds_name;
	private int gds_price;
	private String gds_detail;
	private String gds_option;
	private int gds_count;
	private String gds_thumbnail;
	private Date gds_date;
	private int deltem_num;
	private String gds_good;
	private int gds_readcount;
	private int gds_sellcount;
	private String gds_ears;
	private String gds_viewyn;
	private String gds_delyn;

	// 옵션을 받기위한 VO
	private List<String> optioncom;

	public List<String> getOptioncom() {
		return optioncom;
	}

	public void setOptioncom(List<String> optioncom) {
		this.optioncom = optioncom;
	}

	public int getGds_num() {
		return gds_num;
	}

	public void setGds_num(int gds_num) {
		this.gds_num = gds_num;
	}

	public int getLcate_code() {
		return lcate_code;
	}

	public void setLcate_code(int lcate_code) {
		this.lcate_code = lcate_code;
	}

	public int getMcate_code() {
		return mcate_code;
	}

	public void setMcate_code(int mcate_code) {
		this.mcate_code = mcate_code;
	}

	public int getScate_code() {
		return scate_code;
	}

	public void setScate_code(int scate_code) {
		this.scate_code = scate_code;
	}

	public String getGds_seller() {
		return gds_seller;
	}

	public void setGds_seller(String gds_seller) {
		this.gds_seller = gds_seller;
	}

	public String getGds_name() {
		return gds_name;
	}

	public void setGds_name(String gds_name) {
		this.gds_name = gds_name;
	}

	public int getGds_price() {
		return gds_price;
	}

	public void setGds_price(int gds_price) {
		this.gds_price = gds_price;
	}

	public String getGds_detail() {
		return gds_detail;
	}

	public void setGds_detail(String gds_detail) {
		this.gds_detail = gds_detail;
	}

	public String getGds_option() {
		return gds_option;
	}

	public void setGds_option(String gds_option) {
		this.gds_option = gds_option;
	}

	public int getGds_count() {
		return gds_count;
	}

	public void setGds_count(int gds_count) {
		this.gds_count = gds_count;
	}

	public String getGds_thumbnail() {
		return gds_thumbnail;
	}

	public void setGds_thumbnail(String gds_thumbnail) {
		this.gds_thumbnail = gds_thumbnail;
	}

	public Date getGds_date() {
		return gds_date;
	}

	public void setGds_date(Date gds_date) {
		this.gds_date = gds_date;
	}

	public int getDeltem_num() {
		return deltem_num;
	}

	public void setDeltem_num(int deltem_num) {
		this.deltem_num = deltem_num;
	}

	public String getGds_good() {
		return gds_good;
	}

	public void setGds_good(String gds_good) {
		this.gds_good = gds_good;
	}

	public int getGds_readcount() {
		return gds_readcount;
	}

	public void setGds_readcount(int gds_readcount) {
		this.gds_readcount = gds_readcount;
	}

	public int getGds_sellcount() {
		return gds_sellcount;
	}

	public void setGds_sellcount(int gds_sellcount) {
		this.gds_sellcount = gds_sellcount;
	}

	public String getGds_ears() {
		return gds_ears;
	}

	public void setGds_ears(String gds_ears) {
		this.gds_ears = gds_ears;
	}

	public String getGds_viewyn() {
		return gds_viewyn;
	}

	public void setGds_viewyn(String gds_viewyn) {
		this.gds_viewyn = gds_viewyn;
	}

	public String getGds_delyn() {
		return gds_delyn;
	}

	public void setGds_delyn(String gds_delyn) {
		this.gds_delyn = gds_delyn;
	}

}