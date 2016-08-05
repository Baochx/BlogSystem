package com.chongxue.dao;

import java.util.List;
import com.chongxue.po.User;

public interface UserDAO {

	public void add(User user); //����û�
	public void delete(User user); //ɾ���û�
	public void update(User user); //�����û�,���ø�����Ϣʱ���õ�
	@SuppressWarnings("rawtypes")
	public List queryAll(); //��ѯ�����û�
	public User queryByID(String username); //��id��ѯ�û�

}

