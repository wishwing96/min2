package com.min.service;

import java.util.List;

import com.min.model.Criteria;
import com.min.model.ReplyVO;

public interface ReplyService {
	//댓글 조회
	public List<ReplyVO> replylist (int bno) throws Exception;
	//댓글 작성
	public void RepWrite(ReplyVO vo) throws Exception;
	//댓글 수정
	public void RepModify(ReplyVO vo) throws Exception;
	//댓글 삭제
	public void RepDelete(int rno) throws Exception;
	
	public int count(int bno) throws Exception;
	
	public List<ReplyVO> Replist(int bno, Criteria cri) throws Exception;

}
