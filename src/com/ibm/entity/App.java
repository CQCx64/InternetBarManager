package com.ibm.entity;

public class App {
	private int appid;
	private String appname;
	private String icon;
	private String url;
	private int group;
	
	public App(int appid, String appname, String icon, String url,int group) {
		super();
		this.appid = appid;
		this.appname = appname;
		this.icon = icon;
		this.url = url;
		this.group = group;
	}
	
	public int getAppid() {
		return appid;
	}
	public void setAppid(int appid) {
		this.appid = appid;
	}
	public String getAppname() {
		return appname;
	}
	public void setAppname(String appname) {
		this.appname = appname;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}

	public int getGroup() {
		return group;
	}

	public void setGroup(int group) {
		this.group = group;
	}
	
}
