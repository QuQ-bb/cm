package com.myshop.cm.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myshop.cm.dao.AdminDAO;
import com.myshop.cm.model.LcateVO;
import com.myshop.cm.model.McateVO;
import com.myshop.cm.model.ScateVO;

@Service
public class CategoryService {
	@Autowired  // DAO 객체 주입
	private AdminDAO dao;
	// 카테고리 등록(대)
	public int LcateInsert(LcateVO lcateVO) throws Exception {
		return dao.LcateInsert(lcateVO);
	}
	// 카테고리 리스트(대)
	public List<LcateVO> lcatelist(LcateVO lcateVO) throws Exception{
		return dao.lcatelist(lcateVO);
	}
	// 카테고리 등록(중)
	public int McateInsert(McateVO mcateVO) throws Exception {
		return dao.McateInsert(mcateVO);
	}
	// 카테고리 리스트(중)
	public List<McateVO> mcatelist(McateVO mcateVO) throws Exception{
		return dao.mcatelist(mcateVO);
	}
	// 카테고리 등록(소)
	public int ScateInsert(ScateVO scateVO) throws Exception {
		return dao.ScateInsert(scateVO);
	}
	// 카테고리 리스트(소)
	public List<ScateVO> scatelist(ScateVO scateVO) throws Exception{
		return dao.scatelist(scateVO);
	}
}