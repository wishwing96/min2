package com.min.controller;

import java.text.DecimalFormat;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.min.model.AdminVO;
import com.min.model.OrderVO;
import com.min.model.ReplyVO;
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
	public String main(Model model, AdminVO vo) throws Exception{
		System.out.println("main controller=");
 		model.addAttribute("list", us.detail());
		return "main";
	}
	
	@RequestMapping(value="/main_detail", method=RequestMethod.GET)
	public String detailGet(@RequestParam int no, Model model, AdminVO vo) throws Exception{
		model.addAttribute("num", us.maindetail(no).size());
		model.addAttribute("file", us.maindetail(no));
		model.addAttribute("us", us.maindetail(no).get(0));
		return "main_detail";
	}
	
	@RequestMapping(value="/order", method=RequestMethod.GET)
	public void order(@RequestParam int no, Model model) throws Exception{
		System.out.println("order controller="+ us.maindetail(no));
		model.addAttribute("order", us.maindetail(no).get(0));

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
		 
		 int state = 0;
		 
		 os.order(vo, orderno, state);
		 model.addAttribute("result", vo);
		
		return "orderResult";
	}
	
	@RequestMapping(value="/orderResult", method=RequestMethod.GET)
	public void orderResult() throws Exception{
		
	}
	
	@RequestMapping(value="/ordercheck", method=RequestMethod.GET)
	public String ordercheck(Model model, JoinVO vo) throws Exception{
		
		model.addAttribute("check", os.orderResult(vo));
		System.out.println("os.orderResult="+os.orderResult(vo));
		
		return "ordercheck";
	}
	
	@RequestMapping(value="/adminOrder", method=RequestMethod.GET)
	public String adminOrder(Model model) throws Exception{
		System.out.println("adminOrder Controller="+ os.adminOrder());
		model.addAttribute("i", os.adminOrder().size());
		model.addAttribute("order", os.adminOrder());
		return "adminOrder";
	}
	
	@RequestMapping(value="/state/{orderno}", method= {RequestMethod.PUT, RequestMethod.GET})
	public ResponseEntity<String> stateGet(@PathVariable("orderno") String orderno, @RequestBody OrderVO vo) throws Exception{
		ResponseEntity<String> entity = null;
		try {
			vo.setOrderno(orderno);
			os.state(vo);
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return entity;
	}

}
































































