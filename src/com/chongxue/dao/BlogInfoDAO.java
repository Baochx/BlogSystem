package com.chongxue.dao;

import com.chongxue.po.BlogInfo;

public interface BlogInfoDAO {

	public void save(BlogInfo info); //���ø��Ի�����
	public BlogInfo get(String username); //��ø��Ի�����
	
}

