package com.myshop.cm.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.myshop.cm.model.DeliveryAddressVO;
import com.myshop.cm.model.MemberVO;

@Repository
public class MemberDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	//id 유효성검사
	@Transactional
	public int memberIdCheck(String mem_id) throws Exception {
		
		int result =-1;	//사용 가능 id
		MemberVO mv = (MemberVO) sqlSession.selectOne("memberns.login_check", mem_id);
		if(mv != null)
			result = 1;	//중복 id
		return result;
	}
	//회원가입 저장
	@Transactional
	public void insertMember(MemberVO member) throws Exception {
		sqlSession.insert("memberns.joinm", member);
	}
	//회원가입 주소지
	public void insertAddress(DeliveryAddressVO deliveryaddress) {
		sqlSession.insert("memberns.join", deliveryaddress);
	}
	//id값 불러서 mem_num구하기
	public int selectMemNum(MemberVO member) {
		return sqlSession.selectOne("memberns.selectNum", member);
	}
	//로그인 인증
	@Transactional
	public MemberVO loginCheck(String mem_id) throws Exception {
		return (MemberVO) sqlSession.selectOne("login_check", mem_id);
	}



}
