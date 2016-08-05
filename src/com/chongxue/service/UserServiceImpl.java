package com.chongxue.service;

import com.chongxue.dao.UserDAO;

import com.chongxue.po.User;

public class UserServiceImpl implements UserService {

	private UserDAO userDAO;
	
	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	
	public boolean registerUser(User user) {
		//判断用户是否存在
		if(userDAO.queryByID(user.getUsername()) != null) {
			//System.out.println("该用户名已经存在！");
			return false;
		} else {
			userDAO.add(user);
			return true;
		}
	}

	public boolean loginUser(User user) {
		//判断用户是否存在
		if(userDAO.queryByID(user.getUsername()) == null) {
			//System.out.println("该用户不存在！");
			return false;
		} else {
			User queryUser = userDAO.queryByID(user.getUsername());
			//判断密码是否正确
			if(queryUser.getPassword().equals(user.getPassword())) {
				return true;
			} else {
				return false;
			}
		}
	}

}

