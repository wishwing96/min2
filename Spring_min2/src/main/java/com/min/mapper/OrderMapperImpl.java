package com.min.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.min.model.UserVO;
import com.min.model.JoinVO;
import com.min.model.OrderVO;

@Repository
public class OrderMapperImpl implements OrderMapper {

	@Inject
	private SqlSession sqlSession;
	private static final String namespace="com.min.mapper.OrderMapper";
	
	@Override
	public void order(OrderVO vo, String orderno, int stock) throws Exception {

		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("orderno", orderno);
		paramMap.put("vo", vo);
		paramMap.put("stock", stock);
		sqlSession.insert(namespace+".order", paramMap);
		
	}
	
	@Override
	public void orederPoint(OrderVO vo) throws Exception {
		sqlSession.update(namespace+".orderPoint", vo);
		
	}

	@Override
	public List<OrderVO> orderResult(String uid) throws Exception {
		List list = sqlSession.selectList(namespace+".orderResult", uid);
		System.out.println("Join="+ uid);
		return list;
	}

	@Override
	public List<OrderVO> adminOrder() throws Exception {
		
		List list = sqlSession.selectList(namespace+".adminOrder");
		return list;
	}

	@Override
	public void state(OrderVO vo) throws Exception {
		sqlSession.update(namespace+".state", vo);
		System.out.println("state mapper="+vo);
		
	}

}
