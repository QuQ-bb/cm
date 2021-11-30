package com.myshop.cm.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.myshop.cm.model.LCateVO;
import com.myshop.cm.model.MCateVO;
import com.myshop.cm.model.SCateVO;

@Repository
public class CategoryDAO {
	@Autowired
	private SqlSession sqlSession;

	public List<LCateVO> getLCateList() throws Exception{
		return sqlSession.selectList("categoryMapper.select_lcate_list");
	}

	public List<MCateVO> getMCateList(int lcate_code) throws Exception{
		return sqlSession.selectList("categoryMapper.select_mcate_list", lcate_code);
	}

	public List<SCateVO> getSCateList(int mcate_code) throws Exception{
		return sqlSession.selectList("categoryMapper.select_scate_list", mcate_code);
	}
	

}
