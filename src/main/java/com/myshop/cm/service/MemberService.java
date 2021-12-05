package com.myshop.cm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myshop.cm.dao.AdminDAO;
import com.myshop.cm.dao.MemberDAO;
import com.myshop.cm.model.DeliveryAddressVO;
import com.myshop.cm.model.MemberVO;

@Service
public class MemberService {
	
	@Autowired
	private MemberDAO memberDao;
	@Autowired
	private AdminDAO dao;
	
	//ID유효성 검사
	/*
	 * public int memberIdCheck(String mem_id) throws Exception { return
	 * memberDao.memberIdCheck(mem_id); }
	 */
	public int memberIdCheck(String mem_id) {
		System.out.println("id유효성 서비스");
		return memberDao.memberIdCheck(mem_id);
	}
	//회원가입 member저장
	public void insertMember(MemberVO member) throws Exception {
		 memberDao.insertMember(member);
	}
	//로그인 저장 인증
	public MemberVO loginCheck(String mem_id) throws Exception {
		return memberDao.loginCheck(mem_id);
	}
	//회원가입 deliveryaddress저장
	public void insertDelivery(DeliveryAddressVO deliveryaddress) {
		memberDao.insertAddress(deliveryaddress);
	}
	//id값 불러서 mem_num구하기
	public int selectMemNum(MemberVO member) {
		int mem = memberDao.selectMemNum(member);
		return mem;
	}
	//아이디 찾기 
	public MemberVO idFind(String mem_name) throws Exception{
		return memberDao.idFind(mem_name);
	}
	//비밀번호 찾기
	public MemberVO passFind(MemberVO member) throws Exception {
		System.out.println("비밀번호 찾기서비스");
		return memberDao.passFind(member);
	}
	//회원 수정
	public void memberUpdate(MemberVO member) {
		memberDao.memberUpdate(member);
		System.out.println("수정폼 서비스");
	}
	
	//회원 삭제
	public void deleteMember(MemberVO delmv) throws Exception{
		memberDao.deleteMember(delmv);
		System.out.println("탈퇴 서비스");
	}
	public MemberVO getMemberInfo(String mem_id) throws Exception{
		MemberVO member = memberDao.getMemberInfo(mem_id);
		return member;
	}
	//

	public MemberVO getmemberinfo(int mem_num) {
		return (MemberVO)memberDao.getmemberInfo(mem_num);
	}
	// 회원리스트(admin)
	public List<MemberVO> memlist(MemberVO memberVO) throws Exception{
		return dao.memlist(memberVO);
	}
	// 회원 리스트 상세정보(admin)
	public MemberVO memdetail(String mem_name) throws Exception{
		MemberVO memberVO = dao.memdetail(mem_name);
		return memberVO;
	}
}

