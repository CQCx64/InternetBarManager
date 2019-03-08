package com.ibm.entity;

import java.util.Date;

public class User {
	
	private int id;
	private String name;
	private String sex;
	private int age;
	private Date registerdate;
	private String idnumber;
	private String phone;
	private Date lastdate;
	private int money;
	private int canuse;
	
	
	
	public User(int id) {
		super();
		this.id = id;
	}

	public User(String name, String sex, int age, Date registerdate, String idnumber, String phone,
			int money) {
		super();
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.registerdate = registerdate;
		this.idnumber = idnumber;
		this.phone = phone;
		this.money = money;
	}
	
	public User(int id, String name, String sex, int age, Date registerdate, String idnumber, String phone, int money) {
		super();
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.registerdate = registerdate;
		this.idnumber = idnumber;
		this.phone = phone;
		this.money = money;
	}
	
	public User(int id, String name, String sex, int age, Date registerdate, String idnumber, String phone,
			Date lastdate, int money) {
		super();
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.registerdate = registerdate;
		this.idnumber = idnumber;
		this.phone = phone;
		this.lastdate = lastdate;
		this.money = money;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Date getRegisterdate() {
		return registerdate;
	}
	public void setRegisterdate(Date registerdate) {
		this.registerdate = registerdate;
	}
	public String getIdnumber() {
		return idnumber;
	}
	public void setIdnumber(String idnumber) {
		this.idnumber = idnumber;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Date getLastdate() {
		return lastdate;
	}
	public void setLastdate(Date lastdate) {
		this.lastdate = lastdate;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}

	public int getCanuse() {
		return canuse;
	}

	public void setCanuse(int canuse) {
		this.canuse = canuse;
	}

	
	
}
