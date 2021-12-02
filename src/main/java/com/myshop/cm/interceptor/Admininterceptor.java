package com.myshop.cm.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.myshop.cm.model.MemberVO;

public class Admininterceptor extends HandlerInterceptorAdapter {
	public boolean preHandle(HttpServletRequest request 
			         , HttpServletResponse response , Object handler) throws Exception{
		System.out.println("인터셉터 탔냐?");
			HttpSession session = request.getSession();
			String mem_id = (String)session.getAttribute("mem_id");
			MemberVO member = (MemberVO)session.getAttribute("member");
			
			if(mem_id == null || mem_id.equals("")) {
				response.sendRedirect("/admin_login"); // 세션 X 시 관리자 로그인으로 이동
				return false;
			}else {
					if(member != null) {
						if(member.getMem_grade() != 99) {
							response.sendRedirect("/"); // 관리자등급이 아닌경우 접근불가
							return false;
						}
					}
			}
			return true;
	}
}
