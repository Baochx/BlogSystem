package com.chongxue.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;



public class Exit extends ActionSupport {
	
	private static final long serialVersionUID = 1L;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public String execute() throws Exception {
		
		Map session = ActionContext.getContext().getSession(); 
		session.put("username", null);
		session.put("blogtitle", null);
		session.put("idiograph", null);
		HttpServletRequest request = ServletActionContext.getRequest(); //获得request
		request.setAttribute("url", "../login.jsp"); 
		request.setAttribute("info", "退出成功"); 
		return SUCCESS;
		
	}
}
