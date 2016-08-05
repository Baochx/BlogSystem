package com.chongxue.dao;

import java.util.List;
import com.chongxue.fenye.Page;
import com.chongxue.po.Article;

public interface ArticleDAO {
	
	public void add(Article article); //���沩������
	public void delete(Article article); //��idɾ������
	//public void update(Article article) //��������
	public int queryAllCount(); //��ȡ������(�����û������)��Ŀ
	public int queryUserAllCount(String username); //��ȡĳһ�û�������
	public List<Article> queryUserAll(String username); //��ȡĳһ�û��������·���һ��List�����в�����
	public Article queryById(int id); //��id��ѯ�����һƪ����
	public List<Article> queryByPage(String username,Page page); //����ҳ��Ϣ��ѯ�û������¼�¼��
	public List<Article> queryAllByPage(Page page); //����ҳ��Ϣ��ѯ�����û������¼�¼
	

}

