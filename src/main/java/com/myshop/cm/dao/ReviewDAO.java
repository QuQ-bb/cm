package com.myshop.cm.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.myshop.cm.model.MemberVO;
import com.myshop.cm.model.ReviewVO;

@Repository
public class ReviewDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	//리뷰 저장
	public void insertReview(ReviewVO review) {
		sqlSession.insert("reviewMapper.insert_review", review);
		System.out.println("리뷰쓰기 DAO");
	}
	//리뷰 총갯수
	public int getListCount(int mem_num) throws Exception{
		int count =0;
		count =sqlSession.selectOne("reviewMapper.review_count", mem_num);
		return count;
	}
	//리뷰 목록
	public List<ReviewVO> getReviewList(Map<String, Object> indexMap) throws Exception {
		List<ReviewVO> list = sqlSession.selectList("reviewMapper.review_list", indexMap);
		return list;
	}
	//리뷰 내용보기
	@Transactional
	public ReviewVO getReviewCont(int rev_num) throws Exception {
		ReviewVO review = sqlSession.selectOne("reviewMapper.review_cont", rev_num);
		return review;
				
	}
//	public MemberVO getMember(MemberVO member)throws Exception {
//		return sqlSession.selectOne("reviewMapper.selectmember", member);
//	}
	//리뷰수정
	public void reviewUpdate(ReviewVO review)throws Exception {
		sqlSession.update("reviewMapper.review_update",review);
		System.out.println("dao거기 계세요?");
	}
	//리뷰삭제
	public void reviewDelete(int rev_num)throws Exception {
		sqlSession.delete("reviewMapper.review_delete",rev_num);
	}
	
}
