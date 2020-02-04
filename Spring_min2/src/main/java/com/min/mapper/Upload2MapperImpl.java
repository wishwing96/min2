package com.min.mapper;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.min.model.UploadVO;

@Repository
public class Upload2MapperImpl implements Upload2Mapper{

	@Inject
	private SqlSession sqlSession;
	private static final String namespace="com.min.mapper.Upload2Mapper";
	@Override
	public void upload2(UploadVO upload) {
		sqlSession.insert(namespace+".upload2", upload);
		
	}
	
	
}
