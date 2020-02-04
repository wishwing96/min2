package com.min.service;

import com.min.model.LoginVO;
import com.min.model.UserVO;

public interface UserService {
	public UserVO login(LoginVO log) throws Exception;
}
