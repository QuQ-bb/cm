package com.myshop.cm.model;

import java.util.Date;

public class QnaVO {

//	CREATE TABLE `qna` (
//	  `qna_num` 	int(11) 	NOT NULL AUTO_INCREMENT COMMENT 'QNA번호',
//	  `qna_sort` 	varchar(50) NOT NULL 				COMMENT 'QNA 종류',
//	  `qna_title`	varchar(50) NOT NULL 				COMMENT 'QNA 제목',
//	  `qna_content` text 		NOT NULL 				COMMENT 'QNA 내용',
//	  `qna_ref` 	int(11) 	NOT NULL 				COMMENT 'ref',
//	  `qna_step` 	int(11) 	NOT NULL 				COMMENT 'step',
//	  `qna_depth` 	int(11) 	NOT NULL 				COMMENT 'depth',
//	  `qna_date` 	date 		NOT NULL 				COMMENT 'QNA 등록일',
//	  `qna_check` 	int(1) 		NOT NULL 				COMMENT 'QNA 읽음 여부',
//	  `qna_answer` 	int(1) 		NOT NULL 				COMMENT 'QNA 답변 여부',
//	  `qna_delyn`	int(1) 		NOT NULL 				COMMENT 'QNA Y/N',
//	  PRIMARY KEY (`qna_num`)
//	) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='QNA 게시판(1:1문의)';

	private int qna_num;
	private String qna_sort;
	private String qna_title;
	private String qna_content;
	private int qna_ref;
	private int qna_step;
	private int qna_depth;
	private Date qna_date;
	private int qna_check;
	private int qna_answer;
	private int qna_delyn;

	public int getQna_num() {
		return qna_num;
	}

	public void setQna_num(int qna_num) {
		this.qna_num = qna_num;
	}

	public String getQna_sort() {
		return qna_sort;
	}

	public void setQna_sort(String qna_sort) {
		this.qna_sort = qna_sort;
	}

	public String getQna_title() {
		return qna_title;
	}

	public void setQna_title(String qna_title) {
		this.qna_title = qna_title;
	}

	public String getQna_content() {
		return qna_content;
	}

	public void setQna_content(String qna_content) {
		this.qna_content = qna_content;
	}

	public int getQna_ref() {
		return qna_ref;
	}

	public void setQna_ref(int qna_ref) {
		this.qna_ref = qna_ref;
	}

	public int getQna_step() {
		return qna_step;
	}

	public void setQna_step(int qna_step) {
		this.qna_step = qna_step;
	}

	public int getQna_depth() {
		return qna_depth;
	}

	public void setQna_depth(int qna_depth) {
		this.qna_depth = qna_depth;
	}

	public Date getQna_date() {
		return qna_date;
	}

	public void setQna_date(Date qna_date) {
		this.qna_date = qna_date;
	}

	public int getQna_check() {
		return qna_check;
	}

	public void setQna_check(int qna_check) {
		this.qna_check = qna_check;
	}

	public int getQna_answer() {
		return qna_answer;
	}

	public void setQna_answer(int qna_answer) {
		this.qna_answer = qna_answer;
	}

	public int getQna_delyn() {
		return qna_delyn;
	}

	public void setQna_delyn(int qna_delyn) {
		this.qna_delyn = qna_delyn;
	}

}
