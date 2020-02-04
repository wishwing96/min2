package com.min.mapper;

import java.util.List;

import com.min.model.AdminVO;
import com.min.model.Board_VO;
import com.min.model.UploadVO;

public interface UploadMapper {
	
	//public void upload(AdminVO vo, String filename, String mainfilename) throws Exception;
	
	public void upload(AdminVO vo) throws Exception;
	
	public List<AdminVO> detail() throws Exception;
	
	public AdminVO maindetail(int no) throws Exception;
	
	public void addAttach(String filename) throws Exception;
	
	public void maindelete(AdminVO vo) throws Exception;

}
