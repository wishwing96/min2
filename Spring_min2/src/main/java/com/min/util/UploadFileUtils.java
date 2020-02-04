package com.min.util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.UUID;

import javax.imageio.ImageIO;

import org.imgscalr.Scalr;
import org.springframework.util.FileCopyUtils;

public class UploadFileUtils {
	
	public static String uploadFile(String uploadPath, 
									String originalName, 
									byte[] fileData) throws Exception{
		UUID uid = UUID.randomUUID();
		
		String savedName = uid.toString() + "_" + originalName;
		String savedPath = calcPath(uploadPath);
		File target = new File(uploadPath+savedPath,savedName);
		FileCopyUtils.copy(fileData, target);//파일을 보내주는 담당(in, out)
		
		String formatName = originalName.substring(originalName.lastIndexOf(".")+1);
		
		String uploadedFileName = null;
		
		if(MimeMediaUtil.getMediaType(formatName)!=null) {
			uploadedFileName = makeThumbnail(uploadPath, savedPath, savedName);
		}else {
			uploadedFileName = makeIcon(uploadPath, savedPath, savedName);
		}
		
		return uploadedFileName;
	}
	
	private static String calcPath(String uploadPath) {
		Calendar cal = Calendar.getInstance();
		
		String yearPath=File.separator+cal.get(Calendar.YEAR);//separator= / 이고 뒤에가 2020 
		
		String monthPath=yearPath + 
				File.separator +
				new DecimalFormat("00").format(cal.get(Calendar.MONTH)+1);//java에선 month는 0부터 시작이어서 1더해주기
		
		String datePath = monthPath + 
				File.separator + 
				new DecimalFormat("00").format(cal.get(Calendar.DATE));
		
		makeDir(uploadPath, yearPath, monthPath, datePath);
		
		System.out.println(datePath);
		
		return datePath;
	}
	
	private static void makeDir(String uploadPath, String... paths) {
		
		if(new File(paths[paths.length-1]).exists()) {
			return;
		}
		
		for(String path:paths) {
			File dirPath = new File(uploadPath+path);
			
			if(!dirPath.exists()) {
				dirPath.mkdir();
			}
		}
	}
	
	private static String makeThumbnail(
			String uploadPath,
			String path,
			String fileName)throws Exception{
		BufferedImage sourceImg=
				ImageIO.read(new File(uploadPath+path,fileName));
		
		BufferedImage destImg = 
				Scalr.resize(sourceImg,
						Scalr.Method.AUTOMATIC,
						Scalr.Mode.FIT_TO_HEIGHT, 100);
		
		String thumbnailName =
				uploadPath + path +File.separator+"s_"+fileName;
		
		File newFile = new File(thumbnailName);
		String formatName = 
				fileName.substring(fileName.lastIndexOf(".")+1);//lastIndexOf는 끝에서 부터 .을 찾아라(jpg인지 png인지 등을 구분하기위해)
				
		ImageIO.write(destImg, formatName.toUpperCase(), newFile);
		
		return thumbnailName.substring(
				uploadPath.length()).replace(File.separatorChar, '/');
		
	}
	
	private static String makeIcon(String uploadPath, String path, String fileName)
									throws Exception{
		String iconName = 
				uploadPath + path + File.separator + fileName;
		
		return iconName.substring(
				uploadPath.length()).replace(File.separatorChar, '/');
	}

}










































