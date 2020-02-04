package com.min.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.min.mapper.OrderMapper;
import com.min.model.UserVO;
import com.min.model.OrderVO;

@Service
public class OrderServiceImpl implements OrderService{

	@Autowired
	OrderMapper om;
	@Override
	public void order(OrderVO vo, String orderno) throws Exception {

		om.order(vo, orderno);
	}
	@Override
	public List<OrderVO> orderResult(UserVO user) throws Exception {
		System.out.println("list="+om.orderResult(user));
		return om.orderResult(user);
		
	}
	@Override
	public List<OrderVO> adminOrder(UserVO user) throws Exception {
		return om.adminOrder(user);
	}

}
