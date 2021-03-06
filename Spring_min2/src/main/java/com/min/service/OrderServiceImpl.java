package com.min.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.min.mapper.OrderMapper;
import com.min.model.UserVO;
import com.min.model.JoinVO;
import com.min.model.OrderVO;

@Service
public class OrderServiceImpl implements OrderService{

	@Autowired
	OrderMapper om;
	
	@Transactional
	@Override
	public void order(OrderVO vo, String orderno, int stock) throws Exception {

		om.order(vo, orderno, stock);
		om.orederPoint(vo);
	}
	@Override
	public List<OrderVO> orderResult(String uid) throws Exception {
		System.out.println("list="+om.orderResult(uid));
		return om.orderResult(uid);
		
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
