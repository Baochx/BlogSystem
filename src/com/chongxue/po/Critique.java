package com.chongxue.po;

public class Critique {
	
	private int id; //评论编号，所有文章的评论都设计在一个表之中
	private int AId; //所属文章id,用于查询特定文章评论
	private String content; //评论内容
	private String username; //评论者

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAId() {
		return AId;
	}

	public void setAId(int id) {
		AId = id;
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

}
