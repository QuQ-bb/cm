package com.myshop.cm.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myshop.cm.dao.MypageDAO;
import com.myshop.cm.model.OrderVO;
import com.myshop.cm.model.ReviewVO;

@Service
public class MypageService {

	@Autowired
	private MypageDAO mypageDao;



	
}
