package com.myshop.cm.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myshop.cm.dao.OptionDAO;
import com.myshop.cm.model.OptionVO;

@Service
public class OptionService {
	@Autowired
	private OptionDAO optionDAO;

	// 여러옵션입력
	public void insertOptions(Map<String, Object> map) throws Exception{
		optionDAO.insertOptions(map);
	}
	
	// 단일옵션 입력
	public void insertOption(OptionVO optionvo) throws Exception{
		optionDAO.insertOption(optionvo);
	}
	
	// 상품별 리스트 가져오기
	public List<OptionVO> optionlist(int gds_num) throws Exception{
		List<OptionVO> optionlist = optionDAO.optionlist(gds_num);
		
		return optionlist;
	}

	// 여러옵션삭제
	public void deleteOptions(int gds_num) throws Exception{
		optionDAO.deleteOptions(gds_num);
	}

	// 여러옵션수정
	public void updateOptions(Map<String, Object> map) throws Exception{
		optionDAO.updateOptions(map);
		
	}

	// 단일옵션 수정
	public void updateOption(OptionVO optionvo) throws Exception{
		optionDAO.updateOption(optionvo);
	}

	public OptionVO getoption(int opt_num) throws Exception{
		return optionDAO.getoption(opt_num);
	}
	
	//


}
