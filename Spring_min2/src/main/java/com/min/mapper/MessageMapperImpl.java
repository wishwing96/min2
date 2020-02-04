package com.min.mapper;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.min.model.MessageVO;

@Repository
public class MessageMapperImpl implements MessageMapper {

	@Autowired
	private SqlSession session;
	private static String namespace = "com.min.mapper.MessageMapper";
	
	@Override
	public void create(MessageVO vo) throws Exception{
		session.insert(namespace+".create", vo);
	}
	
	@Override
	public MessageVO readMessage(int mid) throws Exception {
		return session.selectOne(namespace+".readMessage", mid);
	}

	@Override
	public void updateState(int mid) throws Exception {
		session.update(namespace+".updateState", mid);
		
	}

}
