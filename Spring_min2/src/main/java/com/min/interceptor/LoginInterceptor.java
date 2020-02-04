package com.min.interceptor;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.min.model.UserVO;

public class LoginInterceptor extends HandlerInterceptorAdapter{
	
	private static final String LOGIN = "login";
	private static final String ID = "id";
	
	@Override
	public void postHandle(HttpServletRequest request, 
				HttpServletResponse response,
				Object handler, ModelAndView mv) throws Exception {
		
		System.out.println("postHandle");
		HttpSession session = request.getSession();
		UserVO userVO = (UserVO) mv.getModel().get("userVO");
		
		System.out.println("UserVO="+userVO);
		if(userVO != null) {
			System.out.println("new login success");
			session.setAttribute(LOGIN, userVO);
			session.setAttribute(ID, userVO.getUid());
			session.setAttribute("vo", mv.getModel().get("userVO"));
			response.sendRedirect("/controller/main");//로그인 성공 후 메인페이지로 이동
		}
		
		
		/*if(userVO.getUid()!="admin" || userVO==null) {
			response.sendRedirect("/controller/adminpage");
		}*/
		
		
	}
	
	@Override
	public boolean preHandle(HttpServletRequest request,
							HttpServletResponse response,
							Object handler) throws Exception{
		
		System.out.println("preHandle");
		
		HttpSession session = request.getSession();
		System.out.println("session.getAttribute"+session.getAttribute(ID));
		if(session.getAttribute(LOGIN) != null) {
			System.out.println("clear login data before");
			session.removeAttribute(LOGIN);//로그아웃
		}
	
		return true;
	}
	

}
