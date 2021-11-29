package com.myshop.cm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myshop.cm.dao.CategoryDAO;
import com.myshop.cm.model.LCateVO;
import com.myshop.cm.model.MCateVO;
import com.myshop.cm.model.SCateVO;

@Service
public class CategoryService {
	@Autowired
	private CategoryDAO categoryDAO;

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
