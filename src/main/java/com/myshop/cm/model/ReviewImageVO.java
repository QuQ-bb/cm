package com.myshop.cm.model;

public class ReviewImageVO {
	private int revimg_num;			//후기 이미지번호
	private int rev_num;			//후기 번호
	private String revimg_filename;	//파일 이름
	
	public int getRevimg_num() {
		return revimg_num;
	}
	public void setRevimg_num(int revimg_num) {
		this.revimg_num = revimg_num;
	}
	public int getRev_num() {
		return rev_num;
	}
	public void setRev_num(int rev_num) {
		this.rev_num = rev_num;
	}
	public String getRevimg_filename() {
		return revimg_filename;
	}
	public void setRevimg_filename(String revimg_filename) {
		this.revimg_filename = revimg_filename;
	}

}
