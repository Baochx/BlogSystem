package com.chongxue.dao;

import java.sql.SQLException;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import com.chongxue.fenye.Page;
import com.chongxue.po.Article;

public class ArticleDAOImpl extends HibernateDaoSupport implements ArticleDAO {
	
	public void delete(Article article) {
		this.getHibernateTemplate().delete(article); //删除文章
	}
	
	public void add(Article article) {
		this.getHibernateTemplate().saveOrUpdate(article); //1.更新点击量的时候是update 2.发表新文章的时候是save
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<Article> queryUserAll(String username) {
		List find = this.getHibernateTemplate().find("select art from Article art where art.username = ?", username);
		List<Article> list = find;
		return list;
	}
	
	@SuppressWarnings("rawtypes")
	public Article queryById(int id) {
		List find = this.getHibernateTemplate().find("select art from Article art where art.id = ?", id);
		return (Article)find.get(0);
	}


	@SuppressWarnings("rawtypes")
	public int queryUserAllCount(String username) {
		List find = this.getHibernateTemplate().find("select count(*) from Article art where art.username = ?", username);
		return ((Long)find.get(0)).intValue();
	}
	
	@SuppressWarnings("rawtypes")
	public int queryAllCount() {
		List find = this.getHibernateTemplate().find("select count(*) from Article art");
		return ((Long)find.get(0)).intValue();
	}

	@SuppressWarnings("unchecked")
	public List<Article> queryByPage(final String username, final Page page) {
		return this.getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				Query query = session.createQuery("select art from Article art where art.username = ?");
				query.setParameter(0, username); //设置参数
				query.setMaxResults(page.getEveryPage()); //设置每页显示多少个，设置多大结果。
				query.setFirstResult(page.getBeginIndex()); //设置起点
				return query.list();
			}
		});
	}

	@SuppressWarnings("unchecked")
	public List<Article> queryAllByPage(final Page page) { //首页显示;
		return this.getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				Query query = session.createQuery("select art from Article art order by art.date desc");
				query.setMaxResults(page.getEveryPage()); //设置每页显示多少个，设置多大结果。
				query.setFirstResult(page.getBeginIndex()); //设置起点
				return query.list();
			}
		});
	}

}

