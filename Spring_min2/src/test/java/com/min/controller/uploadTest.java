package com.min.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.min.mapper.Upload2Mapper;
import com.min.model.UploadVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class uploadTest {

	
	@Autowired
	private Upload2Mapper mapper;
	
	@Test
	public void uploadTest() throws Exception{
		UploadVO vo = new UploadVO();
		
		vo.setFilename("aa");
		vo.setImage(true);
		vo.setProductno(47);
		vo.setUploadPath("aa");
		vo.setUuid("aa");
		mapper.upload2(vo);
		
	}
	
	
}
