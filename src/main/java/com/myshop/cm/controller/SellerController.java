package com.myshop.cm.controller;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.myshop.cm.model.DeliveryTemplateVO;
import com.myshop.cm.model.GoodsVO;
import com.myshop.cm.service.DeliveryCategoryService;
import com.myshop.cm.service.DeliveryTemplateService;
import com.myshop.cm.service.GoodsService;

@Controller
public class SellerController {

	@Autowired
	private GoodsService goodsService;
	@Autowired
	private DeliveryTemplateService deliveryTemplateService;
	@Autowired
	private DeliveryCategoryService deliveryCategoryService;

	// 상품 등록 폼으로 이동
	@RequestMapping(value = "/goodsuploadform")
	public ModelAndView goodsuploadform(HttpServletRequest request, HttpServletResponse response) 
			throws Exception{
		System.out.println("goodsuploadform");
		
		// 배송 카테고리 목록 불러오기
		Map<String, Object> getdeliverycatelist = deliveryCategoryService.getDeliveryCateList(request, response);
		
		// 배송 템플릿 목록 구해오기
		List<DeliveryTemplateVO> deltemlist = deliveryTemplateService.getTemplateList();
		
		// 경로 설정
		ModelAndView goodsuploadformM = new ModelAndView("seller/goodsuploadform");
		goodsuploadformM.addAllObjects(getdeliverycatelist);
		goodsuploadformM.addObject("deltemlist", deltemlist);
		
		return goodsuploadformM;
	}

	// 상품 등록
	@RequestMapping(value = "/goodsupload", method = RequestMethod.POST)
	public String goodsupload(
			@RequestParam(value = "gds_thumbnail1", required = false) MultipartFile mf,
			@RequestParam(value = "optioncom", required = false) String optioncom,
			@RequestParam(value = "optioncount", required = false) String optioncount,
			@RequestParam(value = "del_info", required = false) String del_info,
			DeliveryTemplateVO deliverytemplate, GoodsVO goods,
			HttpServletRequest request, Model model) throws Exception {
		System.out.println("goodsupload");
		System.out.println(optioncount);
		System.out.println(optioncom);
		// 옵션을 작성한 경우
		if (optioncom != null) {
			String[] optioncomarr = optioncom.split(",");
			String[] optioncountarr = optioncount.split(",");
			String[] option = new String[optioncomarr.length];
			for (int i = 0; i < option.length; i++) {
				option[i] = optioncomarr[i] + "-" + optioncountarr[i];
			}

			for (String s : option) {
				System.out.println(s);
			}
			String gds_option = Arrays.toString(option);

			goods.setGds_option(gds_option);
		}

		// 썸네일 저장
		if (mf != null) {
			UUID uuid = UUID.randomUUID();
			String filename = uuid + mf.getOriginalFilename();
			int size = (int) mf.getSize();
			String path = request.getRealPath("resources/image/thumbnailimage");
			int result = 0;
			String file[] = new String[2];

			// 썸네일 유효성 체크
			if (filename != "") {
				StringTokenizer st = new StringTokenizer(filename, ".");
				file[0] = st.nextToken();
				file[1] = st.nextToken(); // 확장자

				// 사이즈가 1mb 이상인경우
				if (size > 1000000) {
					result = 1;
					model.addAttribute("result", result);

					return "seller/goodsuploadresult";

				// 그림파일이 아닌경우
				} else if (!file[1].equals("jpg") && !file[1].equals("gif") && !file[1].equals("png")) {
					result = 2;
					model.addAttribute("result", result);

					return "seller/goodsuploadresult";
				}
			}
			// 첨부파일이 전송된 경우
			if (size > 0) {
				mf.transferTo(new File(path + "/" + filename));
			}
			goods.setGds_thumbnail(filename);
		}
		goodsService.insert(goods);// 저장 메소드 호출
		
		// 배송템플릿을 작성한 경우
		if(del_info != null) {
			
			String[] delinfoarr = del_info.split(",");
			for(int i=0; i<2; i++) {
				System.out.println(i+","+delinfoarr[i]);
			}
			deliverytemplate.setDel_code(Integer.parseInt(delinfoarr[0]));
			deliverytemplate.setDel_name(delinfoarr[1]);
			deliveryTemplateService.insert(deliverytemplate);  // 저장메소드 호출
		}
		
		return "redirect:/sellergoodslist";
	}

	// 판매자별 상품목록
	@RequestMapping(value = "/sellergoodslist")
	public ModelAndView list(HttpServletRequest request, HttpServletResponse response) throws Exception {

		Map<String, Object> sellergoodslist = goodsService.sellergoodslist(request, response);

		ModelAndView sellergoodslistM = new ModelAndView("seller/sellergoodslist");
		
		sellergoodslistM.addAllObjects(sellergoodslist);

		return sellergoodslistM;
	}

	// 판매자 상품 구매자페이지로 보기
	@RequestMapping(value = "/goodsdetail")
	public ModelAndView goodsdetail(@RequestParam("gds_num") int gds_num, @RequestParam("page") String page,
			HttpServletResponse response) throws Exception {
		GoodsVO goods = goodsService.goodsdetail(gds_num);

		String gds_detail = goods.getGds_detail().replace("/resources", "${pageContext.request.contextPath}/resources");

		ModelAndView goodsdetailM = new ModelAndView();
		goodsdetailM.addObject("goods", goods);
		goodsdetailM.addObject("gds_goods", gds_detail);
		goodsdetailM.addObject("page", page);
		goodsdetailM.setViewName("seller/goodsdetail");

		return goodsdetailM;
	}

	// 옵션 조합하기
	@RequestMapping(value = "/optioncom")
	public String optioncom(HttpServletRequest request, Model model) throws Exception {
		System.out.println("optioncom");
		String option1 = request.getParameter("option1");
		String option2 = request.getParameter("option2");
		// 옵션을 1개만 입력한 경우
		if (option2 == "") {
			String[] optioncom = option1.split(",");
			model.addAttribute("optioncom", optioncom);
		// 옵션을 2개 입력한 경우
		} else { 
			String[] op1arr = option1.split(",");
			String[] op2arr = option2.split(",");
			String[] optioncom = new String[op1arr.length * op2arr.length];
			int k = 0;
			// 옵션섞기
			for (int i = 0; i < op1arr.length; i++) {
				for (int j = 0; j < op2arr.length; j++) {
					optioncom[k] = op1arr[i] + "-" + op2arr[j];
					k++;
				}
			}
			model.addAttribute("optioncom", optioncom);
		}

		return "seller/optioncom";
	}

}
