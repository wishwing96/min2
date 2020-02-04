package com.min.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.min.model.UserVO;
import com.min.model.OrderVO;

@Repository
public class OrderMapperImpl implements OrderMapper {

	@Inject
	private SqlSession sqlSession;
	private static final String namespace="com.min.mapper.OrderMapper";
	
	@Override
	public void order(OrderVO vo, String orderno) throws Exception {

		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("orderno", orderno);
		paramMap.put("vo", vo);
		sqlSession.insert(namespace+".order", paramMap);
		
	}

	@Override
	public List<OrderVO> orderResult(UserVO user) throws Exception {
		List list = sqlSession.selectList(namespace+".orderResult", user);
		System.out.println("Join="+user);
		return list;
	}

	@Override
	public List<OrderVO> adminOrder(UserVO user) throws Exception {
		List list = sqlSession.selectList(namespace+".adminOrder", user);
		return list;
	}

}
