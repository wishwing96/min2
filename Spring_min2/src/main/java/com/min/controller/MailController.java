package com.min.controller;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.min.model.MailVO;

@Controller
public class MailController {
	
	@Autowired
	private JavaMailSender mailSender;
	
	@RequestMapping(value="mail", method = RequestMethod.GET)
	public String mailpage() {
		System.out.println("gmail 실행");
		
		return "mail";
	}
	
	@RequestMapping(value="mail", method=RequestMethod.POST)
	public void mailSending(MailVO mail) {
		try {
			MimeMessage message = mailSender.createMimeMessage();
			MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "utf-8");
			
			messageHelper.setFrom(mail.getFrom());// 보내는 사람(생략하면 정상적으로 작동을 안 한다.)
			messageHelper.setTo(mail.getTomail());// 받는 사람
			messageHelper.setSubject(mail.getTitle());// 메일 제목(생략 가능)
			messageHelper.setText(mail.getContent());// 메일 내용
			
			mailSender.send(message);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
