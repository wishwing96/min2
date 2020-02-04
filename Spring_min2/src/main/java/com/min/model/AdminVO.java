package com.min.model;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class AdminVO {

	private int no;
	private String name;
	private List<UploadVO> uploadvo;
	private int amount;
	private String proexplain;
	private int price;
	private String mainfile;
	private MultipartFile mainfilename;
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<UploadVO> getUploadvo() {
		return uploadvo;
	}
	public void setUploadvo(List<UploadVO> uploadvo) {
		this.uploadvo = uploadvo;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getProexplain() {
		return proexplain;
	}
	public void setProexplain(String proexplain) {
		this.proexplain = proexplain;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getMainfile() {
		return mainfile;
	}
	public void setMainfile(String mainfile) {
		this.mainfile = mainfile;
	}
	public MultipartFile getMainfilename() {
		return mainfilename;
	}
	public void setMainfilename(MultipartFile mainfilename) {
		this.mainfilename = mainfilename;
	}
	
	@Override
	public String toString() {
		return "AdminVO [no=" + no + ", name=" + name + ", uploadvo=" + uploadvo + ", amount=" + amount
				+ ", proexplain=" + proexplain + ", price=" + price + "]";
	}
	
	
	
}

