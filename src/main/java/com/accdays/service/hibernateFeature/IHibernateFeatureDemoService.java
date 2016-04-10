package com.accdays.service.hibernateFeature;

import com.accdays.model.Group;
import com.accdays.model.User;

public interface IHibernateFeatureDemoService {

	/**
	 * hibernate同时保存多个对象
	 * @Description
	 * @author hedong
	 * @date 2013-7-21 下午3:35:10
	 * @modifyNote
	 */
	void saveUnitObj();

	void saveGroup(Group group);

	void saveUser(User user);

	void deleGroup(Group group);

	void deleUser(User user);

	Group getGroup(Long id);

	User getUser(Long id);

}
