package com.myshop.cm.model;

import org.springframework.web.multipart.MultipartFile;

public class GoodsImageVO {
	
	// goodsimage table columns
	private int gdsimg_num;
	private String gdsimg_filename;
	private int gds_num;
	
	// 파일 업로드 관련
	private MultipartFile Filedata;
	private String callback;
	private String callback_func;
	
	public int getGdsimg_num() {
		return gdsimg_num;
	}
	public void setGdsimg_num(int gdsimg_num) {
		this.gdsimg_num = gdsimg_num;
	}
	public String getGdsimg_filename() {
		return gdsimg_filename;
	}
	public void setGdsimg_filename(String gdsimg_filename) {
		this.gdsimg_filename = gdsimg_filename;
	}
	public int getGds_num() {
		return gds_num;
	}
	public void setGds_num(int gds_num) {
		this.gds_num = gds_num;
	}
	public MultipartFile getFiledata() {
		return Filedata;
	}
	public void setFiledata(MultipartFile filedata) {
		Filedata = filedata;
	}
	public String getCallback() {
		return callback;
	}
	public void setCallback(String callback) {
		this.callback = callback;
	}
	public String getCallback_func() {
		return callback_func;
	}
	public void setCallback_func(String callback_func) {
		this.callback_func = callback_func;
	}
	
	
}