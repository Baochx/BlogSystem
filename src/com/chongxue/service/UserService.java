package com.chongxue.service;

import com.chongxue.po.User;

public interface UserService {

	public boolean registerUser(User user); //用户注册
	public boolean loginUser(User user); //用户登陆

}

