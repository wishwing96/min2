package com.min.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.min.mapper.BoardMapper;
import com.min.model.BoardVO;
import com.min.model.Criteria;


@Service
public class BoardServiceImpl implements BoardService{

	@Autowired
	BoardMapper bm;
	
	@Override
	public List<BoardVO> boardList() throws Exception {
		
		return bm.boardList();
	}
	
	@Override
	public List<BoardVO> boardListPaging(Criteria cri) throws Exception {
		
		return bm.boardListPaging(cri);
	}

	@Override
	public BoardVO boardDetail(int no) throws Exception {
		
		return bm.boardDetail(no);
	}

	@Override
	public void boardModify(BoardVO board) throws Exception {
		bm.boardModify(board);
		
	}

	/*
	 * @Override public void boardDel(BoardVO board) throws Exception {
	 * bm.boardDel(board);
	 * 
	 * }
	 */
	@Override
	public void boardDel(int no) throws Exception {
		bm.boardDel(no);
		
	}

	@Transactional
	@Override
	public void boardWrite(BoardVO board, String fileName) throws Exception {
		bm.boardWrite(board, fileName);
		
		/*
		String[] files = board.getFile();
		if(files == null) {
			return;
		}
		
		for(String fileName : files) {
			bm.addAttatch(fileName);
		}*/
		
	}

	@Override
	public int boardCount(Criteria cri) throws Exception {
		
		return bm.boardCount(cri);
	}
	
	

}
