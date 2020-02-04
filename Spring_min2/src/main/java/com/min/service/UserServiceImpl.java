package com.min.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.min.mapper.UserMapper;
import com.min.model.LoginVO;
import com.min.model.UserVO;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserMapper um;
	
	@Override
	public UserVO login(LoginVO log) throws Exception {
		
		return um.login(log);
	}
	
	
	
}
