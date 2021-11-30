package com.myshop.cm.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.myshop.cm.model.OrderVO;
import com.myshop.cm.model.ReviewVO;

@Repository
public class MypageDAO {

	@Autowired
	private SqlSession sqlSession;

//	public int getHistoryListCount()throws Exception {
//		int count = 0;
//		count = sqlSession.selectOne("mypageMapper.history_count");
//		return 0;
//	}
//	//주문내역 목록
//	@Transactional
//	public List<OrderVO> getHistoryList(int pageIndex) throws Exception{
//		List<OrderVO> list = sqlSession.selectList("mypageMapper.history_list", pageIndex);
//		
//		return list;
//	}
//	@Transactional
//	public OrderVO getHistoryDetail(int ord_num) throws Exception{
//		OrderVO OrderVO = sqlSession.selectOne("mypageMapper.history_detail", ord_num);
//		return OrderVO;
//	}
	


	
}
