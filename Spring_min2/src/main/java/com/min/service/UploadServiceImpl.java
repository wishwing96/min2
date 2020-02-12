package com.min.service;

import java.io.File;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import com.min.mapper.Upload2Mapper;
import com.min.mapper.UploadMapper;
import com.min.model.AdminVO;
import com.min.model.BoardRepVO;
import com.min.model.Criteria;
import com.min.model.UploadVO;

@Service
public class UploadServiceImpl implements UploadService {
	
	@Autowired
	private UploadMapper um;
	@Autowired
	private Upload2Mapper um2;
	//@Resource
	//private String uploadPath;
	
	@Transactional
	@Override
	public void upload(AdminVO vo) throws Exception{
		um.upload(vo);
		
		
		if(vo.getUploadvo() == null ||vo.getUploadvo().size() <=0) {
			return;
		}
		System.out.println("등록(service단계)"+vo);
		System.out.println("등록(service단계)"+vo.getNo());
		vo.getUploadvo().forEach(attach ->{
			System.out.println("service vo.get"+vo.getNo());
			
			attach.setNo(vo.getNo());
			
			System.out.println("service attach.get"+ attach.getNo());
			um.upload1(attach);
		});
	}

	@Override
	public List<AdminVO> detail() throws Exception {
		System.out.println("main service");
		return um.detail();
		
	}

	@Override
	public List<AdminVO> maindetail(int no) throws Exception {
		System.out.println("UploadService list="+um.maindetail(no));
		return um.maindetail(no);
	}

	@Override
	public void uploadDel(AdminVO vo) throws Exception {
		um.uploadDel(vo);
		
	}

	@Override
	public void registerReply(BoardRepVO reply) throws Exception {
		um.registerReply(reply);
		
	}

	@Override
	public List<BoardRepVO> replyList(int gdsnum) throws Exception {
		return um.replyList(gdsnum);
	}


}
