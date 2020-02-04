package com.min.model;

public class OrderVO {

	private String orderno;
	private String name;
    private String uid;
    private String uaddress;
    private String uphone;
    private int price;
    private String opt;
	public String getOrderno() {
		return orderno;
	}
	public void setOrderno(String orderno) {
		this.orderno = orderno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getUaddress() {
		return uaddress;
	}
	public void setUaddress(String uaddress) {
		this.uaddress = uaddress;
	}
	public String getUphone() {
		return uphone;
	}
	public void setUphone(String uphone) {
		this.uphone = uphone;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getOpt() {
		return opt;
	}
	public void setOpt(String opt) {
		this.opt = opt;
	}
	@Override
	public String toString() {
		return "OrderVO [orderno=" + orderno + ", name=" + name + ", uid=" + uid + ", uaddress=" + uaddress
				+ ", uphone=" + uphone + ", price=" + price + ", opt=" + opt + "]";
	}
	
}
