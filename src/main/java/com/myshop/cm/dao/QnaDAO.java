package com.myshop.cm.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.myshop.cm.model.QnaVO;
import com.myshop.cm.util.Pager;

@Repository
public class QnaDAO {

	@Inject
	private SqlSession sqlSession;
	private final static String NAMESPACE = "qnaMapper.";
	
	//전체 글 개수
	public int qnaCount(Pager pager) throws Exception{
		return sqlSession.selectOne(NAMESPACE+"qnaCount", pager);
	}
	
	//리스트
	public List<QnaVO> qnaList(Pager pager) throws Exception{
		return sqlSession.selectList(NAMESPACE+"qnaList", pager);
	}
}
