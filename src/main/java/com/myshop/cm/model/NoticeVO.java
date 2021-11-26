package com.myshop.cm.model;

import java.sql.Timestamp;

public class NoticeVO {
	private int ntc_num;
	private String ntc_sort;
	private String ntc_title;
	private String ntc_content;
	private Timestamp ntc_date;
	private String ntc_check;
	private String ntc_delyn;
	public int getNtc_num() {
		return ntc_num;
	}
	public void setNtc_num(int ntc_num) {
		this.ntc_num = ntc_num;
	}
	public String getNtc_sort() {
		return ntc_sort;
	}
	public void setNtc_sort(String ntc_sort) {
		this.ntc_sort = ntc_sort;
	}
	public String getNtc_title() {
		return ntc_title;
	}
	public void setNtc_title(String ntc_title) {
		this.ntc_title = ntc_title;
	}
	public String getNtc_content() {
		return ntc_content;
	}
	public void setNtc_content(String ntc_content) {
		this.ntc_content = ntc_content;
	}
	public Timestamp getNtc_date() {
		return ntc_date;
	}
	public void setNtc_date(Timestamp ntc_date) {
		this.ntc_date = ntc_date;
	}
	public String getNtc_check() {
		return ntc_check;
	}
	public void setNtc_check(String ntc_check) {
		this.ntc_check = ntc_check;
	}
	public String getNtc_delyn() {
		return ntc_delyn;
	}
	public void setNtc_delyn(String ntc_delyn) {
		this.ntc_delyn = ntc_delyn;
	}
		
}