package com.min.model;

public class OrderVO {

	private String orderno;
	private String name;
    private String uid;
    private int address1;
    private String address2;
    private String address3;
    private String uphone;
    private int price;
    private int stock;
    private int state;
    private String msg;
    private int upoint;
    private int point;
    private int cartnum;
    
    
	public int getCartnum() {
		return cartnum;
	}
	public void setCartnum(int cartnum) {
		this.cartnum = cartnum;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	public int getUpoint() {
		return upoint;
	}
	public void setUpoint(int upoint) {
		this.upoint = upoint;
	}
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
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	@Override
	public String toString() {
		return "OrderVO [orderno=" + orderno + ", name=" + name + ", uid=" + uid + ", address1=" + address1
				+ ", address2=" + address2 + ", address3=" + address3 + ", uphone=" + uphone + ", price=" + price
				+ ", stock=" + stock + ", state=" + state + ", msg=" + msg + ", upoint=" + upoint + ", point=" + point
				+ ", cartnum=" + cartnum + "]";
	}
	
    

	
}
