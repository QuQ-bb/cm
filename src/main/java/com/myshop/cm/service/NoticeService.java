package com.myshop.cm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myshop.cm.dao.AdminDAO;
import com.myshop.cm.model.NoticeVO;

@Service
public class NoticeService {
	@Autowired  // DAO객체 주입
	private AdminDAO dao;
	
	// 공지 등록
	public int NoticeInsert(NoticeVO noticeVO) throws Exception{
		return dao.NoticeInsert(noticeVO);
	}
	// 공지 리스트
	public List<NoticeVO> noticelist(NoticeVO noticeVO) throws Exception{
		return dao.noticelist(noticeVO);
	}
}