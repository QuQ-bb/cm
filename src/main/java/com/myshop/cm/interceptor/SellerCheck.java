package com.myshop.cm.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.myshop.cm.model.MemberVO;

public class SellerCheck extends HandlerInterceptorAdapter{
	// preHandle(request,response,handler)메소드
		// 1.Controller에서 요청(/)을 받기 전에  preHandle()가 호출되어 가로채는 역할로 사용
		// 2. 판매자가 아니면 접근이 불가능하게 설정
		public boolean preHandle(HttpServletRequest request, 
				HttpServletResponse response, Object handler) throws Exception {
			HttpSession session = request.getSession();
			String mem_id = (String)session.getAttribute("mem_id");
			MemberVO member = (MemberVO)session.getAttribute("member");
			
			if (mem_id == null || mem_id.equals(""))  {		
				response.sendRedirect("member_login");	// 세션이 없으면 로그인 폼으로 이동
				return false;
			}else {
				if(member != null) {
					if (member.getMem_grade() != 50)  {		
						response.sendRedirect("/");	// 판매자가 아니면 접근불허
						return false;
					}
				}
			}
			
			return true;
		}
}
