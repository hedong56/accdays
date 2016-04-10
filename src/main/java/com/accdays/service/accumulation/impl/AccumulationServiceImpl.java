package com.accdays.service.accumulation.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.accdays.dao.accumulation.IAccumulationDao;
import com.accdays.model.User;
import com.accdays.service.accumulation.IAccumulationService;

@Service
public class AccumulationServiceImpl implements IAccumulationService {

	@Resource
	private IAccumulationDao accumulationDao;
	
//	//RMI
//	@Resource(name="userInfoRMIService")
//	private IUserInfoService userInfoService;
//	
//	//WebService
//	@Resource(name="webServiceclient")
//	private HelloWorld helloWorld;
	
	
	@Override
	public List<User> findAllPersonInfo() {
		return accumulationDao.findAllPersonInfo();
	}
	@Override
	public void savePersonInfo() {
		User personInfo=new User();
		personInfo.setName("王五");
		personInfo.setBithday(new Date());
		personInfo.setAddress("湖北");
		accumulationDao.savePersonInfo(personInfo);
	}
	@Override
	public User getPersonInfo(Long id) {
		return accumulationDao.getPersonInfo(id);
	}

}
