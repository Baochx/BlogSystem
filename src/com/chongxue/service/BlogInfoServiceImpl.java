package com.chongxue.service;

import com.chongxue.dao.BlogInfoDAO;

import com.chongxue.po.BlogInfo;

public class BlogInfoServiceImpl implements BlogInfoService {

	private BlogInfoDAO blogInfoDAO;

	public BlogInfo getBlogInfo(String username) {
		return blogInfoDAO.get(username);
	}
	
	public void setBlogInfo(BlogInfo blogInfo) {
		blogInfoDAO.save(blogInfo); //ͨ������DAO��������
	}

	public BlogInfoDAO getBlogInfoDAO() {
		return blogInfoDAO;
	}

	public void setBlogInfoDAO(BlogInfoDAO blogInfoDAO) {
		this.blogInfoDAO = blogInfoDAO;
	}

	
	
}

