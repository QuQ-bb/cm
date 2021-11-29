package com.myshop.cm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myshop.cm.dao.MemberDAO;
import com.myshop.cm.model.MemberVO;

@Service
public class MemberService {
	@Autowired
	private MemberDAO memberDAO;

	public MemberVO getmemberinfo(int mem_num) {
		return (MemberVO)memberDAO.getmemberInfo(mem_num);
	}

}
