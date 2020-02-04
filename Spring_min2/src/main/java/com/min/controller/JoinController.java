package com.min.controller;

import java.util.Random;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.min.model.JoinVO;
import com.min.model.LoginVO;
import com.min.model.MailVO;
import com.min.model.UserVO;
import com.min.service.JoinService;
import com.min.service.UserService;

@Controller
public class JoinController {

	
	@Autowired
	private JoinService js;
	@Autowired
    private JavaMailSender mailSender;
			
	@RequestMapping(value="/join", method=RequestMethod.GET)
	public String joinGET() throws Exception {
		System.out.println("join get=========");
		
		return "join";
	}
	
	@RequestMapping(value="/join", method=RequestMethod.POST)
	public String joinPOST(JoinVO join) throws Exception{
		System.out.println("login post=========");
		js.join(join);
		
		return "main";
	}
	
	@RequestMapping(value="/email", method=RequestMethod.GET)
	@ResponseBody
	public String mailSending(MailVO mail, HttpSession session, @RequestParam String uemail) {
		
		System.out.println("email post=========");
		 int ran = new Random().nextInt(100000) + 10000; // 10000 ~ 99999
	        String joinCode = String.valueOf(ran);
	        session.setAttribute("joinCode", joinCode);
	        String title= "회원가입 인증 코드 발급 안내 입니다.";
	        mail.setTitle(title);
	        
	        String subject = "귀하의 인증번호는"+joinCode+"입니다.";
	        mail.setContent(subject);
	        
	        String from = "wishwing96@naver.com";
	        mail.setFrom(from);
	        
	        mail.setTomail(uemail);
	        System.out.println("try before");
		try {
			MimeMessage message = mailSender.createMimeMessage();
			MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "utf-8");
			
			messageHelper.setFrom(mail.getFrom());// 보내는 사람(생략하면 정상적으로 작동을 안 한다.)
			messageHelper.setTo(mail.getTomail());// 받는 사람
			messageHelper.setSubject(mail.getTitle());// 메일 제목(생략 가능)
			messageHelper.setText(mail.getContent());// 메일 내용
			System.out.println("try after");
			mailSender.send(message);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
			
		String num = Integer.toString(ran);
		
		return num;
		
	}
	
	@RequestMapping(value="/information", method=RequestMethod.GET)
	public String informationGET() throws Exception {
		System.out.println("information get=========");
		
		
		return "information";
	}
	
	@RequestMapping(value="/information", method=RequestMethod.POST)
	public String informationPOST(JoinVO join, UserVO vo) throws Exception{
		System.out.println("information post=========");
		System.out.println("vo"+vo);
		js.information(join);
		
		return "information";
	}
	@ResponseBody
	@RequestMapping(value="/IdCheck", method=RequestMethod.GET)
	public int idcheckGET(JoinVO join) throws Exception {
		System.out.println("idcheck get=========");
		  int result=0;
	      JoinVO user=js.IdCheck(join);
	      if(user!=null) result=1;
	      else System.out.println("아이디사용가능");
	      
	      
	      System.out.println("result="+result);
	      
	      return result;
	}
	
	@Autowired
	private UserService service;
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public void loginGET(@ModelAttribute("log")LoginVO log) {
		
	}
	@RequestMapping(value="/loginPost", method=RequestMethod.POST)
	public void loginPOST(LoginVO log, Model model) throws Exception{
		UserVO vo = service.login(log);
		
		System.out.println("controller vo"+vo);
		model.addAttribute("userVO", vo);
		
		if(vo == null) {return ;}
	}
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public void logoutGET(@ModelAttribute("join")JoinVO join) throws Exception {
		System.out.println("login get=========");
		
	}
	
	@RequestMapping(value="/idsearch", method=RequestMethod.GET)
	public String idGET() throws Exception{
		System.out.println("idsearch============");

		return "/idsearch";
	}
	
	@RequestMapping(value="/idsearch", method=RequestMethod.POST)
	public String idPOST(JoinVO join, Model model) throws Exception{
		System.out.println("idsearchPost==============");
		
		LoginVO id = js.id(join);
		System.out.println("id="+js.id(join));
		model.addAttribute("id", id);
		System.out.println("id="+id.getUid());
		
		return "/idsearch";
	}
	
	@RequestMapping(value="/pwsearch", method=RequestMethod.GET)
	public String pwGET() throws Exception{
		System.out.println("pwsearch============");

		return "/pwsearch";
	}
	
	@RequestMapping(value="/pwsearch", method=RequestMethod.POST)
	public String pwPOST(JoinVO join, Model model) throws Exception{
		System.out.println("pwsearchPost==============");
		
		LoginVO pw = js.pw(join);
		System.out.println("pw="+js.pw(join));
		model.addAttribute("pw", pw);
		
		return "/pwsearch";
	}
	
}






























