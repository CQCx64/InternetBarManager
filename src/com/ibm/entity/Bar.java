package com.ibm.entity;

public class Bar {
	private int bid;
	private String bname;
	private String baddress;
	private String x;
	private String y;
	private String phone;
	
	public Bar() {
		super();
	}

	public Bar(int bid, String bname, String baddress) {
		super();
		this.bid = bid;
		this.bname = bname;
		this.baddress = baddress;
	}
	
	public Bar(int bid, String bname, String baddress, String x, String y,String phone) {
		super();
		this.bid = bid;
		this.bname = bname;
		this.baddress = baddress;
		this.x = x;
		this.y = y;
		this.phone = phone;
	}

	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public String getBname() {
		return bname;
	}
	public void setBname(String bname) {
		this.bname = bname;
	}
	public String getBaddress() {
		return baddress;
	}
	public void setBaddress(String baddress) {
		this.baddress = baddress;
	}

	public String getX() {
		return x;
	}

	public void setX(String x) {
		this.x = x;
	}

	public String getY() {
		return y;
	}

	public void setY(String y) {
		this.y = y;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
}
