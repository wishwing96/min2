package com.min.service;

import java.util.List;

import com.min.model.AdminVO;
import com.min.model.BoardRepVO;
import com.min.model.Criteria;
import com.min.model.UploadVO;

public interface UploadService {

	public void upload(AdminVO vo) throws Exception;
	
	public List<AdminVO> detail() throws Exception;
	
	public List<AdminVO> maindetail(int no) throws Exception;
	
	public void uploadDel(AdminVO vo) throws Exception;
	
	public void registerReply(BoardRepVO reply) throws Exception;
	
	public List<BoardRepVO> replyList(int gdsnum) throws Exception;
	
}
