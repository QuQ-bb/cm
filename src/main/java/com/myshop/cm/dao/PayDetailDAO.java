package com.myshop.cm.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.myshop.cm.model.OrderVO;
import com.myshop.cm.model.PayDetailVO;

@Repository
public class PayDetailDAO {

	@Autowired
	private SqlSession sqlSession;

	public PayDetailVO getPayReview(int pay_num)throws Exception {
		PayDetailVO pay= sqlSession.selectOne("paydetailMapper.review_pay", pay_num);
		return pay;
	}
}
