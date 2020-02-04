package com.min.mapper;

import com.min.model.LoginVO;
import com.min.model.UserVO;

public interface UserMapper {
	public UserVO login(LoginVO log) throws Exception;
}
