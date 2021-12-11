package com.myshop.cm.model;

import java.util.Date;

public class GoodsQnaVO {
	private int gdsqna_num;
	private int gds_num;
	private String gdsqna_sort;
	private String gdsqna_title;
	private String gdsqna_content;
	private int gdsqna_ref;
	private int gdsqna_step;
	private int gdsqna_depth;
	private Date gdsqna_date;
	private int gdsqna_check;
	private int gdsqna_answer;
	private int gdsqna_delyn;
	private int mem_num;
	
	// join으로 값을 가져올때
	private String gds_name;
	private String mem_id;
	private String gds_thumbnail;
	private String fname;
	
	public int getGdsqna_num() {
		return gdsqna_num;
	}
	public void setGdsqna_num(int gdsqna_num) {
		this.gdsqna_num = gdsqna_num;
	}
	public int getGds_num() {
		return gds_num;
	}
	public void setGds_num(int gds_num) {
		this.gds_num = gds_num;
	}
	public String getGdsqna_sort() {
		return gdsqna_sort;
	}
	public void setGdsqna_sort(String gdsqna_sort) {
		this.gdsqna_sort = gdsqna_sort;
	}
	public String getGdsqna_title() {
		return gdsqna_title;
	}
	public void setGdsqna_title(String gdsqna_title) {
		this.gdsqna_title = gdsqna_title;
	}
	public String getGdsqna_content() {
		return gdsqna_content;
	}
	public void setGdsqna_content(String gdsqna_content) {
		this.gdsqna_content = gdsqna_content;
	}
	public int getGdsqna_ref() {
		return gdsqna_ref;
	}
	public void setGdsqna_ref(int gdsqna_ref) {
		this.gdsqna_ref = gdsqna_ref;
	}
	public int getGdsqna_step() {
		return gdsqna_step;
	}
	public void setGdsqna_step(int gdsqna_step) {
		this.gdsqna_step = gdsqna_step;
	}
	public int getGdsqna_depth() {
		return gdsqna_depth;
	}
	public void setGdsqna_depth(int gdsqna_depth) {
		this.gdsqna_depth = gdsqna_depth;
	}
	public Date getGdsqna_date() {
		return gdsqna_date;
	}
	public void setGdsqna_date(Date gdsqna_date) {
		this.gdsqna_date = gdsqna_date;
	}
	public int getGdsqna_check() {
		return gdsqna_check;
	}
	public void setGdsqna_check(int gdsqna_check) {
		this.gdsqna_check = gdsqna_check;
	}
	public int getGdsqna_answer() {
		return gdsqna_answer;
	}
	public void setGdsqna_answer(int gdsqna_answer) {
		this.gdsqna_answer = gdsqna_answer;
	}
	public int getGdsqna_delyn() {
		return gdsqna_delyn;
	}
	public void setGdsqna_delyn(int gdsqna_delyn) {
		this.gdsqna_delyn = gdsqna_delyn;
	}
	public int getMem_num() {
		return mem_num;
	}
	public void setMem_num(int mem_num) {
		this.mem_num = mem_num;
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
	public String getGds_thumbnail() {
		return gds_thumbnail;
	}
	public void setGds_thumbnail(String gds_thumbnail) {
		this.gds_thumbnail = gds_thumbnail;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	
	
	
	

}
