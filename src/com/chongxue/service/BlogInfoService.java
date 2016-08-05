package com.chongxue.service;

import com.chongxue.po.BlogInfo;

public interface BlogInfoService {

	public void setBlogInfo(BlogInfo blogInfo); //设置博客个性化内容
	public BlogInfo getBlogInfo(String name); //获得博客个性化内容

}

