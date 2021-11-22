package com.myshop.cm.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myshop.cm.dao.AdminDAO;
import com.myshop.cm.model.CategoryVO;

@Service
public class CategoryService {
	@Autowired  // DAO 객체 주입
	private AdminDAO dao;
	// 카테고리 등록
	public int CategoryInsert(CategoryVO categoryVO) throws Exception {
		return dao.CategoryInsert(categoryVO);
	}
	// 카테고리 리스트
	public List<CategoryVO> catelist(CategoryVO categoryVO) throws Exception{
		return dao.catelist(categoryVO);
	}
}
