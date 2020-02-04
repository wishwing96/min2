package com.min.mapper;

import com.min.model.MessageVO;

public interface MessageMapper {

	//메세지 생성
	public void create(MessageVO vo) throws Exception;
	//메세지 조회
	public MessageVO readMessage(int mid) throws Exception;
	//메세지 상황 수정
	public void updateState(int mid) throws Exception;
	
}
