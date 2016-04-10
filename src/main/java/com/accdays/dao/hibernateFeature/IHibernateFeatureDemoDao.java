package com.accdays.dao.hibernateFeature;

import com.accdays.model.Group;
import com.accdays.model.User;

public interface IHibernateFeatureDemoDao {

	void saveGroup(Group group);

	void saveUser(User user);

	void deleGroup(Group group);

	void deleUser(User user);

	Group getGroup(Long id);

	User getUser(Long id);

}
