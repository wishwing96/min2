package com.min.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.min.mapper.CartMapper;
import com.min.mapper.OrderMapper;
import com.min.model.CartVO;
import com.min.model.OrderVO;


@Service
public class CartServiceImpl implements CartService{
	
	@Autowired
	CartMapper cm;
	@Autowired
	OrderMapper om;

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
	public int cartnull(String uid) throws Exception {
		System.out.println("cart service="+cm.cart(uid));
		return cm.cartnull(uid);
	}

	@Override
	public void cartDel(CartVO cart) throws Exception {
		cm.cartDel(cart);
		System.out.println("cart Service="+cart);
	}

	@Transactional
	@Override
	public void cartBuy(OrderVO vo, String orderno) throws Exception {
		cm.cartBuy(vo, orderno);
		om.orederPoint(vo);
	}

	@Override
	public void orderDel(int num) throws Exception {
		cm.orderDel(num);
		
	}


}
