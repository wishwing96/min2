package com.min.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.min.model.Criteria;
import com.min.model.ReplyVO;

@Repository
public class ReplyMapperImpl implements ReplyMapper {

	@Inject
	private SqlSession sqlSession;
	
	private static final String namespace="com.min.mapper.ReplyMapper";

	@Override
	public List<ReplyVO> list(int bno) throws Exception {
		List list = sqlSession.selectList(namespace+".repboardList", bno);
		// TODO Auto-generated method stub
		return list;
	}
	
	@Override
	public List<ReplyVO> listPage(int bno, Criteria cri) throws Exception {
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("bno", bno);
		paramMap.put("cri", cri);
		
		List list = sqlSession.selectList(namespace+".repboardListPage", paramMap);
		// TODO Auto-generated method stub
		return list;
	}


	@Override
	public void RepWrite(ReplyVO vo) throws Exception {
		
		sqlSession.insert(namespace+".repboardWrite",vo);
		
	}

	@Override
	public void RepModify(ReplyVO vo) throws Exception {
		sqlSession.update(namespace+".repboardModify",vo);
		
	}

	@Override
	public void RepDelete(int rno) throws Exception {
		sqlSession.delete(namespace+".repboardDelete",rno);
		
	}

	@Override
	public int RepCount(int bno) throws Exception {
		return sqlSession.selectOne(namespace +".count", bno);
	}
}
