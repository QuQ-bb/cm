package com.myshop.cm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.myshop.cm.model.NoticeVO;
import com.myshop.cm.service.NoticeService;

@Controller
public class NoticeController {
	@Autowired
	NoticeService noticeservice;
	// 공지 리스트
	@RequestMapping(value = "/noticelist")
	private String noticelist(NoticeVO noticeVO , Model model) throws Exception{
		System.out.println("공지컨트롤러진입");
		
		List<NoticeVO> noticelist = noticeservice.noticelist(noticeVO);
								//key, 	   value
		model.addAttribute("noticelist", noticelist);
		System.out.println("공지컨트롤러진입2");
		
		return "admin/noticelist";
	}
	// 공지 등록폼
	@RequestMapping(value = "/noticeform")
	private String noticeform(NoticeVO noticeVO , Model model) throws Exception{
		System.out.println("공지등록폼컨트롤러");
		
		List<NoticeVO> noticelist = noticeservice.noticelist(noticeVO);
		model.addAttribute("noticelist", noticelist);
		
		System.out.println("공지등록폼컨트롤러2");
		return "admin/noticeform";	
	}
	// 공지 등록
	@RequestMapping(value = "/insertnotice")
	private String insertnotice(NoticeVO noticeVO , Model model) throws Exception{
		System.out.println("notice컨트롤러");
		
		int noticeInsert = noticeservice.NoticeInsert(noticeVO);
		model.addAttribute("noticeInsert", noticeInsert);
		
		System.out.println("notice컨트롤러2");
		return "admin/noticeform";
	}
}
