package com.chongxue.action;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import com.chongxue.md5.ParseMD5;
import com.chongxue.po.User;
import com.chongxue.service.UserService;
import com.opensymphony.xwork2.ActionSupport;

public class Register extends ActionSupport{

	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
	private String repassword;
	private String nickname;
	private String question;
	private String answer;
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

	public String getRepassword() {
		return repassword;
	}

	public void setRepassword(String repassword) {
		this.repassword = repassword;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String execute() throws Exception {
		//封装一个user对象
		User user = new User();
		user.setUsername(username);
		user.setPassword(ParseMD5.parseStrToMd5L32(password + username));
		user.setNickname(nickname);
		user.setQuestion(question);
		user.setAnswer(ParseMD5.parseStrToMd5L32(question + answer));
		HttpServletRequest request = ServletActionContext.getRequest();
		if(userService.registerUser(user)) {
			request.setAttribute("url", "login.jsp");
			request.setAttribute("info", "注册成功");
			request.setAttribute("blogtitle", "知行博客");
			request.setAttribute("idiograph","知而行 行必至");
			return SUCCESS;
		} else {
			request.setAttribute("url", "register.jsp");
			request.setAttribute("info", "注册失败");
			return ERROR;
		}
	}
	
}


