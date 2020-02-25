package com.min.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.min.mapper.JoinMapper;
import com.min.model.JoinVO;
import com.min.model.LoginVO;
import com.min.model.UserVO;

@Service
public class JoinServiceImpl implements JoinService{
	
	@Autowired
	JoinMapper jm;

	@Override
	public void join(JoinVO join) throws Exception {
		
		jm.join(join);
	}

	@Override
	public LoginVO login(JoinVO join) throws Exception {
		
		return jm.login(join);
	}

	@Override
	public LoginVO id(JoinVO join) throws Exception {
		return jm.id(join);
	}
	
	@Override
	public LoginVO pw(JoinVO join) throws Exception {
		return jm.pw(join);
	}

	@Override
	public void information(JoinVO join) throws Exception {
		jm.information(join);
		
	}
	
	@Override
	public UserVO inform(String uid) throws Exception {
		System.out.println("servie=="+jm.inform(uid));
		return jm.inform(uid);
		
	}
	
	@Override
	public JoinVO IdCheck(JoinVO join) throws Exception {
		return jm.IdCheck(join);
		
	}

}
