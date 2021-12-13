package com.myshop.cm.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.myshop.cm.model.FaqVO;
import com.myshop.cm.model.LCateVO;
import com.myshop.cm.model.MCateVO;
import com.myshop.cm.model.MemberVO;
import com.myshop.cm.model.NoticeVO;
import com.myshop.cm.model.SCateVO;
import com.myshop.cm.model.SellerVO;

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
	public int LcateInsert(LCateVO lcateVO) throws Exception {
		return session.insert("insertlcate", lcateVO);
	}
	// 카테고리 리스트(대)
	public List<LCateVO> lcatelist(LCateVO lcateVO) throws Exception{
		return session.selectList("lcatelist");
	}
	// 카테고리 등록(중)
	public int McateInsert(MCateVO mcateVO) throws Exception {
		return session.insert("insertmcate", mcateVO);
	}
	// 카테고리 리스트(중)
	public List<MCateVO> mcatelist(MCateVO mcateVO) throws Exception{
		return session.selectList("mcatelist");
	}
	// 카테고리 등록(소)
	public int ScateInsert(SCateVO scateVO) throws Exception {
		return session.insert("insertscate", scateVO);
	}
	// 카테고리 리스트(소)
	public List<SCateVO> scatelist(SCateVO scateVO) throws Exception{
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
	// 공지 내용보기
	public NoticeVO ntcdetail(String ntc_title) throws Exception{
		return session.selectOne("ntcdetail", ntc_title);
	}
	// 회원 리스트
	public List<MemberVO> memlist(MemberVO memberVO) throws Exception{
		return session.selectList("memlist");
	}
	// 회원 리스트 내용보기
	public MemberVO memdetail(String mem_name) throws Exception{
		return (MemberVO) session.selectOne("memdetail", mem_name);
	}
	// 판매자 리스트
	public List<SellerVO> sellist(SellerVO sellerVO) throws Exception{
		return session.selectList("sellist");
	}
	// 판매자 리스트 내용보기
	public SellerVO seldetail(String sel_name) throws Exception{
		return (SellerVO) session.selectOne("seldetail", sel_name);
	}
	// 판매자 신청 리스트
	public List<MemberVO> chglist(SellerVO sellerVO) throws Exception{
		return session.selectList("chglist");
	}
	// 판매자 신청 내용보기
	public SellerVO chgdetail(String sel_name) throws Exception{
		return (SellerVO) session.selectOne("chgdetail", sel_name);
	}
	// 판매자 전환 승인
	public int UpdateMemgrade (MemberVO memberVO) throws Exception{
		return session.update("sellerupdate", memberVO);
	}
	// 관리자 로그인 인증
	@Transactional
	public MemberVO adminchk(String mem_id) throws Exception{
		return (MemberVO) session.selectOne("adminchk", mem_id);
	}
}
