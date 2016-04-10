package com.accdays.cxf.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.jws.WebService;

import org.springframework.stereotype.Service;

import com.accdays.cxf.IUserInfoCXFService;
import com.accdays.dao.accumulation.IAccumulationDao;
import com.accdays.model.User;

@Service
@WebService(endpointInterface="com.accdays.cxf.IUserInfoCXFService")//接口的全路径
public class UserInfoCXFServiceImpl implements IUserInfoCXFService {

	@Resource
	private IAccumulationDao accumulationDao;
	
	@Override
	public List<User> findUsersByName(String name) {
		return accumulationDao.findUserByName(name);
	}

}
