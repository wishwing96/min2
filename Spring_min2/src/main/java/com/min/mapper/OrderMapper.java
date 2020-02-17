package com.min.mapper;

import java.util.List;

import com.min.model.JoinVO;
import com.min.model.OrderVO;

public interface OrderMapper {
	
	public void order(OrderVO vo, String orderno, int state, int stock) throws Exception;
	
	public List<OrderVO> orderResult(String uid) throws Exception;
	
	public List<OrderVO> adminOrder() throws Exception;
	
	public void state(OrderVO vo) throws Exception;

}
