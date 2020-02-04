package com.min.service;

import java.util.List;

import com.min.model.AdminVO;
import com.min.model.BoardVO;

public interface UploadService {

	public void upload(AdminVO vo) throws Exception;
	
	public List<AdminVO> detail() throws Exception;
	
	public AdminVO maindetail(int no) throws Exception;
	
	public void maindelete(AdminVO vo) throws Exception;
	
}
