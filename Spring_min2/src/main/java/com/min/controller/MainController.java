package com.min.controller;

import java.text.DecimalFormat;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.min.model.AdminVO;
import com.min.model.UserVO;
import com.min.model.OrderVO;
import com.min.model.JoinVO;
import com.min.service.OrderService;
import com.min.service.UploadService;

@Controller
public class MainController {

	@Autowired
	private UploadService us;
	@Autowired
	private OrderService os;
	
	@RequestMapping(value="/main", method=RequestMethod.GET)
	public String main(Model model) throws Exception{
		
		model.addAttribute("list", us.detail());
		return "main";
	}
	
	@RequestMapping(value="/main_detail", method=RequestMethod.GET)
	public String detailGet(@RequestParam int no, Model model, AdminVO vo) throws Exception{

		model.addAttribute("us", us.maindetail(no));
		
		
		return "main_detail";
	}
	
	@RequestMapping(value="/order", method=RequestMethod.GET)
	public String order(@RequestParam int no, Model model, JoinVO join) throws Exception{
		model.addAttribute("order", us.maindetail(no));
		
		return "order";
	}
	
	@RequestMapping(value="/order", method=RequestMethod.POST)
	public String orderpost(OrderVO vo, Model model) throws Exception{
		 
		 Calendar cal = Calendar.getInstance();
		 int year = cal.get(Calendar.YEAR);
		 String ym = year + new DecimalFormat("00").format(cal.get(Calendar.MONTH) + 1);
		 String ymd = ym +  new DecimalFormat("00").format(cal.get(Calendar.DATE));
		 String subNum = "";
		 
		 for(int i = 1; i <= 6; i ++) {
		  subNum += (int)(Math.random() * 10);
		 }
		 
		 String orderno = ymd + "_" + subNum;
		 
		 os.order(vo, orderno);
		 model.addAttribute("result", vo);
		
		return "orderResult";
	}
	
	@RequestMapping(value="/orderResult", method=RequestMethod.GET)
	public void orderResult() throws Exception{
		
	}
	
	@RequestMapping(value="/ordercheck", method=RequestMethod.GET)
	public String ordercheck(Model model, UserVO user) throws Exception{
		
		model.addAttribute("check", os.orderResult(user));
		System.out.println("os.orderResult="+os.orderResult(user));
		
		return "ordercheck";
	}
	
	@RequestMapping(value="/adminOrder", method=RequestMethod.GET)
	public String adminOrder(Model model, @RequestParam UserVO user) throws Exception{
		
		model.addAttribute("order", os.adminOrder(user));
		return "adminOrder";
	}

}
































































