package com.myshop.cm.dao;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.myshop.cm.model.OptionVO;

@Repository
public class OptionDAO {
	@Autowired
	private SqlSession sqlSession;
	
	// 대량옵션입력
	@Transactional
	public void insertOptions(Map<String, Object> map) {
		sqlSession.insert("optionMapper.insert_options", map);
		
	}

	public void insertOption(OptionVO optionvo) {
		sqlSession.insert("optionMapper.insert_option", optionvo);
		
	}

}