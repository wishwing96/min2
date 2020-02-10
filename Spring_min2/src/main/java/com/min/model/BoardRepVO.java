package com.min.model;

public class BoardRepVO {
	
	private int gdsnum;
	
    private String uid;
    
    private int repnum;
    
    private String repcon;
    
    private String repdata;

	public int getGdsnum() {
		return gdsnum;
	}

	public void setGdsnum(int gdsnum) {
		this.gdsnum = gdsnum;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public int getRepnum() {
		return repnum;
	}

	public void setRepnum(int repnum) {
		this.repnum = repnum;
	}

	public String getRepcon() {
		return repcon;
	}

	public void setRepcon(String repcon) {
		this.repcon = repcon;
	}

	public String getRepdata() {
		return repdata;
	}

	public void setRepdata(String repdata) {
		this.repdata = repdata;
	}

	@Override
	public String toString() {
		return "BoardRepVO [gdsnum=" + gdsnum + ", uid=" + uid + ", repnum=" + repnum + ", repcon=" + repcon
				+ ", repdata=" + repdata + "]";
	}

}
