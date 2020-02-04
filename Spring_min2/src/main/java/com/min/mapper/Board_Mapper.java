package com.min.mapper;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.min.model.Board_VO;
import com.min.model.AdminVO;
import com.min.model.MessageVO;
import com.min.model.Recode;

public interface Board_Mapper {
	
	public List<Board_VO> boardlist(Recode rec) throws Exception;
	
	public int boardcount (Recode rec) throws Exception;
	
	public void boardwrite(Board_VO board, String filename) throws Exception;
	
	public Board_VO boarddetail(int no) throws Exception;
	
	public void boardmodify(Board_VO board)throws Exception;
	
	public void boarddelete(Board_VO board) throws Exception;

	public void addAttatch(MultipartFile fileName) throws Exception;
}
