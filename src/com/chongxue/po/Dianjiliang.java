package com.chongxue.po;

import java.util.Date;

public class Dianjiliang {
	
	private int Id; //�������ţ��������µĵ��������������һ������
	private int AId; //�������id
	private String ip; //���IP
	private Date time; //���ʱ��
	
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
