package com.chongxue.po;

import java.util.Date;

public class Article {
	
	private int id; //文章编号，所有发表的文章都设计在一个表之中
	private String title; 
	private String content;
	private String username;
	private Date date; //文章发表日期
	private int hasread; //统计评论数
	 
	public int getHasread() {
		return hasread;
	}
	
	public void setHasread(int hasread) {
		this.hasread = hasread;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
}
