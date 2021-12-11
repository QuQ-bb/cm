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

	//내가 쓴 문의글 카운트
	public int getMyGoodsQnaListCount(int mem_num) throws Exception {
		return sqlSession.selectOne("goodsQnaMapper.select_mygoodsqna_list_count",mem_num);
	}
	//내가 쓴 문의글 리스트
	public List<GoodsQnaVO> getMyGoodsQnaList(Map<String, Object> listIndexMap)throws Exception {
		return sqlSession.selectList("goodsQnaMapper.select_mygoodsqna_list", listIndexMap);
	}
	//내가 쓴 문의글 답변 여부 확인
	public int getmyGoodsQnaAnswer(int gdsqna_num)throws Exception {
		return sqlSession.selectOne("goodsQnaMapper.mygoodsqna_answer", gdsqna_num);
	}
	//문의글 가져오기
	public GoodsQnaVO getmyGoodsQuestionDetail(int gdsqna_num)throws Exception {
		return sqlSession.selectOne("goodsQnaMapper.mygoodsqna_question", gdsqna_num);
	}
	//문의 답변가져오기
	public GoodsQnaVO getmyGoodsAnswerDetail(int gdsqna_num)throws Exception {
		return sqlSession.selectOne("goodsQnaMapper.mygoodsqna_answerdetail", gdsqna_num);
	}
}
