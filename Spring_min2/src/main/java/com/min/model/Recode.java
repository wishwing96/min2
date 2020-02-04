package com.min.model;

public class Recode {
	
	private int pagenum;
	
	private int amount;
	
	private String keyword;
	
	public String getkeyword() {
		return keyword;
	}
	
	public void setkeyword(String keyword) {
		this.keyword = keyword;
	}
	
	public Recode() {
		this(1,10);
	}
	
	public Recode(int pagenum, int amount) {
		this.pagenum = pagenum;
		this.amount = amount;
	}
	
	public int getpagenum() {
		return pagenum;
	}
	
	public void setpagenum(int pagenum) {
		this.pagenum = pagenum;
	}
	
	public int getamount() {
		return amount;
	}
	
	public void setamount(int amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Recode [pagenum=" + pagenum + ", amount=" + amount + ", keyword=" + keyword + "]";
	}

}
