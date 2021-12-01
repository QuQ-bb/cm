package com.myshop.cm.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myshop.cm.dao.CalculateDAO;
import com.myshop.cm.dao.SellerDAO;
import com.myshop.cm.model.CalculateVO;
import com.myshop.cm.model.MemberVO;
import com.myshop.cm.model.SellerVO;

@Service
public class CalculateService {
	
	@Autowired
	private CalculateDAO calculateDAO;
	@Autowired SellerDAO sellerDAO;

	// 판매자 정산 리스트
	public Map<String, Object> calculatelist(HttpServletRequest request, HttpServletResponse response) throws Exception{
		List<CalculateVO> calculatelist = new ArrayList<CalculateVO>();
		
		// 세션에 있는 member정보 받기
		HttpSession session = request.getSession();
		MemberVO member = (MemberVO)session.getAttribute("member");
		
		// 세션의 member.mem_num으로 판매자정보 불러오기
		SellerVO seller = sellerDAO.getSellerInfo(member.getMem_num());
		
		int page = 1;
		int limit = 10;	// 한 화면에 출력할 상품 수
		
		if(request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		
		int pageIndex = (page-1)*10;
		
		// 총 리스트 수를 받아옴
		int listcount = calculateDAO.getCalculListCount(seller.getSel_num());
		
		// 상품 리스트를 출력할 parameterType들을 map에 넣는다.
		Map<String, Object> listIndexMap = new HashMap<String,Object>();
		
		listIndexMap.put("pageIndex", pageIndex);
		listIndexMap.put("sel_num", seller.getSel_num());
		
		// 페이지 번호(page)를 DAO 클래스에 전달한다.
		calculatelist = calculateDAO.getCalculateList(listIndexMap);	// 리스트를 받아옴
		
		// 총 페이지 수
		int maxpage = (int)((double)listcount / limit + 0.95); // 0.95를 더해서 올림처리
		
		// 현재 페이지에 보여줄 시작 페이지 수(1, 11, 21 등...)
		int startpage = (((int) ((double) page / 10 + 0.9)) - 1) * 10 + 1;
		// 현재 페이지에 보여줄 마지막 페이지 수.(10, 20, 30 등...)
		int endpage = maxpage;

		if (endpage > startpage + 10 - 1)
			endpage = startpage + 10 - 1;
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		resultMap.put("page", page);
		resultMap.put("startpage", startpage);
		resultMap.put("endpage", endpage);
		resultMap.put("maxpage", maxpage);
		resultMap.put("listcount", listcount);
		resultMap.put("calculatelist", calculatelist);

		return resultMap;
	}

	// 판매자 정산 상세내역 보기
	public CalculateVO getCalculDetail(int clcln_num) throws Exception{
		CalculateVO calculateVO = calculateDAO.getCalculDetail(clcln_num);
		return calculateVO;
	}

}
