package com.accdays.service.accumulation;

import java.util.List;

import com.accdays.model.User;

public interface IAccumulationService {

	List<User> findAllPersonInfo();

	void savePersonInfo();
	
	User getPersonInfo(Long id);


}
