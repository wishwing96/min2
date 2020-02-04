package com.min.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.min.model.AdminVO;
import com.min.model.UploadVO;
import com.min.service.UploadService;

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
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		Date date = new Date();
		
		String str = sdf.format(date);
		
		return str.replace("-",File.separator);
	}
	
	
	// 파일이 이미지인지 다른파일의 형식인지를 판단하는 메서드
	private boolean checkImageType(File file) {
		
		try {
			String contentType = Files.probeContentType(file.toPath());
			
			return contentType.startsWith("image");
		} catch(IOException e) {
			e.printStackTrace();			
		}
		return false;
		
	}
	
	@ResponseBody
	@RequestMapping(value="/ajax", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<UploadVO>>ajaxPost(MultipartFile[] uploadFile, AdminVO vo)
	{
		
		List<UploadVO> list = new ArrayList<>();
		String uploadFolder = "D:\\upload";
		
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

			//check image type file  => make thumbnail
				/*if(checkImageType(saveFile)) {
					
					admin.setImage(true);
					
					System.out.println("uploadPath"+uploadPath);
					System.out.println("uploadFileName"+uploadFileName);
							
					FileOutputStream thumbnail = new FileOutputStream(new File(uploadPath, "s_" + uploadFileName));
					System.out.println("aaaaaaaa");
					System.out.println("thumbnail="+thumbnail);
					System.out.println("multipartFile.getInputStream()="+multipartFile.getInputStream());
					System.out.println("bbbbbbbb");
					Thumbnailator.createThumbnail(multipartFile.getInputStream(), thumbnail, 100, 100);
					System.out.println("checkImageType");
							
					thumbnail.close();
					
				
				}*/

					
				//add to List
				list.add(admin);
				System.out.println("list====="+list);
					
					
				} catch(Exception e) {
					logger.error(e.getMessage());
				}// end catch
			
			
		} //end for
		System.out.println("등록완료");
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
	@RequestMapping(value="/adminpage", method = RequestMethod.GET)
	public void adminpageGet()
	{
		logger.info("adminpageGET!~!~!~!~!~!~!");
		
	}
	
	@RequestMapping(value="/adminpage", method = RequestMethod.POST)
	public String adminpagePost(AdminVO vo) throws Exception
	{
		logger.info("adminpage Post!!!!!!!!!!");
		if(vo.getUploadvo() != null) {
			System.out.println("aaaaaa");
			vo.getUploadvo().forEach(attach -> logger.info(""+attach));
			//System.out.println("book.getbCover()"+book.getbCover());
			
		}
		
		System.out.println("aaaa="+vo);
		us.upload(vo);
		System.out.println("bbbb");
		
		
		return "main";
		
	}
	

	@RequestMapping("/display")
	@ResponseBody
	public ResponseEntity<byte[]> getFile(String filename){
		
		logger.info("filename : " + filename);
		
		File file = new File("D:\\upload\\"+filename);
		
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

	

	/*@RequestMapping(value="/adminpage", method = RequestMethod.POST)
	public String adminpagePost(AdminVO vo, Model model) throws Exception{
		
		
		System.out.println("adminpagePost");
		String filename = null;
		for(MultipartFile file : vo.getFilename()) {
			System.out.println(file.getOriginalFilename());
			filename = uploadFile(file.getOriginalFilename(), file.getBytes());
		}
		
		//String filename = uploadFile(vo.getFilename().getOriginalFilename(), vo.getFilename().getBytes());
		String mainfilename = uploadFile(vo.getMainfilename().getOriginalFilename(), vo.getMainfilename().getBytes());
		us.upload(vo, mainfilename);
	
		return "main";
	}*/
	
	@RequestMapping(value="/maindelete", method = RequestMethod.GET)
	public String deletePost(AdminVO vo) throws Exception{
		logger.info("delete+++++");
		
		us.maindelete(vo);
	
		return "main_delete";
	}
	
	/*<form>를 이용하여 파일 업로드*/
	@RequestMapping(value="/uploadForm", method = RequestMethod.GET)
	
	public void uploadFormGet()
	{
		
	}
	
	@RequestMapping(value="/uploadForm", method = RequestMethod.POST)
	public String uploadFormPost(MultipartFile file, Model model) throws Exception {
		logger.info("originalName = "+ file.getOriginalFilename());
		logger.info("size = " + file.getSize());
		logger.info("byte = " + file.getBytes());
		logger.info("contentfile = " + file.getContentType());
		
		String saveName=uploadFile(file.getOriginalFilename(), file.getBytes());
		model.addAttribute("saveName", saveName);
		
		return "uploadResult";
		
	}
	
	private String uploadFile(String originalName, byte[] fileData) throws Exception{
		
		UUID uid = UUID.randomUUID();//UUID는 범용 고유 식별자 (파일 이름을 식별할 수 있게 이름을 랜덤하게 해준다.)
		
		String saveName = uid.toString()+"_"+originalName;
		
		File targer = new File(uploadPath, saveName);//D:/upload/파일이름.제이피지.
		
		FileCopyUtils.copy(fileData, targer);//이름이 같은것을 타깃으로 고유 식별자를 붙이는 메소드
		
		return saveName;
	}
	
	/*ajax를 이용한 파일 업로드*/
	
	@RequestMapping(value="/uploadAjax", method = RequestMethod.GET)
	public void uploadAjax() {
		logger.info("uploadGet : ");
	}
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
	
/*	@ResponseBody
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
	}
	
	@ResponseBody
	@RequestMapping(value="/displayFile", method=RequestMethod.GET)
	public ResponseEntity<byte[]> displayFile(String fileName) throws Exception{
		InputStream in =null;
		ResponseEntity<byte[]> entity = null;
		File file = new File("D:\\upload\\"+fileName);
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
	@RequestMapping(value="/deleteFile", method=RequestMethod.POST)
	public ResponseEntity<String> deleteFile(String fileName){
		logger.info("delete file: " + fileName);
		
		String formatName =  fileName.substring(fileName.lastIndexOf(".")+1);
		
		MediaType mType = MimeMediaUtil.getMediaType(formatName);
		
		if(mType!=null) {
			String front = fileName.substring(0,12);
			String end = fileName.substring(14);
			new File(uploadPath + (front+end).replace('/', File.separatorChar)).delete();
		}
			new File(uploadPath + fileName.replace('/', File.separatorChar)).delete();
			
			return new ResponseEntity<String>("deleted", HttpStatus.OK);
	}

}*/








































