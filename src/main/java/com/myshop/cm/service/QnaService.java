package com.myshop.cm.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.myshop.cm.dao.QnaDAO;
import com.myshop.cm.model.QnaVO;
import com.myshop.cm.util.Pager;

@Service
public class QnaService {

	@Inject
	private QnaDAO qnaDAO;
	
	//리스트
	public List<QnaVO> qnaList(Pager pager) throws Exception{
		
		pager.makeRow();
		pager.makePage(qnaDAO.qnaCount(pager));
		
		return qnaDAO.qnaList(pager);
	}
}
