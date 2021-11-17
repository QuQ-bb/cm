package com.myshop.cm.controller;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.myshop.cm.model.GoodsVO;
import com.myshop.cm.service.GoodsService;
import com.myshop.cm.util.FileSaver;

@Controller
public class SellerController {
	
	@Autowired
	private GoodsService goodsService;
	private FileSaver filesaver;
	
	// 상품 등록 폼으로 이동
	@RequestMapping(value = "/goodsuploadform")
	public String goodsuploadform() {
		
		return "seller/goodsuploadform";
	}
	
	// 상품 등록
	@RequestMapping(value = "/goodsupload", method = RequestMethod.POST)
	public String goodsupload(@RequestParam("gds_thumbnail1") MultipartFile mf, GoodsVO goods, HttpServletRequest request, Model model) throws Exception{
		
		String filename = mf.getOriginalFilename();
		int size = (int) mf.getSize();
		String path = request.getRealPath("resources/image/thumbnailimage");
		int result = 0;
		String file[] = new String[2];
//		file = filename.split(".");
//		System.out.println(file.length);
//		System.out.println("file0="+file[0]);
//		System.out.println("file1="+file[1]);
		
		// 썸네일 유효성 체크
		if(filename != "") {
			StringTokenizer st = new StringTokenizer(filename, ".");
			file[0] = st.nextToken();		
			file[1] = st.nextToken();		// 확장자	
			
			// 사이즈가 1mb 이상인경우
			if(size > 1000000){
				result=1;
				model.addAttribute("result", result);
				
				return "seller/goodsuploadresult";
				
			// 그림파일이 아닌경우
			}else if(!file[1].equals("jpg") &&
					 !file[1].equals("gif") &&
					 !file[1].equals("png") ){
				
				result=2;
				model.addAttribute("result", result);
				
				return "seller/goodsuploadresult";
			}
		}
		
		// 첨부파일이 전송된 경우
		if (size > 0) { 
			mf.transferTo(new File(path + "/" + filename));
		}
		
		goods.setGds_thumbnail(filename);
		
		goodsService.insert(goods);// 저장 메소드 호출
		
		return "redirect:/sellergoodslist";
	}

	// 판매자별 상품목록
	@RequestMapping(value = "/sellergoodslist")
	public ModelAndView list(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		Map<String, Object> sellergoodslist = goodsService.sellergoodslist(request,response);
		
		ModelAndView sellergoodslistM = new ModelAndView("seller/sellergoodslist");
		sellergoodslistM.addAllObjects(sellergoodslist);
		
		return sellergoodslistM;
	}
	
	// 판매자 상품 구매자페이지로 보기
	@RequestMapping(value = "/goodsdetail")
	public ModelAndView goodsdetail( @RequestParam("gds_num") int gds_num,
									  @RequestParam("page") String page,
									  HttpServletResponse response) throws Exception{
		GoodsVO goods = goodsService.goodsdetail(gds_num);
		

		String gds_detail = goods.getGds_detail().replace("/resources", "${pageContext.request.contextPath}/resources");
		
		ModelAndView goodsdetailM = new ModelAndView();
		goodsdetailM.addObject("goods", goods);
		goodsdetailM.addObject("gds_goods", gds_detail);
		goodsdetailM.addObject("page", page);
		goodsdetailM.setViewName("seller/goodsdetail");
		
		return goodsdetailM;
	}
	
	@RequestMapping(value = "/optioncom", method = RequestMethod.POST)
	@ResponseBody
	public String optioncom(@RequestBody List<String> optioncom, Model model)  throws Exception {
		model.addAttribute("optioncom", optioncom);
		
		return "seller/optioncom";
	}
	
	
}
