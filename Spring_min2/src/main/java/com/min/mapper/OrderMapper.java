package com.min.mapper;

import java.util.List;

import com.min.model.UserVO;
import com.min.model.OrderVO;

public interface OrderMapper {
	
	public void order(OrderVO vo, String orderno) throws Exception;
	
	public List<OrderVO> orderResult(UserVO user) throws Exception;
	
	public List<OrderVO> adminOrder(UserVO user) throws Exception;

}
