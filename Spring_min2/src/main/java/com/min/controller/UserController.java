package com.min.controller;

import java.io.File;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.min.model.AdminVO;
import com.min.model.LoginVO;
import com.min.model.UserVO;
import com.min.service.UploadService;
import com.min.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService service;
	@Autowired
	private UploadService us;
	
	@Resource
	private String uploadPath;
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public void loginGET(@ModelAttribute("log")LoginVO log) {
		
	}
	@RequestMapping(value="/loginPost", method=RequestMethod.POST)
	public void loginPOST(LoginVO log, Model model) throws Exception{
		UserVO vo = service.login(log);
		if(vo == null) {return;}
		
		model.addAttribute("userVO", vo);
	}
}