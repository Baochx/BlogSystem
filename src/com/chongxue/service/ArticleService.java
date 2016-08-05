package com.chongxue.service;

import java.util.List;



import com.chongxue.fenye.Page;

import com.chongxue.fenye.Result;

import com.chongxue.po.Article;

public interface ArticleService {
	
	public void addArticle(Article article); //��������
	public void deleteArticle(Article article); //ɾ������
	public List<Article> showUserAllArticle(String username); //ȡ���û����е�����
	public Result showUserArticleByPage(String username,Page page); //��ҳ��ʾ�û�����
	public Result showArticleByPage(Page page); //��ҳ��ʾȫ������
	public Article showArticle(int id); //�������±������ʾ����
	public int getCritiqueCount(int AId); //�������������

}

