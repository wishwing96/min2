package com.min.model;

public class JoinVO {
	
	private String uname;
	private String uid;
	private String upw;
	private String uemail;
	private String ugender;
	private String uaddress;
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
	public String getUaddress() {
		return uaddress;
	}
	public void setUaddress(String uaddress) {
		this.uaddress = uaddress;
	}
	public String getUbirth() {
		return ubirth;
	}
	public String getUphone() {
		return uphone;
	}
	public void setUphone(String uphone) {
		this.uphone = uphone;
	}
	public void setUbirth(String ubirth) {
		this.ubirth = ubirth;
	}
	
	@Override
	public String toString() {
		return "JoinVO [uname=" + uname + ", uid=" + uid + ", upw=" + upw + ", uemail=" + uemail + ", ugender="
				+ ugender + ", uaddress=" + uaddress + ", ubirth=" + ubirth + ", uphone=" + uphone + "]";
	}

}
