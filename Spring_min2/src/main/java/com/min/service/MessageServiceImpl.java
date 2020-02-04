package com.min.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.min.mapper.MessageMapper;
import com.min.mapper.PointMapper;
import com.min.model.MessageVO;
@Service
public class MessageServiceImpl implements MessageService{

	@Autowired
	private MessageMapper mm;
	@Autowired
	private PointMapper pm;
	
	@Override
	public void addMessage(MessageVO vo) throws Exception {
		mm.create(vo);
		pm.updatePoint(vo.getSender(), 10);
		
	}

	@Override
	public MessageVO readMessage(String uid, int mid) throws Exception {
		mm.updateState(mid);
		pm.updatePoint(uid, 5);
		return mm.readMessage(mid);
	}

}
