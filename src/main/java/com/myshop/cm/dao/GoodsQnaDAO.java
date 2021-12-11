package com.myshop.cm.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.myshop.cm.model.GoodsQnaVO;

@Repository
public class GoodsQnaDAO {
	@Autowired
	private SqlSession sqlSession;

	public int getGoodsQnaListCount(String sel_name) {
		return sqlSession.selectOne("goodsQnaMapper.select_goodsqna_list_count", sel_name);
	}

	public List<GoodsQnaVO> getGoodsQnaList(Map<String, Object> listIndexMap) {
		return sqlSession.selectList("goodsQnaMapper.select_goodsqna_list", listIndexMap);
	}

	// 답변이 달렸는지 확인하기
	public int getGoodsQnaAnswer(int gdsqna_num) {
		return sqlSession.selectOne("goodsQnaMapper.select_goodsqna_check", gdsqna_num);
	}

	// 문의글 가져오기
	public GoodsQnaVO getGoodsQuestionDetail(int gdsqna_num) {
		return sqlSession.selectOne("goodsQnaMapper.select_goodsqna_question", gdsqna_num);
	}

	// 답변글 가져오기
	public GoodsQnaVO getGoodsAnswerDetail(int gdsqna_num) {
		return sqlSession.selectOne("goodsQnaMapper.select_goodsqna_answer", gdsqna_num);
	}


}
