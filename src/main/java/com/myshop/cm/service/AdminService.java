package com.myshop.cm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myshop.cm.dao.AdminDAO;
import com.myshop.cm.model.MemberVO;
import com.myshop.cm.model.SellerVO;

@Service
public class AdminService {
	@Autowired AdminDAO dao;
	public MemberVO adminchk(String mem_id) throws Exception{
		return dao.adminchk(mem_id);
	}
	// 판매자 신청 리스트
	public List<MemberVO> chglist(SellerVO sellerVO) throws Exception{
		return dao.chglist(sellerVO);
	}
	// 상세정보
	public SellerVO chgdetail(int sel_num) throws Exception{
		SellerVO sellerVO = dao.chgdetail(sel_num);
		return sellerVO;
	}
}