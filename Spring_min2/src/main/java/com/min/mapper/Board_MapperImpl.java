package com.min.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.min.model.Board_VO;
import com.min.model.Recode;

@Repository
public class Board_MapperImpl implements Board_Mapper{
	
	@Inject
	private SqlSession sqlSession;
	private static final String namespace="com.min.mapper.Board_Mapper";

	@Override
	public List<Board_VO> boardlist(Recode rec) throws Exception {
		
		List list = sqlSession.selectList(namespace+".boardlist", rec);
		return list;
	}

	@Override
	public void boardwrite(Board_VO board, String filename) {
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("filename", filename);
		paramMap.put("board", board);
		sqlSession.insert(namespace+".boardwrite", paramMap);
	}
 
	@Override
	public int boardcount(Recode rec) throws Exception {
		int cnt = sqlSession.selectOne(namespace+".boardcount", rec);
		return cnt;
	}

	@Override
	public Board_VO boarddetail(int no) throws Exception {
		Board_VO vo = sqlSession.selectOne(namespace+".boarddetail", no);
		return vo;
	}

	@Override
	public void boardmodify(Board_VO board) throws Exception {
		sqlSession.update(namespace+".boardmodify", board);
		
	}

	@Override
	public void boarddelete(Board_VO board) throws Exception {
		sqlSession.delete(namespace+".boarddelete", board);
		
	}

	@Override
	public void addAttatch(MultipartFile fileName) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
