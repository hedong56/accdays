package com.accdays.service.hibernateFeature.impl;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.accdays.dao.hibernateFeature.IHibernateFeatureDemoDao;
import com.accdays.model.Group;
import com.accdays.model.User;
import com.accdays.service.hibernateFeature.IHibernateFeatureDemoService;

//@Service 如果不写"";则bean的name默认是类名称第一个字母小写
@Service("hibernateFeatureService")
public class HibernateFeatureDemoServiceImpl implements
		IHibernateFeatureDemoService {
	
	@Resource(name="hibernateFeatureDao")
	private IHibernateFeatureDemoDao hibernateFeatureDao;
	/**
	 * hibernate同时保存多个对象
	 * @author hedong
	 * @date 2013-7-21 下午3:35:35
	 * @modifyNote
	 */
	@Override
	public void saveUnitObj() {
		Group group=new Group();
		group.setName("一组");
		User user=new User();
		user.setName("周三");
		user.setAddress("四川");
		user.setBithday(new Date());
		user.setGroup(group);
		System.out.println(hibernateFeatureDao);
		hibernateFeatureDao.saveGroup(group);
		hibernateFeatureDao.saveUser(user);
		
	}
	
	@Override
	public void saveGroup(Group group){
		hibernateFeatureDao.saveGroup(group);
	}
	
	@Override
	public void saveUser(User user){
		hibernateFeatureDao.saveUser(user);
	}
	
	@Override
	public void deleGroup(Group group) {
		hibernateFeatureDao.deleGroup(group);
	}

	@Override
	public void deleUser(User user) {
		hibernateFeatureDao.deleUser(user);
	}
	
	@Override
	public Group getGroup(Long id) {
		return hibernateFeatureDao.getGroup(id);
	}

	@Override
	public User getUser(Long id) {
		return hibernateFeatureDao.getUser(id);
	}

}
