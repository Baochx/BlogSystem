package com.chongxue.dao;

import java.util.List;
import com.chongxue.po.User;

public interface UserDAO {

	public void add(User user); //添加用户
	public void delete(User user); //删除用户
	public void update(User user); //更新用户,重置个人信息时能用到
	@SuppressWarnings("rawtypes")
	public List queryAll(); //查询所有用户
	public User queryByID(String username); //按id查询用户

}

