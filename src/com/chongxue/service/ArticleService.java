package com.chongxue.service;

import java.util.List;



import com.chongxue.fenye.Page;

import com.chongxue.fenye.Result;

import com.chongxue.po.Article;

public interface ArticleService {
	
	public void addArticle(Article article); //保存文章
	public void deleteArticle(Article article); //删除文章
	public List<Article> showUserAllArticle(String username); //取出用户所有的文章
	public Result showUserArticleByPage(String username,Page page); //分页显示用户文章
	public Result showArticleByPage(Page page); //分页显示全部文章
	public Article showArticle(int id); //根据文章编号来显示文章
	public int getCritiqueCount(int AId); //获得文章评论数

}

