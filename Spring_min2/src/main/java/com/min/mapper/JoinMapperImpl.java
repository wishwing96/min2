package com.min.mapper;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.min.model.JoinVO;
import com.min.model.LoginVO;
import com.min.model.UserVO;

@Repository
public class JoinMapperImpl implements JoinMapper{

	@Inject
	private SqlSession sqlSession;
	
	private static final String namespace="com.min.mapper.JoinMapper";
	
	@Override
	public void join(JoinVO join) throws Exception {
		sqlSession.insert(namespace+".join", join);
	}
	
	@Override
	public void information(JoinVO join) throws Exception {
		sqlSession.update(namespace+".information", join);
	}

	@Override
	public LoginVO login(JoinVO join) throws Exception {
		LoginVO user = sqlSession.selectOne(namespace+".login", join);
		return user;
	}

	@Override
	public LoginVO id(JoinVO join) throws Exception {
		LoginVO id = sqlSession.selectOne(namespace+".id", join);
		
		return  id;
	}
	
	@Override
	public LoginVO pw(JoinVO join) throws Exception {
		LoginVO pw = sqlSession.selectOne(namespace+".pw", join);
		
		return  pw;
	}
	
	@Override
	public UserVO inform(String uid) throws Exception {
		UserVO inform = sqlSession.selectOne(namespace+".inform", uid);
		System.out.println(inform);
		return  inform;
	}
	@Override
	public JoinVO IdCheck(JoinVO join) throws Exception {
		JoinVO IdCheck = sqlSession.selectOne(namespace+".IdCheck", join);
		
		return  IdCheck;
	}

}
