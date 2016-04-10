package com.accdays.dao.hibernateFeature.imp;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.accdays.dao.hibernateFeature.IHibernateFeatureDemoDao;
import com.accdays.model.Group;
import com.accdays.model.User;

@Repository("hibernateFeatureDao")
public class HibernateFeatureDemoDaoImpl implements IHibernateFeatureDemoDao {

	@Resource
	private SessionFactory sessionFactory;
	@Override
	public void saveGroup(Group group) {
		sessionFactory.getCurrentSession().save(group);
	}

	@Override
	public void saveUser(User user) {
		sessionFactory.getCurrentSession().save(user);
	}
	
	
	@Override
	public void deleGroup(Group group) {
		sessionFactory.getCurrentSession().delete(group);
	}

	@Override
	public void deleUser(User user) {
		sessionFactory.getCurrentSession().delete(user);
	}
	
	@Override
	public Group getGroup(Long id) {
		return (Group)sessionFactory.getCurrentSession().get(Group.class,id);
	}

	@Override
	public User getUser(Long id) {
		return (User)sessionFactory.getCurrentSession().get(User.class,id);
	}
	
	

}
