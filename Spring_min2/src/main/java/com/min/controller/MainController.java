package com.min.controller;

import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpSession;

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
import org.springframework.web.bind.annotation.ResponseBody;

import com.min.model.AdminVO;
import com.min.model.CartVO;
import com.min.model.LoginVO;
import com.min.model.OrderVO;
import com.min.model.UserVO;
import com.min.service.CartService;
import com.min.service.OrderService;
import com.min.service.UploadService;
import com.min.service.UserService;

@Controller
public class MainController {

	@Autowired
	private UploadService us;
	@Autowired
	private OrderService os;
	@Autowired
	private CartService cs;
	
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
	public String ordercheck(Model model, HttpSession session, String uid) throws Exception{
		UserVO user = (UserVO)session.getAttribute("vo");
		uid = user.getUid();
		
		model.addAttribute("check", os.orderResult(uid));
		
		return "ordercheck";
	}
	
	@RequestMapping(value="/adminOrder", method=RequestMethod.GET)
	public String adminOrder(Model model) throws Exception{
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
	
	@ResponseBody
	@RequestMapping(value="/cart", method=RequestMethod.POST)
	public void addCart(CartVO cart, HttpSession session, String uid) throws Exception{
		
		UserVO user = (UserVO)session.getAttribute("vo");
		uid = user.getUid();
		
		cs.addCart(cart, uid);
		
		
		System.out.println("addCart");
		//cs.addCart(cart);
	}
	
	@RequestMapping(value="/cartList", method=RequestMethod.GET)
	public void cartList(HttpSession session, Model model, UserVO vo) throws Exception{
		UserVO user = (UserVO)session.getAttribute("vo");
		String uid = user.getUid();
		System.out.println("user나오나요?="+vo);
		
		List<CartVO> cart = cs.cart(uid);
		System.out.println("cart list="+cart);
		model.addAttribute("cart", cart);
	}
	
	@ResponseBody
	@RequestMapping(value="/cartDel", method = RequestMethod.POST)
	public int deletePost(@RequestParam(value = "chbox[]") List<String> chArr, CartVO cart)throws Exception{
		System.out.println("delete 왓나요?");
		
		int result = 0;
		int no = 0;
		
		for(String i : chArr) {
			no = Integer.parseInt(i);
			cart.setCartnum(no);
			cs.cartDel(cart);
		}
		
		result = 1;
	
		return result;
	}
	
	@RequestMapping(value="/cartList", method = RequestMethod.POST)
	public String cartBuyPost(OrderVO vo, Model model)throws Exception{
		System.out.println("cartBuy 왓나요?");
		
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
		 System.out.println("구매정보가 어떤가요??"+vo);
		cs.cartBuy(vo, orderno, state);
		System.out.println("구매 테이블에 정보가 들어갔나요?");
		 model.addAttribute("result", vo);
		
		return "orderResult";
	}
	

}
































































