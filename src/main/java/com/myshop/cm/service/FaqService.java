package com.myshop.cm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myshop.cm.dao.AdminDAO;
import com.myshop.cm.model.FaqVO;

@Service
public class FaqService {
	@Autowired // DAO 객체 주입
	AdminDAO dao;
	// FAQ 등록
	public int FaqInsert(FaqVO faqVO) throws Exception{
		return dao.FaqInsert(faqVO);
	}
	// FAQ 리스트
	public List<FaqVO> faqlist(FaqVO faqVO) throws Exception{
		return dao.faqlist(faqVO);
	}
}
