package com.min.service;

import java.util.List;

import com.min.model.AdminVO;
import com.min.model.BoardRepVO;
import com.min.model.UploadVO;

public interface UploadService {

	public void upload(AdminVO vo, String file) throws Exception;
	
	public List<AdminVO> detail() throws Exception;
	
	public List<AdminVO> maindetail(int no) throws Exception;
	
	public void uploadDel(AdminVO vo) throws Exception;
	
	public void registerReply(BoardRepVO reply) throws Exception;
	
	public List<BoardRepVO> replyList(int gdsnum) throws Exception;
	
	public String idCheck(int repnum) throws Exception;
	
	public void replyDel(BoardRepVO reply) throws Exception;
	
	public void replyMod(BoardRepVO reply) throws Exception;
	
}
