package com.myshop.cm.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.myshop.cm.dao.StoreDAO;
import com.myshop.cm.model.GoodsVO;
import com.myshop.cm.util.Pager;

@Service
public class StoreService {

	@Inject
	private StoreDAO storeDAO;
	
	// 상품 리스트
	public List<GoodsVO> storeList(Pager pager) throws Exception {
		return storeDAO.storeList(pager);
	}
}