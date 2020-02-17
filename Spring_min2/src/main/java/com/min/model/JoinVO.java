package com.min.model;

public class JoinVO {
	
	private String uname;
	private String uid;
	private String upw;
	private String uemail;
	private String ugender;
	private int address1;
	private String address2;
	private String address3;
	private String ubirth;
	private String uphone;
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getUpw() {
		return upw;
	}
	public void setUpw(String upw) {
		this.upw = upw;
	}
	public String getUemail() {
		return uemail;
	}
	public void setUemail(String uemail) {
		this.uemail = uemail;
	}
	public String getUgender() {
		return ugender;
	}
	public void setUgender(String ugender) {
		this.ugender = ugender;
	}
	public int getAddress1() {
		return address1;
	}
	public void setAddress1(int address1) {
		this.address1 = address1;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public String getAddress3() {
		return address3;
	}
	public void setAddress3(String address3) {
		this.address3 = address3;
	}
	public String getUbirth() {
		return ubirth;
	}
	public void setUbirth(String ubirth) {
		this.ubirth = ubirth;
	}
	public String getUphone() {
		return uphone;
	}
	public void setUphone(String uphone) {
		this.uphone = uphone;
	}
	@Override
	public String toString() {
		return "JoinVO [uname=" + uname + ", uid=" + uid + ", upw=" + upw + ", uemail=" + uemail + ", ugender="
				+ ugender + ", address1=" + address1 + ", address2=" + address2 + ", address3=" + address3 + ", ubirth="
				+ ubirth + ", uphone=" + uphone + "]";
	}

	
}
