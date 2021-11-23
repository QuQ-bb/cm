package com.myshop.cm.controller;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MypageController {
	private static final Logger logger = LoggerFactory.getLogger(MypageController.class);
	
	@RequestMapping(value = "mypage", method = RequestMethod.GET)
	public String mypage(Locale locale, Model model) {
		logger.info("mypage", locale);
		/* 
		db에서 mypage에 관련된 데이터 가져오기.	
		 */
		return "mypage";
	}
	
}
