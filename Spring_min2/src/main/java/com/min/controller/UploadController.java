package com.min.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.min.model.AdminVO;
import com.min.model.BoardRepVO;
import com.min.model.UploadVO;
import com.min.service.UploadService;
import com.min.util.MimeMediaUtil;

import net.coobird.thumbnailator.Thumbnailator;


@Controller
public class UploadController {

	@Autowired
	private UploadService us;
	@Resource
	private String uploadPath;
	
	private static final Logger logger = LoggerFactory.getLogger(UploadController.class);
	
	@RequestMapping(value="/ajax", method = RequestMethod.GET)
	public void ajaxGet()
	{
		
	}
	
	private String getFolder() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd/");
		
		Date date = new Date();
		
		String str = sdf.format(date);
		
		return str.replace("-",File.separator);
	}
	
	@ResponseBody
	@RequestMapping(value="/ajax", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<UploadVO>>ajaxPost(MultipartFile[] uploadFile)
	{
		
		List<UploadVO> list = new ArrayList<>();
		String uploadFolder = "C:\\upload";
		
		String uploadFolderPath = getFolder();
		//make folder ------
		File uploadPath = new File(uploadFolder, uploadFolderPath);
		
		logger.info("upload path : " + uploadPath);
		logger.info("uploadFolderPath : " + uploadFolderPath);
		if(uploadPath.exists() == false) {
			uploadPath.mkdirs();
		}
		// make yyy/MM/dd folser
		
		for (MultipartFile multipartFile : uploadFile) {
			
			UploadVO admin = new UploadVO();
			
			System.out.println("-----------------------------------------");
			System.out.println("Upload File Name: " + multipartFile.getOriginalFilename());
			System.out.println("Upload File Size: " + multipartFile.getSize());
			String uploadFileName = multipartFile.getOriginalFilename();
			
			// IE has file path
			uploadFileName = uploadFileName.substring(uploadFileName.lastIndexOf("\\")+1);
			logger.info("only file name: " + uploadFileName);
			admin.setFilename(uploadFileName);
			
			UUID uuid = UUID.randomUUID();
			
			uploadFileName = uuid.toString() + "_" + uploadFileName;
			
			//File saveFile = new File(uploadFolder, uploadFileName);
			//File saveFile = new File(uploadPath, uploadFileName);
			
			try {
				File saveFile = new File(uploadPath, uploadFileName);
				
				multipartFile.transferTo(saveFile);
				
				admin.setUuid(uuid.toString());
				admin.setUploadPath(uploadFolderPath);
				System.out.println("saveFile==="+saveFile);
				System.out.println("admin==="+admin.getUploadPath());
		
				list.add(admin);
				System.out.println("list====="+list);
					
					
				} catch(Exception e) {
					logger.error(e.getMessage());
				}// end catch
			
			
		} //end for
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
	@RequestMapping(value="/adminpage", method = RequestMethod.GET)
	public void adminpageGet()
	{
		logger.info("adminpageGET!~!~!~!~!~!~!");
		
	}
	
	@RequestMapping(value="/adminpage", method = RequestMethod.POST)
	public String adminpagePost(AdminVO vo, String file) throws Exception
	{
		logger.info("adminpage Post!!!!!!!!!!");
		if(vo.getUploadvo() != null) {
			vo.getUploadvo().forEach(attach -> logger.info("여기에 이거는 뭔가요?"+attach));
			
			file = vo.getUploadvo().get(0).getUploadPath()+
						vo.getUploadvo().get(0).getUuid()+"_"+
						vo.getUploadvo().get(0).getFilename();
			 logger.info("파일이 제대로 들어갔나요?"+file);
		}
		
		us.upload(vo, file);
		System.out.println("bbbb");
		
		
		return "main";
		
	}
	
	@RequestMapping(value="/register", method = RequestMethod.GET)
	public void registerPost(Model model) throws Exception
	{
		System.out.println("register controller="+us.detail());
		model.addAttribute("list", us.detail());
	}

	@RequestMapping("/display")
	@ResponseBody
	public ResponseEntity<byte[]> getFile(String filename){
		
		logger.info("filename : " + filename);
		
		File file = new File("C:\\upload\\"+filename);
		
		logger.info("file : " + file);
		
		ResponseEntity<byte[]> result = null;
		
		try {
			
			HttpHeaders header = new HttpHeaders();
			
			header.add("Content-Type", Files.probeContentType(file.toPath()));
			result = new ResponseEntity<>(FileCopyUtils.copyToByteArray(file), header, HttpStatus.OK);
			
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		return result;
		
	}
	
	@ResponseBody
	@RequestMapping(value="/uploadDel", method = RequestMethod.POST)
	public int deletePost(@RequestParam(value = "chbox[]") List<String> chArr, AdminVO vo)throws Exception{
		logger.info("delete+++++");
		
		int result = 0;
		int no = 0;
		
		for(String i : chArr) {
			no = Integer.parseInt(i);
			vo.setNo(no);
			us.uploadDel(vo);
		}
		
		result = 1;
	
		return result;
	}

	@RequestMapping(value="/uploadAjax", method = RequestMethod.GET)
	public void uploadAjax() {
		logger.info("uploadGet : ");
	}
	
	/*
	@ResponseBody
	@RequestMapping(value = "/uploadAjax",
					method = RequestMethod.POST,
					produces = "text/plain;charset=UTF-8")
	public ResponseEntity<String> uploadAjax(MultipartFile file) throws Exception{
		logger.info("originalName = "+ file.getOriginalFilename());
		logger.info("size = " + file.getSize());
		logger.info("byte = " + file.getBytes());
		logger.info("contentfile = " + file.getContentType());
		
		return new ResponseEntity<>(file.getOriginalFilename(), HttpStatus.CREATED);
	}
	
	@ResponseBody
	@RequestMapping(value="/uploadAjax", method=RequestMethod.POST,
					produces = "text/plain;charset=UTF-8")
	public ResponseEntity<String> uploadAjax(MultipartFile file)throws Exception{
		logger.info("originalName: "+file.getOriginalFilename());
		
		return 
			new ResponseEntity<>(
					UploadFileUtils.uploadFile(uploadPath,
							file.getOriginalFilename(), 
							file.getBytes()),
					HttpStatus.CREATED);
	}
	
	@ResponseBody
	@RequestMapping("/displayFile")
	public ResponseEntity<byte[]> displayFile(String fileName) throws Exception{
		InputStream in =null;
		ResponseEntity<byte[]> entity = null;
		
		logger.info("File Name:" + fileName);
		
		try {
			String formatName = 
					fileName.substring(fileName.lastIndexOf(".")+1);
			MediaType mType = MimeMediaUtil.getMediaType(formatName);
			
			HttpHeaders headers = new HttpHeaders();
			in = new FileInputStream(uploadPath+fileName);
			if(mType != null) {
				headers.setContentType(mType);
			}else {
			fileName = fileName.substring(fileName.indexOf("_")+1);
			headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
			headers.add("Content-Disposition", "attachment; fileName=\""+
			new String(fileName.getBytes("UTF-8"), "ISO-8859-1")+"\"");
			}
		}catch(Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<byte[]>(HttpStatus.BAD_REQUEST);
		}finally {
			in.close();
		}
		return entity;
	}*/
	
	@ResponseBody
	@RequestMapping(value="/displayFile", method=RequestMethod.GET)
	public ResponseEntity<byte[]> displayFile(String fileName) throws Exception{
		InputStream in =null;
		ResponseEntity<byte[]> entity = null;
		File file = new File("C:\\upload\\"+fileName);
		logger.info("File Name:" + fileName);
		
		try {
			String formatName = fileName.substring(fileName.lastIndexOf(".")+1);
			MediaType mType = MimeMediaUtil.getMediaType(formatName);
			HttpHeaders header = new HttpHeaders();
			in = new FileInputStream(uploadPath+fileName);
			//header.add("Content-Type", Files.probeContentType(file.toPath()));
			if(mType != null) {
				header.add("Content-Type", Files.probeContentType(file.toPath()));
			}else {
			fileName = fileName.substring(fileName.indexOf("_")+1);
			header.setContentType(MediaType.APPLICATION_OCTET_STREAM);
			header.add("Content-DisPosition", "attachment; fileName=\""+
			new String(fileName.getBytes("UTF-8"), "ISO-8859-1")+"\"");
			}
			entity = new ResponseEntity<>(FileCopyUtils.copyToByteArray(file),
					header, HttpStatus.OK);
	
		}catch(Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<byte[]>(HttpStatus.BAD_REQUEST);
		}finally {
			in.close();
		}
		return entity;
	}
	
	
	@ResponseBody
	@RequestMapping(value="/reply", method=RequestMethod.POST)
	public ResponseEntity<String> registReply(@RequestBody BoardRepVO reply) throws Exception{
		ResponseEntity<String> entity = null;
		try {
			us.registerReply(reply);
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	@ResponseBody	
	@RequestMapping(value="/replyList/{gdsnum}", method = RequestMethod.GET)
	public ResponseEntity<List<BoardRepVO>> list(@PathVariable("gdsnum") int gdsnum){
		ResponseEntity<List<BoardRepVO>> entity=null;
	
		try {
			entity=new ResponseEntity<List<BoardRepVO>>(us.replyList(gdsnum), HttpStatus.OK);
			
		}catch(Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<List<BoardRepVO>>(HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}
}










































