package com.myshop.cm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.myshop.cm.service.FaqService;

@Controller
public class FaqController {
	@Autowired  // 서비스 객체 주입
	FaqService faqservice;
	
}
