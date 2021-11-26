package com.myshop.cm.model;

import org.springframework.web.multipart.MultipartFile;

public class SearchVO {
	private MultipartFile gds_thumbnail; //첨부파일은 MultipartFile타입으로 저장한다.
	private String gbs_name;
	private int gbs_price;
	private int gbs_count;
	private String gbs_veiwyn;
	private String gbs_delyn;
	
	public MultipartFile getGds_thumbnail() {
		return gds_thumbnail;
	}
	public void setGds_thumbnail(MultipartFile gds_thumbnail) {
		this.gds_thumbnail = gds_thumbnail;
	}
	public String getGbs_name() {
		return gbs_name;
	}
	public void setGbs_name(String gbs_name) {
		this.gbs_name = gbs_name;
	}
	public int getGbs_price() {
		return gbs_price;
	}
	public void setGbs_price(int gbs_price) {
		this.gbs_price = gbs_price;
	}
	public int getGbs_count() {
		return gbs_count;
	}
	public void setGbs_count(int gbs_count) {
		this.gbs_count = gbs_count;
	}
	public String getGbs_veiwyn() {
		return gbs_veiwyn;
	}
	public void setGbs_veiwyn(String gbs_veiwyn) {
		this.gbs_veiwyn = gbs_veiwyn;
	}
	public String getGbs_delyn() {
		return gbs_delyn;
	}
	public void setGbs_delyn(String gbs_delyn) {
		this.gbs_delyn = gbs_delyn;
	}
	
	@Override
	public String toString() {
		return "SearchVO [gds_thumbnail=" + gds_thumbnail + ", gbs_name=" + gbs_name + ", gbs_price=" + gbs_price
				+ ", gbs_count=" + gbs_count + ", gbs_veiwyn=" + gbs_veiwyn + ", gbs_delyn=" + gbs_delyn + "]";
	}
}
