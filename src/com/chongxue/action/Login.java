package com.chongxue.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.chongxue.md5.ParseMD5;
import com.chongxue.po.User;
import com.chongxue.service.UserService;

public class Login extends ActionSupport {
	
	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
	private UserService userService;

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
 
	@SuppressWarnings({"rawtypes", "unchecked"})
	public String execute() throws Exception {
		User user = new User(); //��װһ���û�����;
		user.setUsername(username);
		user.setPassword(ParseMD5.parseStrToMd5L32(password + username));
		HttpServletRequest request = ServletActionContext.getRequest(); //���request
		
		if(userService.loginUser(user)) {
			request.setAttribute("url", "user/getBlogInfo.action"); //success.jsp����ˢ��֮��Ϊչʾ���Ի��������̵�;
			request.setAttribute("info", "��¼�ɹ�"); //���õ�¼�ɹ���Ϣ,success.jsp������Ҫ;
			//HttpSession session = request.getSession();
			//session.setAttribute("username", username);	
			Map session = ActionContext.getContext().getSession();
			session.put("username", username); //��username���浽session��Χ��,�����û��Ѿ���¼��Ĭ��30minʧЧ
			return SUCCESS; 
		} else {
			request.setAttribute("url", "login.jsp"); //��¼ʧ������Ҫ���µ�¼
			request.setAttribute("info", "��¼ʧ��"); //���õ�¼ʧ����Ϣ
			return ERROR;
		}
	}
	
}

