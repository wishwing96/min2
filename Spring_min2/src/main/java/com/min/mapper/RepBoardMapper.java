package com.min.mapper;

import java.util.List;

import com.min.model.Criteria;
import com.min.model.RepBoardVO;

public interface RepBoardMapper {

	//전체 목록 리스트
	public List<RepBoardVO> repboardList();
	
	//전체 목록 리스트(페이징 처리)
	//public List<BoardVO> boardListPaging(페이지 수, 한 페이지당 데이터 처리 갯수) throws Exception;
	public List<RepBoardVO> repboardListPaging(Criteria cri) throws Exception;
	
	//Board테이블의 레코드 전체 갯수 : 페이징의 realEnd를 알기 위해서
	public int repboardCount(Criteria cri) throws Exception; 
	
	
	// 제목을 클릭했을 때 상세 페이지
	public RepBoardVO repboardDetail(int bno) throws Exception;
	
	// 게시판 글쓰기
	//public void boardWrite(String subject, String writer, String content, int cnt); //도가능
	 public void repboardWrite(RepBoardVO board) throws Exception; 
	
	//게시판 글수정 
	public void repboardModify(RepBoardVO board) throws Exception;
	//public void boardModify(String subject, String content, int no);
	
	//게시판 글삭제
	/* public void boardDel(BoardVO board) throws Exception; */
	public void repboardDelete(RepBoardVO board) throws Exception;

	
	
	
}
