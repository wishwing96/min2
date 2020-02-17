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
	private int stock;
	
	
	
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}

	private String filename;

	private String uploadPath;

	private String uuid;

	private boolean image;

	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getUploadPath() {
		return uploadPath;
	}
	public void setUploadPath(String uploadPath) {
		this.uploadPath = uploadPath;
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public boolean isImage() {
		return image;
	}
	public void setImage(boolean image) {
		this.image = image;
	}
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
	
	@Override
	public String toString() {
		return "AdminVO [no=" + no + ", name=" + name + ", uploadvo=" + uploadvo + ", amount=" + amount
				+ ", proexplain=" + proexplain + ", price=" + price + ", stock=" + stock + ", filename=" + filename
				+ ", uploadPath=" + uploadPath + ", uuid=" + uuid + ", image=" + image + "]";
	}


	
}

