package com.min.model;

import java.util.Arrays;

import org.springframework.web.multipart.MultipartFile;

public class BoardVO {

	private int no;

	private String subject;

	private String writer;

	private String write_date;

	private String content;
	
	private int cnt;
	
	private MultipartFile fileName;
	//만약 하지않는다면 boardController register post에 boardVO옆에 MultipartFile를 추가

	public int getno() {
		return no;
	}

	public void setno(int no) {
		this.no = no;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getwriter() {
		return writer;
	}

	public void setwriter(String writer) {
		this.writer = writer;
	}



	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}

	public String getwrite_date() {
		return write_date;
	}

	public void setwrite_date(String write_date) {
		this.write_date = write_date;
	}

	public MultipartFile getFileName() {
		return fileName;
	}

	public void setFileName(MultipartFile fileName) {
		this.fileName = fileName;
	}

	@Override
	public String toString() {
		return "BoardVO [no=" + no + ", subject=" + subject + ", writer=" + writer + ", write_date=" + write_date
				+ ", content=" + content + ", cnt=" + cnt + "]";
	}

	
}
