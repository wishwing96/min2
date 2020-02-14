package com.min.service;

import java.util.List;

import com.min.model.CartVO;

public interface CartService {
	
	public void addCart(CartVO cart, String uid) throws Exception;
	
	public List<CartVO> cart(String uid) throws Exception;
	
	public void cartDel(CartVO cart) throws Exception; 
	
}
