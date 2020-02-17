package com.min.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.min.mapper.CartMapper;
import com.min.model.CartVO;
import com.min.model.OrderVO;


@Service
public class CartServiceImpl implements CartService{
	
	@Autowired
	CartMapper cm;

	@Override
	public void addCart(CartVO cart, String uid) throws Exception {
		cm.addCart(cart, uid);
		
	}

	@Override
	public List<CartVO> cart(String uid) throws Exception {
		System.out.println("cart service="+cm.cart(uid));
		return cm.cart(uid);
	}

	@Override
	public void cartDel(CartVO cart) throws Exception {
		cm.cartDel(cart);
		System.out.println("cart Service="+cart);
	}

	@Override
	public void cartBuy(OrderVO vo, String orderno, int state) throws Exception {
		cm.cartBuy(vo, orderno, state);
	}


}
