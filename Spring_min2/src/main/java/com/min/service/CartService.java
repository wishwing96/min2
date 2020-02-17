package com.min.service;

import java.util.List;

import com.min.model.CartVO;
import com.min.model.LoginVO;
import com.min.model.OrderVO;
import com.min.model.UserVO;

public interface CartService {
	
	public void addCart(CartVO cart, String uid) throws Exception;
	
	public List<CartVO> cart(String uid) throws Exception;
	
	public void cartDel(CartVO cart) throws Exception; 
	
	public void cartBuy(OrderVO vo, String orderno, int state) throws Exception;
	
}
