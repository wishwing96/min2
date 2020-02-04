package com.min.model;

import org.springframework.web.multipart.MultipartFile;

public class Board_VO {
	
	private int no;
	private int bno;
    private String subject;
    private String content;
    private String uid;
    private String write_date;
    private MultipartFile filename;
    private String file;

    
    
	public String getFile() {
		return file;
	}
	public void setFile(String file) {
		this.file = file;
	}
	public MultipartFile getFilename() {
		return filename;
	}
	public void setFilename(MultipartFile filename) {
		this.filename = filename;
	}
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getWrite_date() {
		return write_date;
	}
	public void setWrite_date(String write_date) {
		this.write_date = write_date;
	}
	
	@Override
	public String toString() {
		return "Board_VO [no=" + no + ", bno=" + bno + ", subject=" + subject + ", content=" + content + ", uid=" + uid
				+ ", write_date=" + write_date + ", filename=" + filename + ", file=" + file + "]";
	}

	

}
