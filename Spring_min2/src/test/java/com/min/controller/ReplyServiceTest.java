/*package com.min.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.min.model.ReplyVO;
import com.min.service.ReplyService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")

public class ReplyServiceTest {
	@Autowired
	private ReplyService rbservice;
	
	@Test 
	public void testrepService() throws Exception{
		ReplyVO rv = new ReplyVO();
		rv.setBno(1);
		rv.setReplytext("댓글입니다.");
		rv.setReplyer("작성자");
		
		rbservice.RepWrite(rv);
		
	}
	
	@Test 
	public void testrepServiceUp() throws Exception{
		ReplyVO rv = new ReplyVO();
		rv.setReplytext("댓글 수정입니다.");
		rv.setRno(1);
		
		rbservice.RepModify(rv);
		
	}
	
	@Test 
	public void testrepServiceSe() throws Exception{
		ReplyVO rv = new ReplyVO();
		rv.setBno(1);
		
		rbservice.replylist(rv);
		
	}
	
	
	@Test 
	public void testrepServiceDe() throws Exception{
		ReplyVO rv = new ReplyVO();
		rv.setRno(1);
		
		rbservice.RepDelete(rv);
		
	}
	

}*/
































