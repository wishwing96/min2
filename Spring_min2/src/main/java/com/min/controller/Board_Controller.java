package com.min.controller;

import java.io.File;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.min.model.Board_VO;
import com.min.model.JoinVO;
import com.min.model.Page_VO;
import com.min.model.Recode;
import com.min.service.Board_Service;

@Controller
public class Board_Controller {
	
	@Autowired
	private Board_Service bs;
	
	@Resource
	private String uploadPath;
	
	@RequestMapping(value="/board_list", method=RequestMethod.GET)
	public void listGET(Recode rec, Model model) throws Exception{
		int total = bs.boardcount(rec);
		Page_VO pv = new Page_VO(rec, total);
		System.out.println("listget==========");
		System.out.println("total="+total);
		System.out.println("pv="+pv.isPrev());
		System.out.println("amount"+rec.getamount());
		System.out.println("amount"+rec.getkeyword());
		model.addAttribute("list",bs.boardlist(rec));
		model.addAttribute("page",pv);
	}
	
	@RequestMapping(value="/board_write", method=RequestMethod.GET)
	public String registGET() throws Exception{
		System.out.println("boardregister===========");
		return "board_write";
	}
	
	@RequestMapping(value="/board_write", method=RequestMethod.POST)
	public String registPOST(Board_VO board, Model model) throws Exception{		
		/*System.out.println("originalName"+board.getFilename().getOriginalFilename());
		System.out.println("size"+board.getFilename().getSize());
		System.out.println("contentType"+board.getFilename().getContentType());
		*/
		System.out.println("filename"+board.getFilename());
		String filename=uploadFile(board.getFilename().getOriginalFilename(), board.getFilename().getBytes());
		bs.boardwrite(board, filename);
		//String saveName = uploadFile(board.getFilename().getOriginalFilename(), board.getFilename().getBytes());
		
		//model.addAttribute("saveName", saveName);
		
		return "redirect:board_list";
	}
	
	private String uploadFile(String originalName, byte[] fileData) throws Exception{
		
		UUID uid = UUID.randomUUID();// UUID는 범용 고유 식별자 (파일 이름을 식별할 수 있게 이름을 랜덤하게 해준다.)
		
		String saveName = uid.toString()+"_"+originalName;
		
		File targer = new File(uploadPath, saveName);//D:/upload/파일이름.제이피지.
		
		FileCopyUtils.copy(fileData, targer);//이름이 같은것을 타깃으로 고유 식별자를 붙이는 메소드
		
		return saveName;
	}
	
	@RequestMapping(value="/board_detail", method=RequestMethod.GET)
	public String detailGET(@RequestParam int no,Model model, Board_VO board) throws Exception{
		System.out.println("detailGet===="+ bs.boarddetail(no));
		System.out.println("detail"+board.getFile());
		model.addAttribute("detail", bs.boarddetail(no));
		
		
		return "board_detail";
	}
	
	@RequestMapping(value="/board_modify", method=RequestMethod.GET)
	public String modifyGET(int no, Model model, JoinVO join) throws Exception{
		System.out.println("modifyget================"+no);
		
		model.addAttribute("detail", bs.boarddetail(no));
		
		return "board_modify";
	}
	
	@RequestMapping(value="/board_modify", method=RequestMethod.POST)
	public String modifyPOST(Board_VO board) throws Exception{
		System.out.println("modifypost================");
		System.out.println("modify"+board.getSubject());
		bs.boardmodify(board);
		
		return "redirect:board_detail?no="+board.getNo();
	}
	

	@RequestMapping(value="/board_delete", method=RequestMethod.GET)
	public String deleteGET(Board_VO board) throws Exception{
		System.out.println("delete================");
		
		bs.boarddelete(board);
		
		return "redirect:board_list";
	}
	

}


























































































