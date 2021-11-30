package com.myshop.cm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myshop.cm.dao.AdminDAO;
import com.myshop.cm.dao.CategoryDAO;
import com.myshop.cm.model.LCateVO;
import com.myshop.cm.model.MCateVO;
import com.myshop.cm.model.SCateVO;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryDAO categoryDAO;
	@Autowired  // DAO 객체 주입
	private AdminDAO dao;
	// 카테고리 리스트(대)
	public List<LCateVO> lcatelist(LCateVO lcateVO) throws Exception{
		return dao.lcatelist(lcateVO);
	}
	// 카테고리 등록(중)
	public int McateInsert(MCateVO mcateVO) throws Exception {
		return dao.McateInsert(mcateVO);
	}
	// 카테고리 리스트(중)
	public List<MCateVO> mcatelist(MCateVO mcateVO) throws Exception{
		return dao.mcatelist(mcateVO);
	}
	// 카테고리 등록(소)
	public int ScateInsert(SCateVO scateVO) throws Exception {
		return dao.ScateInsert(scateVO);
	}
	// 카테고리 리스트(소)
	public List<SCateVO> scatelist(SCateVO scateVO) throws Exception{
		return dao.scatelist(scateVO);
	}

	public List<LCateVO> getLCateList() throws Exception{
		return categoryDAO.getLCateList();
	}

	public List<MCateVO> getMCateList(int lcate_code) throws Exception{
		return categoryDAO.getMCateList(lcate_code);
	}

	public List<SCateVO> getSCateList(int mcate_code) throws Exception{
		return categoryDAO.getSCateList(mcate_code);
	}
}
