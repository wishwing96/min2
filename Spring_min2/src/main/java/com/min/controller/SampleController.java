package com.min.controller;

import org.slf4j.LoggerFactory;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.min.model.SampleModel;



@Controller
public class SampleController {

	private static final Logger logger = 
				LoggerFactory.getLogger(SampleController.class);
	
	@RequestMapping("doA")
	public String doA() {
		
		logger.info("doA called.................");
		
		return "index";
	}

	@RequestMapping("doB")
	public void doB() {
		
		logger.info("doB called...............................");
		
	}
	@RequestMapping("ex01")
	public String ex01(SampleModel sm) {
		logger.info(""+sm.getName());
		logger.info(""+sm.getAge());
		return "ex01";
	}
	
	@RequestMapping("ex02")
	public String ex02(SampleModel sm, Model model) {
		
		model.addAttribute("id", "aaa");
		model.addAttribute("email", "aaa@naver.com");
		
		return "ex02";
	}
	
	@RequestMapping("ex03")
	public String ex03(RedirectAttributes rttr) {
		
		rttr.addFlashAttribute("msg", "hello");
		rttr.addAttribute("msg","Hello");
		//return "ex04";// forward방식으로ex04.jsp로 이동
		return "redirect:ex04";//redirect방식으로ex04.jsp
	}
	@RequestMapping("ex04")
	public String ex04(SampleModel sm, HttpServletRequest request) {
		Map<String,?> aaa = RequestContextUtils.getInputFlashMap(request);
		String msg = (String)aaa.get("msg");
		String msg2 = (String)request.getAttribute("msg");
		logger.info("ex04 called................."+msg );
		logger.info("ex04 called................."+msg2 );
		return "ex04";
	}
	
	/*
	 * @RequestMapping("ex04") public String ex04(RedirectAttributes rttr) { String
	 * some = (String)rttr.getFlashAttributes().get("msg");
	 * 
	 * 
	 * logger.info("ex04 called................."+rttr.getFlashAttributes().get(
	 * "msg")); return "ex04"; }
	 */
	
	
	@RequestMapping("ex05")
	public @ResponseBody SampleModel ex05() {
		SampleModel sm = new SampleModel();
		
		sm.setName("green");
		sm.setAge(10);
		
		
		return sm;
	}
	
	
	
	
	
	
	
}
