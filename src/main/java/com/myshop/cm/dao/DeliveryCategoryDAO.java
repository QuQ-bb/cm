package com.myshop.cm.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.myshop.cm.model.DeliveryCategoryVO;

@Repository
public class DeliveryCategoryDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	// 배송사 카테고리 리스트 불러오기
	@Transactional
	public List<DeliveryCategoryVO> getCateList() throws Exception{
		List<DeliveryCategoryVO> getCateList = sqlSession.selectList("deliveryMapper.delivery_cate_list");
		return getCateList;
	}

	// 배송사 코드로 배송사명 가져오기
//	@Transactional
//	public DeliveryCategoryVO getDelName(int del_code) {
//		DeliveryCategoryVO getDelName = sqlSession.selectOne("deliveryMapper.get_delivery_name", del_code);
//		return getDelName;
//	}

}