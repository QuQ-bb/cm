package com.myshop.cm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myshop.cm.dao.PayDetailDAO;
import com.myshop.cm.model.PayDetailVO;

@Service
public class PayDetailService {

	@Autowired
	private PayDetailDAO paydetailDao;

	public PayDetailVO getPayReview(int pay_num)throws Exception {
		PayDetailVO pay = paydetailDao.getPayReview(pay_num);
		return pay;
	}
}
