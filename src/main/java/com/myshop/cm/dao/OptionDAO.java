package com.myshop.cm.dao;

import java.util.List;
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
	
	// 여러옵션입력
	@Transactional
	public void insertOptions(Map<String, Object> map) throws Exception{
		sqlSession.insert("optionMapper.insert_options", map);
	}

	// 옵션 단일입력
	@Transactional
	public void insertOption(OptionVO optionvo) throws Exception{
		sqlSession.insert("optionMapper.insert_option", optionvo);
	}

	// 상품별 옵션리스트 출력
	@Transactional
	public List<OptionVO> optionlist(int gds_num) throws Exception{
		List<OptionVO> list = sqlSession.selectList("optionMapper.select_option_list", gds_num);
		return list;
	}

	// 여러옵션 삭제
	@Transactional
	public void deleteOptions(int gds_num) throws Exception{
		sqlSession.delete("optionMapper.delete_options", gds_num);
	}

	// 여러옵션 수정
	@Transactional
	public void updateOptions(Map<String, Object> map) {
		sqlSession.update("optionMapper.update_options",map);
	}

	// 단일옵션 수정
	@Transactional
	public void updateOption(OptionVO optionvo) {
		sqlSession.update("optionMapper.update_option",optionvo);
	}

}
