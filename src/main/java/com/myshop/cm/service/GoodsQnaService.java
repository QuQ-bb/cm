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

import com.myshop.cm.dao.GoodsQnaDAO;
import com.myshop.cm.model.GoodsQnaVO;
import com.myshop.cm.model.MemberVO;

@Service
public class GoodsQnaService {
	@Autowired
	private GoodsQnaDAO goodsQnaDAO;

	
	// 내가쓴 상품 문의 리스트 불러오기
	public Map<String, Object> getMyGoodsQnaList(HttpServletRequest request, HttpServletResponse response,HttpSession session) throws Exception {
		List<GoodsQnaVO> mygoodsQnaList = new ArrayList<GoodsQnaVO>();
		
		//세션에 있는 member정보 받기
		MemberVO member =(MemberVO)session.getAttribute("member");
		
		// 회원번호를 mem_num에 저장
		int mem_num = member.getMem_num();
		System.out.println(mem_num);
		System.out.println("되나요?");
		
		int page =1;	//페이지 기본값
		int limit = 10;	//한 화면에 출력할 상품 수
		
		//만약 페이지 요청값이 없다면 페이지 기본값(1page)가 출력되게
		if(request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		
		//mySQL의 limit에 넣어줄 값
		int pageIndex =(page-1)*10;
		
		//총 개수를 받아옴
		int listcount = goodsQnaDAO.getMyGoodsQnaListCount(mem_num);
		
		//상품 리스트를 출력할parameterType들을 map에 넣는다.
		Map<String, Object> listIndexMap = new HashMap<String, Object>();
		
		listIndexMap.put("pageIndex", pageIndex);
		listIndexMap.put("mem_num", mem_num);
		
		//페이지 인덱스(pageIndex)를 DAO 클래스에 전달한다.
		mygoodsQnaList = goodsQnaDAO.getMyGoodsQnaList(listIndexMap);	//리스트를 받아옴
		
		//총 페이지 수
		int maxpage =(int)((double)listcount / limit +0.95);//0.95를 더해서 올림처리
		
		//현재 페이지에 보여줄 시작 페이지 수(1,11,21...)
		int startpage =(((int) ((double) page /10+0.9)) -1)* 10+1;
		//현재 페이지에 보여줄 마지막 페이지 수(10.20.30...)
		int endpage = maxpage;
		
		//만약 endPage가 10 20 30을 넘어간다면,고정함
		if(endpage > startpage + 10 -1)
				endpage = startpage + 10 -1;
		
		//map객체를 선언하여 위에 새로 선언한 변수들을 담아준다.
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		resultMap.put("page", page);
		resultMap.put("startpage", startpage);
		resultMap.put("endpage", endpage);
		resultMap.put("maxpage", maxpage);
		resultMap.put("listcount", listcount);
		resultMap.put("mygoodsQnaList", mygoodsQnaList);
		
		return resultMap;
	}
	//내 상품문의 답변여부 확인
	public int getmyGoodsQnaAnswer(int gdsqna_num)throws Exception {
		return goodsQnaDAO.getmyGoodsQnaAnswer(gdsqna_num);
	}
	//내 상품문의확인
	public GoodsQnaVO getmyGoodsQuestionDetail(int gdsqna_num)throws Exception {
		return goodsQnaDAO.getmyGoodsQuestionDetail(gdsqna_num);
	}
	//내 상품문의 답변이 있다면 답변확인
	public GoodsQnaVO getmyGoodsAnswerDetail(int gdsqna_num)throws Exception {
		return goodsQnaDAO.getmyGoodsAnswerDetail(gdsqna_num);
	}
	//gdsqna_num으로 문의글 가져오기
	public GoodsQnaVO getMyGoodsQna(int gdsqna_num)throws Exception {
		return goodsQnaDAO.getMyGoodsQna(gdsqna_num);
	}
	//문의글 수정
	public void updateMyGoodsQna(GoodsQnaVO goodsqna)throws Exception {
		goodsQnaDAO.updateMyGoodsQna(goodsqna);
	}
	//내 상품문의 삭제
	public void myGoodsQnaDelete(int gdsqna_num)throws Exception {
		System.out.println("상품문의 삭제 괜찮으시겠어요?서비스");
		goodsQnaDAO.myGoodsQnaDelete(gdsqna_num);
	}

}
