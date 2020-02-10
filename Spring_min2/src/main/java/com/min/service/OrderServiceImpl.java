package com.min.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.min.mapper.OrderMapper;
import com.min.model.UserVO;
import com.min.model.JoinVO;
import com.min.model.OrderVO;

@Service
public class OrderServiceImpl implements OrderService{

	@Autowired
	OrderMapper om;
	@Override
	public void order(OrderVO vo, String orderno, int state) throws Exception {

		om.order(vo, orderno, state);
	}
	@Override
	public List<OrderVO> orderResult(JoinVO vo) throws Exception {
		System.out.println("list="+om.orderResult(vo));
		return om.orderResult(vo);
		
	}
	@Override
	public List<OrderVO> adminOrder() throws Exception {
		return om.adminOrder();
	}
	@Override
	public void state(OrderVO vo) throws Exception {
		om.state(vo);
		System.out.println("state service="+vo);
		
	}

}
