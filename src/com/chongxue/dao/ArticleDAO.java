package com.chongxue.dao;

import java.util.List;
import com.chongxue.fenye.Page;
import com.chongxue.po.Article;

public interface ArticleDAO {
	
	public void add(Article article); //保存博客文章
	public void delete(Article article); //按id删除文章
	//public void update(Article article) //更新文章
	public int queryAllCount(); //获取总文章(所有用户发表的)数目
	public int queryUserAllCount(String username); //或取某一用户文章数
	public List<Article> queryUserAll(String username); //获取某一用户所有文章放在一个List对象中并返回
	public Article queryById(int id); //按id查询具体的一篇文章
	public List<Article> queryByPage(String username,Page page); //按分页信息查询用户的文章记录，
	public List<Article> queryAllByPage(Page page); //按分页信息查询所有用户的文章记录
	

}

