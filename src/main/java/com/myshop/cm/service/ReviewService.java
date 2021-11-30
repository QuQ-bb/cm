package com.myshop.cm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myshop.cm.dao.ReviewDAO;
import com.myshop.cm.model.MemberVO;
import com.myshop.cm.model.ReviewVO;

@Service
public class ReviewService {
		
	@Autowired
	private ReviewDAO reviewDao;
	
	//리뷰저장
	public void insertReview(ReviewVO review) throws Exception{
		reviewDao.insertReview(review);
		System.out.println("리뷰쓰기 서비스");
	}
	//게시물 갯수
	public int getListCount() throws Exception{
		return reviewDao.getListCount();
	}
	//리뷰 목록
	public List<ReviewVO> getReviewList(int pageIndex)throws Exception {
		return reviewDao.getReviewList(pageIndex);
	}
	//리뷰 상세정보
	public ReviewVO getReviewCont(int rev_num) throws Exception{
		ReviewVO review = reviewDao.getReviewCont(rev_num);
		return review;
	}
//	public ReviewVO getReview(int rev_num)throws Exception {
//		
//		return null;
//	}
//	public MemberVO getMember(MemberVO member) throws Exception {
//		return reviewDao.getMember(member);
//	}
	//리뷰 수정
	public void reviewUpdate(ReviewVO review)throws Exception {
		System.out.println("서비스거기 계세요?");
		reviewDao.reviewUpdate(review);
	}
	public void reviewDelete(int rev_num)throws Exception {
		System.out.println("거기 삭제서비스 계세요?");
		reviewDao.reviewDelete(rev_num);
	}
}
