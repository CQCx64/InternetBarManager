package com.ibm.entity;

public class Note {
	private int id;
	private String detail;
	private int type;
	
	public Note() {
		super();
	}
	public Note(int id, String detail, int type) {
		super();
		this.id = id;
		this.detail = detail;
		this.type = type;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	
}
