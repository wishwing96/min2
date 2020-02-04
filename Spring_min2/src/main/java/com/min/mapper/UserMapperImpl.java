package com.min.mapper;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.min.model.LoginVO;
import com.min.model.UserVO;

@Repository
public class UserMapperImpl implements UserMapper{
	
	@Autowired
	private SqlSession sqlSession;
	private static final String namespace = "com.min.mapper.UserMapper";
	
	@Override
	public UserVO login(LoginVO log) throws Exception{
		UserVO user = sqlSession.selectOne(namespace+".login", log);
		return user;
	}

}
