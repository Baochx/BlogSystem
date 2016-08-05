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
		User user = new User(); //封装一个用户对象;
		user.setUsername(username);
		user.setPassword(ParseMD5.parseStrToMd5L32(password + username));
		HttpServletRequest request = ServletActionContext.getRequest(); //获得request
		
		if(userService.loginUser(user)) {
			request.setAttribute("url", "user/getBlogInfo.action"); //success.jsp界面刷新之后，为展示个性化内容做铺垫;
			request.setAttribute("info", "登录成功"); //设置登录成功信息,success.jsp界面需要;
			//HttpSession session = request.getSession();
			//session.setAttribute("username", username);	
			Map session = ActionContext.getContext().getSession();
			session.put("username", username); //将username保存到session范围中,代表用户已经登录，默认30min失效
			return SUCCESS; 
		} else {
			request.setAttribute("url", "login.jsp"); //登录失败则需要重新登录
			request.setAttribute("info", "登录失败"); //设置登录失败信息
			return ERROR;
		}
	}
	
}

