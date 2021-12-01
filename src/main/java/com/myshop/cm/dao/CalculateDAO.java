package com.myshop.cm.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.myshop.cm.model.CalculateVO;

@Repository
public class CalculateDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	// 판매자 정산 리스트 개수 불러오기
	@Transactional
	public int getCalculListCount(int sel_num) throws Exception{
		int count = 0;
		count = ((Integer) sqlSession.selectOne("calculatorMapper.select_calcul_count", sel_num));
		
		return count;
	}
	
	// 판매자 정산 리스트 불러오기
	@Transactional
	public List<CalculateVO> getCalculateList(Map<String, Object> listIndexMap) throws Exception{
		List<CalculateVO> list = sqlSession.selectList("calculatorMapper.select_calcul_list", listIndexMap);
		
		return list;
	}
	
	// 판매자 정산 상세페이지
	@Transactional
	public CalculateVO getCalculDetail(int clcln_num) throws Exception{
		CalculateVO calculateVO = sqlSession.selectOne("calculatorMapper.select_calcul_detail", clcln_num);
		return calculateVO;
	}
	

}

