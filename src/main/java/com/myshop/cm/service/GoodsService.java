package com.myshop.cm.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myshop.cm.dao.SellerDAO;
import com.myshop.cm.model.GoodsVO;

@Service
public class GoodsService {
	
	@Autowired
	private SellerDAO sellerDAO;
	
	// 상품 등록
	public void insert(GoodsVO goods) throws Exception{
		
		sellerDAO.insertGoods(goods);
	}

	// 판매자별 상품목록
	public Map<String, Object> sellergoodslist(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<GoodsVO> sellergoodslist = new ArrayList<GoodsVO>();
		
		int page = 1;
		int limit = 10;	// 한 화면에 출력할 상품 수
		
		if(request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		
		int pageIndex = (page-1)*10;
		
		// 총 리스트 수를 받아옴
		int listcount = sellerDAO.getListCount();
		
		// 페이지 번호(page)를 DAO 클래스에 전달한다.
		sellergoodslist = sellerDAO.getSellerGoodsList(pageIndex);	// 리스트를 받아옴
		
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
		resultMap.put("sellergoodslist", sellergoodslist);

		return resultMap;
	}

	// 판매자 상품 구매자페이지로 보기
	public GoodsVO goodsdetail(int gds_num) throws Exception{
		GoodsVO goods = sellerDAO.getGoodsContent(gds_num);
		
		return goods;
	}

	public void update(GoodsVO goods) throws Exception{
		sellerDAO.updateGoods(goods);
	}

	public void deletegoods(int gds_num) {
		sellerDAO.deleteGoods(gds_num);
	}

	public void goodshide(int gds_num) {
		sellerDAO.goodshide(gds_num);
	}

	public void goodsview(int gds_num) {
		sellerDAO.goodsview(gds_num);
		
	}

}
