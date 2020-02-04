package com.min.mapper;

import com.min.model.JoinVO;
import com.min.model.LoginVO;

public interface JoinMapper {
	
	public void join(JoinVO join) throws Exception;
	
	public void information(JoinVO join) throws Exception;
	
	public LoginVO login(JoinVO join) throws Exception;
	
	public LoginVO id(JoinVO join) throws Exception;
	
	public LoginVO pw(JoinVO join) throws Exception;
	
	public LoginVO inform(JoinVO join) throws Exception;
	
	public JoinVO IdCheck(JoinVO join) throws Exception;
	
}
