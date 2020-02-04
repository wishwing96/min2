package com.min.controller;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.min.mapper.BoardMapper;
import com.min.model.BoardVO;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class BoardMapperTest {

	@Autowired
	private BoardMapper boardMapper;

@Test
public void testBoardList() {
	
	//System.out.println(boardMapper.boardList());
	Logger.getLogger("" + boardMapper.boardList());
}

@Test
public void testBoardDetail() throws Exception{
	
	//System.out.println(boardMapper.boardList());
	BoardVO board=boardMapper.boardDetail(9);
	System.out.println("board result"+board.toString());
	Logger.getLogger("" + boardMapper.boardDetail(9));
}

@Test
public void testboardWrite() throws Exception {
	
	BoardVO board = new BoardVO();
	board.setSubject("스프링 연습중입니다.");
	board.setwriter("스프링");
	board.setContent("스프링 연습중입니다. 컨텐츠 부분입니다.");
	board.setCnt(3);
	//boardMapper.boardWrite("스프링 연습중입니다.", "스프링", "스프링 연습중입니다. 컨텐츠 부분입니다.", 10);
	boardMapper.boardWrite(board);
}	
	
@Test
public void testboardModify() throws Exception {
	
	BoardVO board = new BoardVO();
	board.setSubject("스프링 수정중입니다..");
	board.setContent("스프링 수정 연습중입니다. 컨텐츠 부분입니다.");
	board.setno(18);
	//boardMapper.boardModify("스프링 수정중입니다..", "스프링 수정 연습중입니다. 컨텐츠 부분입니다.", 16);
	boardMapper.boardModify(board);
}	
/*
@Test
public void testboardDel() throws Exception {
	
	BoardVO board = new BoardVO();
	board.setno(12);
	boardMapper.boardDel(board);
}	
*/



}
