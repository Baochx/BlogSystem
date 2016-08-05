package com.chongxue.po;

import java.util.Date;

public class Dianjiliang {
	
	private int Id; //点击量编号，所有文章的点击量情况都设计在一个表里
	private int AId; //点击文章id
	private String ip; //点击IP
	private Date time; //点击时间
	
	public int getId() {
		return Id;
	}
	
	public void setId(int id) {
		Id = id;
	}
	
	public int getAId() {
		return AId;
	}
	
	public void setAId(int id) {
		AId = id;
	}
	
	public String getIp() {
		return ip;
	}
	
	public void setIp(String ip) {
		this.ip = ip;
	}
	
	public Date getTime() {
		return time;
	}
	
	public void setTime(Date time) {
		this.time = time;
	}
	
	
}
