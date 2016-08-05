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
		//�ж��û��Ƿ����
		if(userDAO.queryByID(user.getUsername()) != null) {
			//System.out.println("���û����Ѿ����ڣ�");
			return false;
		} else {
			userDAO.add(user);
			return true;
		}
	}

	public boolean loginUser(User user) {
		//�ж��û��Ƿ����
		if(userDAO.queryByID(user.getUsername()) == null) {
			//System.out.println("���û������ڣ�");
			return false;
		} else {
			User queryUser = userDAO.queryByID(user.getUsername());
			//�ж������Ƿ���ȷ
			if(queryUser.getPassword().equals(user.getPassword())) {
				return true;
			} else {
				return false;
			}
		}
	}

}

