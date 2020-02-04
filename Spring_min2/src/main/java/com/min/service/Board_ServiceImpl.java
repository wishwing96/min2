package com.min.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.min.mapper.Board_Mapper;
import com.min.mapper.PointMapper;
import com.min.model.Board_VO;
import com.min.model.AdminVO;
import com.min.model.Recode;

@Service
public class Board_ServiceImpl implements Board_Service{

	@Autowired
	Board_Mapper bm;
	@Autowired
	private PointMapper pm;
	
	@Override
	public List<Board_VO> boardlist(Recode rec) throws Exception {
		return bm.boardlist(rec);
	}
	
	@Transactional
	@Override
	public void boardwrite(Board_VO board, String filename) throws Exception {
		bm.boardwrite(board, filename);
		pm.updatePoint(board.getUid(), 10);
		
	}
	
	@Override
	public int boardcount(Recode rec) throws Exception {
		return bm.boardcount(rec);
	}

	@Override
	public Board_VO boarddetail(int no) throws Exception {
		return bm.boarddetail(no);
	}

	@Override
	public void boardmodify(Board_VO board) throws Exception {
		bm.boardmodify(board);
		
	}

	@Override
	public void boarddelete(Board_VO board) throws Exception {
		bm.boarddelete(board);
		
	}

}
