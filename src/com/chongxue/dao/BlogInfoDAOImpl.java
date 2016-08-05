package com.chongxue.dao;

import java.util.List;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import com.chongxue.po.BlogInfo;

public class BlogInfoDAOImpl extends HibernateDaoSupport implements BlogInfoDAO{

	@SuppressWarnings("rawtypes")
	public BlogInfo get(String username) {
		List list = this.getHibernateTemplate().find("select bloginfo from BlogInfo bloginfo where bloginfo.username=?", username);
		if(list.size() == 0) {
			return null; //用户还没有登录的情况，此时他是可以在博客首页查看文章的;
		} else {
			return (BlogInfo)list.get(0); //如果用户已经登录，则返回其个性化内容;
		}
	}
	
	public void save(BlogInfo info) {
		/*List list = this.getHibernateTemplate().find("select bloginfo from BlogInfo bloginfo where bloginfo.username=?", info.getUsername());
		if(list.size() == 0) {
			this.getHibernateTemplate().save(info); //首次设置则保存;
		} else {
			this.getHibernateTemplate().update(info); //如果已经设置过，则更新;
		}*/
		this.getHibernateTemplate().saveOrUpdate(info);
	}
	
}
