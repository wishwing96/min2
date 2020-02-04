package com.min.mapper;

import java.util.List;

import com.min.model.Criteria;
import com.min.model.ReplyVO;

public interface ReplyMapper {
	
	public List<ReplyVO> list(int bno) throws Exception;
	
	public List<ReplyVO> listPage(int bno, Criteria cri) throws Exception;
	
	public int RepCount(int bno) throws Exception;
	
	public void RepWrite(ReplyVO vo) throws Exception;
	
	public void RepModify(ReplyVO vo) throws Exception;
	
	public void RepDelete(int rno) throws Exception;
}

