package com.min.service;

import java.util.List;

import com.min.model.Board_VO;
import com.min.model.Recode;

public interface Board_Service {
	
	public List<Board_VO> boardlist(Recode rec) throws Exception;
	
	public void boardwrite(Board_VO board, String filename) throws Exception;
	
	public int boardcount(Recode rec) throws Exception;
	
	public Board_VO boarddetail(int no) throws Exception;
	
	public void boardmodify(Board_VO board) throws Exception;
	
	public void boarddelete(Board_VO board) throws Exception;

}
