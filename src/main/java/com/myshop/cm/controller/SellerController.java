package com.myshop.cm.controller;

import java.io.File;
import java.util.StringTokenizer;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.swing.plaf.multi.MultiFileChooserUI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.myshop.cm.model.MemberVO;
import com.myshop.cm.model.SellerVO;
import com.myshop.cm.service.MemberService;
import com.myshop.cm.service.SellerService;

@Controller
public class SellerController {

	@Autowired
	private SellerService sellerService;
	
	//판매자 전환 신청 폼
	@RequestMapping(value="sellerChange")
	public String sellerChange() {
		return "seller/sellerChange";
		//seller폴더 sellerChange.jsp 실행
	}
	
	//판매자 전환 신청 저장
	@RequestMapping(value="/sellerchange_ok", method=RequestMethod.POST)
	public String sellerchange_ok(@RequestParam(value = "seling_filename1") MultipartFile mf, 
			HttpServletRequest request,HttpSession session, SellerVO seller,MemberVO member, Model model) throws Exception{
		

		if (mf != null) {
	         //첨부파일 저장
	         UUID uuid = UUID.randomUUID();
	         String filename = uuid + mf.getOriginalFilename();
	         int size = (int) mf.getSize();
	         String path = request.getRealPath("resources/images/sellerimage");
	         int result = 0;
	         String file[] = new String[2];

//	         // 첨부파일 저장 체크
//	         if (filename != "") {
//	            StringTokenizer st = new StringTokenizer(filename, ".");
//	            file[0] = st.nextToken();
//	            file[1] = st.nextToken(); // 확장자
//
//	            // 사이즈가 10mb 이상인경우
//	            if (size > 10000000) {
//	               result = 1;
//	               model.addAttribute("result", result);
//
//	               return "";
//
//	            //  
//	            } else if (!file[1].equals("jpg") && !file[1].equals("gif") && !file[1].equals("png") && !file[1].equals("pdf")) {
//
//	               result = 2;
//	               model.addAttribute("result", result);
//
//	               return "";
//	            }
//	         }
//
	         // 첨부파일이 전송된 경우
	         if (size > 0) {
	            mf.transferTo(new File(path + "/" + filename));
	         }

	         seller.setSeling_filename(filename);
	         System.out.println(path);
	      }
		
		// 현제 세션에 있는(로그인 한 member의 정보) mem_num값 가져오기
		MemberVO loginmember = (MemberVO)session.getAttribute("member");
		int mem_num = loginmember.getMem_num();
		seller.setMem_num(mem_num);
		
		sellerService.registerSeller(seller);
		
		System.out.println("컨트롤러");
		
		//mem_num불러오기
		MemberVO vo = sellerService.getMember(member);
		session.setAttribute("vo", vo);
		return "redirect:sellerChange_end"; 
	}
	
	//판매자 전환 신청 완료 폼
	@RequestMapping(value="sellerChange_end")
	public String sellerChange_end() {
		return "seller/sellerChange_end";
	}
}
