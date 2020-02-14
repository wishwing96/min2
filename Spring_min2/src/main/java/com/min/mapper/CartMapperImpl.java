package com.min.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.min.model.CartVO;

@Repository
public class CartMapperImpl implements CartMapper{
	
	@Inject
	private SqlSession sqlSession;
	private static final String namespace="com.min.mapper.CartMapper";

	@Override
	public void addCart(CartVO cart, String uid) throws Exception {
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("cart", cart);
		paramMap.put("uid", uid);
		sqlSession.insert(namespace+".addCart", paramMap);
		
	}

	@Override
	public List<CartVO> cart(String uid) throws Exception {
		List list = sqlSession.selectList(namespace+".cart", uid);
		System.out.println("cart mapper="+list);
		return list;
	}

	@Override
	public void cartDel(CartVO cart) throws Exception {
		System.out.println("cart mapper="+cart);
		sqlSession.delete(namespace+".cartDel", cart);
		
	}

}
