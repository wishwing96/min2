package com.min.model;

public class MailVO {
	// 받는 사람
	private String tomail;
	// 제목
	private String title;
	// 내용
	private String content;
	// 보내는 사람
	private String from;
	
	public String getTomail() {
		return tomail;
	}
	public void setTomail(String tomail) {
		this.tomail = tomail;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	@Override
	public String toString() {
		return "MailVO [tomail=" + tomail + ", title=" + title + ", content=" + content + ", from=" + from
				+ "]";
	}
}
