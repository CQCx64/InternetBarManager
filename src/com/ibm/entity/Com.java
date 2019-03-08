package com.ibm.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Com {

	private int id;
	private int status;
	private int time;
	private User user;
	private Pos pos;
	private Date starttime;
	private int call;

	public Com() {
		super();
	}

	public Com(int id, int status, int time) {
		super();
		this.id = id;
		this.status = status;
		this.time = time;
	}

	public Com(int id, int status, int time, User user, Pos pos) {
		super();
		this.id = id;
		this.status = status;
		this.time = time;
		this.user = user;
		this.pos = pos;
	}

	public Com(int id, int status, int time, Date starttime) {
		super();
		this.id = id;
		this.status = status;
		this.time = time;
		this.starttime = starttime;
	}

	public Date getStarttime() {
		return starttime;
	}

	public void setStarttime(Date starttime) {
		this.starttime = starttime;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Pos getPos() {
		return pos;
	}

	public void setPos(Pos pos) {
		this.pos = pos;
	}

	public int getCall() {
		return call;
	}

	public void setCall(int call) {
		this.call = call;
	}



}
