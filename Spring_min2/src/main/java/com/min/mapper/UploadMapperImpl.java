package com.min.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.min.model.AdminVO;
import com.min.model.UploadVO;

@Repository
public class UploadMapperImpl implements UploadMapper{

	@Inject
	private SqlSession sqlSession;
	private static final String namespace="com.min.mapper.UploadMapper";
	
	@Override
	//public void upload(AdminVO vo, String filename, String mainfilename) throws Exception {
	public void upload(AdminVO vo) throws Exception {
		sqlSession.insert(namespace+".upload", vo);
		
	}

	@Override
	public List<AdminVO> detail() throws Exception {
		List list = sqlSession.selectList(namespace+".detail");
		System.out.println("UploadMapper detail() list="+list);
		return list;
		
	}

	@Override
	public AdminVO maindetail(int no) throws Exception {
		AdminVO vo = sqlSession.selectOne(namespace+".maindetail", no);
		System.out.println("UploadMapper maindetail() vo="+vo);
		return vo;
	}

	@Override
	public void addAttach(String filename) throws Exception {
		sqlSession.insert(namespace+".addAttach", filename);
		
	}
	
	@Override
	public void maindelete(AdminVO vo) throws Exception {
		sqlSession.delete(namespace+".maindelete", vo);
		
	}
	

}
