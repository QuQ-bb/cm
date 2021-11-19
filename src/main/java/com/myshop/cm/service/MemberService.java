package com.myshop.cm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myshop.cm.dao.MemberDAO;
import com.myshop.cm.model.DeliveryAddressVO;
import com.myshop.cm.model.MemberVO;

@Service
public class MemberService {

	@Autowired
	private MemberDAO memberDao;
	
	//ID유효성 검사
	public int memberIdCheck(String mem_id) throws Exception {
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
	
	//회원 수정
	
	
	//회원 삭제
	
}
