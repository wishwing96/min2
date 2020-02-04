package com.min.service;

import java.util.List;

import com.min.model.BoardVO;
import com.min.model.Criteria;
import com.min.model.RepBoardVO;

public interface RepBoardService {
	//댓글 조회
	public List<RepBoardVO> repboardList() throws Exception;
	//댓글 작성
	public void repboardWrite(RepBoardVO vo) throws Exception;
	
	public void repboardDetail(int bno) throws Exception;
	//댓글 수정
	public void repboardModify(RepBoardVO vo) throws Exception;
	//댓글 삭제
	public void repboardDelete(RepBoardVO vo) throws Exception;
	
	public List<RepBoardVO> repboardListPaging(Criteria cri) throws Exception;
	
	
}
