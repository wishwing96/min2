package com.min.mapper;

import java.util.List;

import com.min.model.CartVO;
import com.min.model.OrderVO;



public interface CartMapper {
	
	public void addCart(CartVO cart, String uid) throws Exception;
	
	public List<CartVO> cart(String uid) throws Exception;
	
	public int cartnull(String uid) throws Exception; 
	
	public void cartDel(CartVO cart) throws Exception;
	
	public void cartBuy(OrderVO vo, String orderno) throws Exception; 
	
	public void orderDel(int num) throws Exception;

}
