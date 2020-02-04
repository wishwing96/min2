package com.min.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.min.model.BoardVO;
import com.min.model.Criteria;




@Repository
public class BoardMapperImpl implements BoardMapper {

	
	@Inject
	private SqlSession sqlSession;
	
	private static final String namespace="com.min.mapper.BoardMapper";

	
	
	
	@Override
	public List<BoardVO> boardList() {
		//selectList는 select된 결과가 여러 건 일때 사용하는 메서드
		List list = sqlSession.selectList(namespace+".boardList");
		return list;
	}

	@Override
	public List<BoardVO> boardListPaging(Criteria cri) throws Exception {
		List list = sqlSession.selectList(namespace+".boardListPage", cri);
		return list;
	}
	
	@Override
	public int boardCount(Criteria cri) throws Exception {
		int bcnt = sqlSession.selectOne(namespace+".boardCount",cri);
		return bcnt;
	}
	
	@Override
	public BoardVO boardDetail(int no) throws Exception{
			//selectOne은 select된 결과가 한 건 일대 사용하는 메서드
			BoardVO boardvo = sqlSession.selectOne(namespace+".boardDetail",no);
		return boardvo;
	}

	@Override
	public void boardWrite(BoardVO board, String fileName) {
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("fileName", fileName);
		paramMap.put("board", board);
		sqlSession.insert(namespace+".boardWrite",paramMap);
		
	}

	@Override
	public void boardModify(BoardVO board) {
		sqlSession.update(namespace+".boardModify",board);
		
	}

	/*
	 * @Override public void boardDel(BoardVO board) {
	 * 
	 * sqlSession.delete(namespace+".boardDel",board); }
	 */
	@Override
	public void boardDel(int no) {
		
		sqlSession.delete(namespace+".boardDel",no);
	}
/*
	@Override
	public void addAttatch(String fileName) throws Exception {
		sqlSession.insert(namespace+".addAttach", fileName);
	}
*/

	@Override
	public void addAttatch(MultipartFile fileName) throws Exception {
		// TODO Auto-generated method stub
		
	}


	

}
