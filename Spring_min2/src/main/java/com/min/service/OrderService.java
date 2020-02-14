package com.min.service;

import java.util.List;

import com.min.model.UserVO;
import com.min.model.JoinVO;
import com.min.model.OrderVO;

public interface OrderService {
	
	public void order(OrderVO vo, String orderno, int state) throws Exception;
	
	public List<OrderVO> orderResult(String uid) throws Exception;
	
	public List<OrderVO> adminOrder() throws Exception;
	
	public void state(OrderVO vo) throws Exception;

}
