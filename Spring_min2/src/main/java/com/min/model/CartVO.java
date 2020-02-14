package com.min.model;

public class CartVO {
	
	private int cartnum;
    private String uid;
    private int num;
    private int cartStock;
    private String addDate;
    private String name;
    private int price;
    private String file;
    
	public String getFile() {
		return file;
	}
	public void setFile(String file) {
		this.file = file;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getCartnum() {
		return cartnum;
	}
	public void setCartnum(int cartnum) {
		this.cartnum = cartnum;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getCartStock() {
		return cartStock;
	}
	public void setCartStock(int cartStock) {
		this.cartStock = cartStock;
	}
	public String getAddDate() {
		return addDate;
	}
	public void setAddDate(String addDate) {
		this.addDate = addDate;
	}
	@Override
	public String toString() {
		return "CartVO [cartnum=" + cartnum + ", uid=" + uid + ", num=" + num + ", cartStock=" + cartStock
				+ ", addDate=" + addDate + ", name=" + name + ", price=" + price + ", file=" + file + "]";
	}


}
