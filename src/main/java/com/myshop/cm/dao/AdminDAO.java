package com.myshop.cm.dao;

import java.util.List;


import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.myshop.cm.model.CategoryVO;
import com.myshop.cm.model.FaqVO;
import com.myshop.cm.model.NoticeVO;

@Repository
/*
 * public interface AdminDAO {
 * 
 * List<CategoryVO> catelist();
 * 
 * int CategoryInsert(CategoryVO categoryVO);
 * 
 * }
 */
public class AdminDAO {
	@Autowired
	private SqlSession session;
	// 카테고리 등록
	public int CategoryInsert(CategoryVO categoryVO) throws Exception {
		return session.insert("insertcate", categoryVO);
	}
	// 카테고리 리스트
	public List<CategoryVO> catelist(CategoryVO categoryVO) throws Exception{
		return session.selectList("catelist");
	}
	// FAQ 등록
	public int FaqInsert(FaqVO faqVO) throws Exception{
		return session.insert("insertfaq", faqVO); 
	}
	// FAQ 리스트
	public List<FaqVO> faqlist(FaqVO faqVO) throws Exception{
		return session.selectList("faqlist");
	}
	// 공지 등록
	public int NoticeInsert(NoticeVO noticeVO) throws Exception{
		return session.insert("insertnotice", noticeVO);
	}
	// 공지 리스트
	public List<NoticeVO> noticelist(NoticeVO noticeVO) throws Exception{
		return session.selectList("noticelist");
	}
}
