package com.accdays.dao.accumulation;

import java.util.List;

import com.accdays.model.User;

public interface IAccumulationDao {

	List<User> findAllPersonInfo();

	void savePersonInfo(User personInfo);

	User getPersonInfo(Long id);

	List<User> findUserByIds(List<Long> userIds);

	List<User> findUserByName(String userName);

}
