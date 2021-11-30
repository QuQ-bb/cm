package com.myshop.cm.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myshop.cm.dao.OptionDAO;
import com.myshop.cm.model.OptionVO;

@Service
public class OptionService {
	@Autowired
	private OptionDAO optionDAO;

	// 대량옵션입력
	public void insertOptions(Map<String, Object> map) {
		optionDAO.insertOptions(map);
		
	}

	public void insertOption(OptionVO optionvo) {
		optionDAO.insertOption(optionvo);
		
	}

}