package com.accdays.dao.accumulation.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.accdays.dao.accumulation.IAccumulationDao;
import com.accdays.model.User;

@Repository
public class AccumulationDaoImpl implements IAccumulationDao {
	
	@Resource
	private SessionFactory sessionFactory;
	@Override
	public List<User> findAllPersonInfo() {
		
		String hql="from User";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();
		
	}
	@Override
	public void savePersonInfo(User personInfo) {
		sessionFactory.getCurrentSession().save(personInfo);
	}
	@Override
	public User getPersonInfo(Long id) {
		String hql="from User where id=:id";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		query.setLong("id", id);
		return (User)query.uniqueResult();
	}
	@Override
	public List<User> findUserByIds(List<Long> userIds) {
		String hql="from User where id in (:userIds)";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		query.setParameterList("userIds", userIds);
		return query.list();
	}
	
	@Override
	public List<User> findUserByName(String userName) {
		String hql="from User where name like:userName";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		query.setString("userName", "%"+userName+"%");
		return query.list();
	}

}
