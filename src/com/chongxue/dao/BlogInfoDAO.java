package com.chongxue.dao;

import com.chongxue.po.BlogInfo;

public interface BlogInfoDAO {

	public void save(BlogInfo info); //设置个性化内容
	public BlogInfo get(String username); //获得个性化内容
	
}

