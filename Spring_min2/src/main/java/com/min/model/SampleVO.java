package com.min.model;

public class SampleVO {

	private String firstname;
	private String lastname;
	private int mno;
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public int getMno() {
		return mno;
	}
	public void setMno(int mno) {
		this.mno = mno;
	}
	@Override
	public String toString() {
		return "SampleVO [firstname=" + firstname + ", lastname=" + lastname + ", mno=" + mno + "]";
	}
	
	
}
