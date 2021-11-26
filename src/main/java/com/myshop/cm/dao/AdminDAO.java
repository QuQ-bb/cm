package com.myshop.cm.dao;

import java.util.List;


import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.myshop.cm.model.FaqVO;
import com.myshop.cm.model.LcateVO;
import com.myshop.cm.model.McateVO;
import com.myshop.cm.model.NoticeVO;
import com.myshop.cm.model.ScateVO;

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
	// 카테고리 등록(대)
	public int LcateInsert(LcateVO lcateVO) throws Exception {
		return session.insert("insertlcate", lcateVO);
	}
	// 카테고리 리스트(대)
	public List<LcateVO> lcatelist(LcateVO lcateVO) throws Exception{
		return session.selectList("lcatelist");
	}
	// 카테고리 등록(중)
	public int McateInsert(McateVO mcateVO) throws Exception {
		return session.insert("insertmcate", mcateVO);
	}
	// 카테고리 리스트(중)
	public List<McateVO> mcatelist(McateVO mcateVO) throws Exception{
		return session.selectList("mcatelist");
	}
	// 카테고리 등록(소)
	public int ScateInsert(ScateVO scateVO) throws Exception {
		return session.insert("insertscate", scateVO);
	}
	// 카테고리 리스트(소)
	public List<ScateVO> scatelist(ScateVO scateVO) throws Exception{
		return session.selectList("scatelist");
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
		return session.insert("insertnt", noticeVO);
	}
	// 공지 리스트
	public List<NoticeVO> noticelist(NoticeVO noticeVO) throws Exception{
		return session.selectList("noticelist");
	}
}