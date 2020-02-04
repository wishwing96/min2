package com.min.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.min.model.BoardVO;
import com.min.model.Criteria;

public interface BoardService {

	// 게시판 리스트
	public List<BoardVO> boardList() throws Exception;
	
	// 게시판 리스트
	public List<BoardVO> boardListPaging(Criteria cri) throws Exception;
	
	
	public int boardCount(Criteria cri) throws Exception;
	
	// 게시판 제목을 클릭하였을 경우
	public BoardVO boardDetail(int no) throws Exception;
	
	//게시판 글수정
	public void boardModify(BoardVO board) throws Exception;
	
	//게시판 글삭제
	/* public void boardDel(BoardVO board) throws Exception; */
	public void boardDel(int no) throws Exception;
	
	//게시판 글쓰기
	public void boardWrite(BoardVO board, String fileName) throws Exception;
	
}
