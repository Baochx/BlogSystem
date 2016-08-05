package com.chongxue.dao;

import java.util.List;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import com.chongxue.po.BlogInfo;

public class BlogInfoDAOImpl extends HibernateDaoSupport implements BlogInfoDAO{

	@SuppressWarnings("rawtypes")
	public BlogInfo get(String username) {
		List list = this.getHibernateTemplate().find("select bloginfo from BlogInfo bloginfo where bloginfo.username=?", username);
		if(list.size() == 0) {
			return null; //�û���û�е�¼���������ʱ���ǿ����ڲ�����ҳ�鿴���µ�;
		} else {
			return (BlogInfo)list.get(0); //����û��Ѿ���¼���򷵻�����Ի�����;
		}
	}
	
	public void save(BlogInfo info) {
		/*List list = this.getHibernateTemplate().find("select bloginfo from BlogInfo bloginfo where bloginfo.username=?", info.getUsername());
		if(list.size() == 0) {
			this.getHibernateTemplate().save(info); //�״������򱣴�;
		} else {
			this.getHibernateTemplate().update(info); //����Ѿ����ù��������;
		}*/
		this.getHibernateTemplate().saveOrUpdate(info);
	}
	
}
