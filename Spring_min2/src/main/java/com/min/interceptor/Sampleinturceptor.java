package com.min.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.min.model.UserVO;


public class Sampleinturceptor extends HandlerInterceptorAdapter {

	private static final String LOGIN = "login";
	private static final String ID = "id";
	
	
	@Override
	public void postHandle(HttpServletRequest request, 
				HttpServletResponse response,
				Object handler, ModelAndView mv) throws Exception {
		System.out.println("post handle");
		//컨트롤러가 호출되기 전에 실행
	}
	
	@Override
	public boolean preHandle(HttpServletRequest request,
							HttpServletResponse response,
							Object handler) throws Exception{
		System.out.println("pre handle.......");
		
		//컨트롤러가 실행된 후에 실행
		return true;
	}
	
	//afterComplete:뷰에서 최종 결과가 생겅하는 일을 포함한 모든 일이 완료 되었을 때 실행.

}

	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	