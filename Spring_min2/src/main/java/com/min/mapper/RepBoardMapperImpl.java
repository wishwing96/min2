package com.min.mapper;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.min.model.Criteria;
import com.min.model.RepBoardVO;

@Repository
public class RepBoardMapperImpl implements RepBoardMapper {

	@Inject
	private SqlSession sqlSession;
	
	private static final String namespace="com.min.mapper.RepBoardMapper";

	
	
	
	@Override
	public List<RepBoardVO> repboardList() {
		//selectList는 select된 결과가 여러 건 일때 사용하는 메서드
		List list = sqlSession.selectList(namespace+".repboardList");
		return list;
	}

	@Override
	public List<RepBoardVO> repboardListPaging(Criteria cri) throws Exception {
		List list = sqlSession.selectList(namespace+".repboardListPage", cri);
		return list;
	}
	
	@Override
	public int repboardCount(Criteria cri) throws Exception {
		int bcnt = sqlSession.selectOne(namespace+".repboardCount",cri);
		return bcnt;
	}
	
	@Override
	public RepBoardVO repboardDetail(int bno) throws Exception{
			//selectOne은 select된 결과가 한 건 일대 사용하는 메서드
		RepBoardVO boardvo = sqlSession.selectOne(namespace+".repboardDetail",bno);
		return boardvo;
	}

	@Override
	public void repboardWrite(RepBoardVO board) {
		sqlSession.insert(namespace+".repboardWrite",board);
		
	}

	@Override
	public void repboardModify(RepBoardVO board) {
		sqlSession.update(namespace+".repboardModify",board);
		
	}

	/*
	 * @Override public void boardDel(BoardVO board) {
	 * 
	 * sqlSession.delete(namespace+".boardDel",board); }
	 */
	@Override
	public void repboardDelete(RepBoardVO board) {
		
		sqlSession.delete(namespace+".repboardDelete",board);
	}



	

	
}
