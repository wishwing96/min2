package com.min.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.min.mapper.ReplyMapper;
import com.min.model.Criteria;
import com.min.model.ReplyVO;

@Service
public class ReplyServiceIpml implements ReplyService{

	@Autowired
	private ReplyMapper rm;
	
	@Override
	public List<ReplyVO> replylist(int bno) throws Exception {
		return rm.list(bno);
	}

	@Override
	public void RepWrite(ReplyVO vo) throws Exception {
		rm.RepWrite(vo);
		
	}

	@Override
	public void RepModify(ReplyVO vo) throws Exception {
		rm.RepModify(vo);
		
	}

	@Override
	public void RepDelete(int rno) throws Exception {
		rm.RepDelete(rno);
		
	}
	
	@Override
	public int count(int bno) throws Exception {
		return rm.RepCount(bno);
	}

	@Override
	public List<ReplyVO> Replist(int bno, Criteria cri) throws Exception {
		return rm.listPage(bno, cri);
	}

}
