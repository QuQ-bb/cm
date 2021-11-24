package com.myshop.cm.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.myshop.cm.model.CalculateVO;

@Repository
public class CalculateDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	
	@Transactional
	public int getCalculListCount() throws Exception{
		int count = 0;
		count = ((Integer) sqlSession.selectOne("calculatorMapper.select_calcul_count"));
		
		return count;
	}
	
	@Transactional
	public List<CalculateVO> getCalculateList(int pageIndex) throws Exception{
		List<CalculateVO> list = sqlSession.selectList("calculatorMapper.select_calcul_list", pageIndex);
		
		return list;
	}
	
	
	@Transactional
	public CalculateVO getCalculDetail(int clcln_num) throws Exception{
		CalculateVO calculateVO = sqlSession.selectOne("calculatorMapper.select_calcul_detail", clcln_num);
		return calculateVO;
	}
	

}
