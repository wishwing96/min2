package com.min.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.min.model.AdminVO;
import com.min.model.BoardRepVO;
import com.min.model.UploadVO;

@Repository
public class UploadMapperImpl implements UploadMapper{

	@Inject
	private SqlSession sqlSession;
	private static final String namespace="com.min.mapper.UploadMapper";
	
	@Override
	//public void upload(AdminVO vo, String filename, String mainfilename) throws Exception {
	public void upload(AdminVO vo, String file) throws Exception {
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("file", file);
		paramMap.put("vo", vo);
		sqlSession.insert(namespace+".upload", paramMap);
	}
	
	@Override
	public List<AdminVO> detail() throws Exception {
		List list = sqlSession.selectList(namespace+".detail");
		return list;
		
	}

	@Override
	public List<AdminVO> maindetail(int no) throws Exception {
		List list = sqlSession.selectList(namespace+".maindetail", no);
		return list;
	}
	
	@Override
	public void uploadDel(AdminVO vo) throws Exception {
		sqlSession.delete(namespace+".uploadDel", vo);
		
	}

	@Override
	public void registerReply(BoardRepVO reply) throws Exception {
		sqlSession.insert(namespace+".regiterReply", reply);
		
	}

	@Override
	public List<BoardRepVO> replyList(int gdsnum) throws Exception {
		List list = sqlSession.selectList(namespace+".replyList", gdsnum);
		return list;
	}




	

}
