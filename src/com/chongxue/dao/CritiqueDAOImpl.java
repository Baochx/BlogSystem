package com.chongxue.dao;

import java.sql.SQLException;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import com.chongxue.fenye.Page;
import com.chongxue.po.Critique;

public class CritiqueDAOImpl extends HibernateDaoSupport implements CritiqueDAO {

	public void addCritique(Critique critique) {
		this.getHibernateTemplate().save(critique);
	}

	@SuppressWarnings("unchecked")
	public List<Critique> queryByPage(final int AId, final Page page) {
		return this.getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				Query query = session.createQuery("select cri from Critique cri where cri.AId = ?");
				query.setParameter(0, AId);
				query.setMaxResults(page.getEveryPage()); //设置每页显示多少个，设置多大结果。
				query.setFirstResult(page.getBeginIndex()); //设置起点
				return query.list();
			}
		});
	}


	@SuppressWarnings("rawtypes")
	public int queryCritiqueCount(int AId) {
		List find = this.getHibernateTemplate().find("select count(*) from Critique cri where cri.AId = ?", AId);
		return ((Long)find.get(0)).intValue();
	}

}

