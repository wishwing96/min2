package com.min.mapper;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.min.model.BoardVO;
import com.min.model.Criteria;

public interface BoardMapper  {
	//전체 목록 리스트
	public List<BoardVO> boardList();
	
	//전체 목록 리스트(페이징 처리)
	//public List<BoardVO> boardListPaging(페이지 수, 한 페이지당 데이터 처리 갯수) throws Exception;
	public List<BoardVO> boardListPaging(Criteria cri) throws Exception;
	
	//Board테이블의 레코드 전체 갯수 : 페이징의 realEnd를 알기 위해서
	public int boardCount(Criteria cri) throws Exception; 
	
	
	// 제목을 클릭했을 때 상세 페이지
	public BoardVO boardDetail(int no) throws Exception;
	
	// 게시판 작성
	//public void boardWrite(String subject, String writer, String content, int cnt); //도가능
	 public void boardWrite(BoardVO board, String fileName) throws Exception; 
	
	//게시판 글수정 
	public void boardModify(BoardVO board) throws Exception;
	//public void boardModify(String subject, String content, int no);
	
	//게시판 글삭제
	/* public void boardDel(BoardVO board) throws Exception; */
	public void boardDel(int no) throws Exception;
	
	// 게시판 글 작성 할때 파일업로드
	public void addAttatch(MultipartFile fileName) throws Exception;
	
	
}
