package com.accdays.rmi.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.accdays.dao.accumulation.IAccumulationDao;
import com.accdays.model.User;
import com.accdays.rmi.IUserInfoService;

//@Service 如果不写"";则bean的name默认是类名称第一个字母小写
@Service("userInfoService")
public class UserInfoServiceImpl implements IUserInfoService {
	
	//注意不写name也是按类型注入
		@Resource
		private IAccumulationDao accumulationDao;
		
		/**
		 * 根据userId查询单个用户
		 * @author hedong
		 * @date 2013-9-12 下午9:54:35
		 * @modifyNote
		 * @param userId
		 * @return
		 */
		@Override
		public User getUserById(Long userId){
			return accumulationDao.getPersonInfo(userId);
		}
		
		/**
		 * 根据userName查询用户
		 * @author hedong
		 * @date 2013-9-12 下午11:39:10
		 * @modifyNote
		 * @param userName
		 * @return
		 */
		@Override
		public List<User> findUserByName(String userName) {
			List<User> us=accumulationDao.findUserByName(userName);
			return us;
		}
		
		/**
		 * 根据userIds查询用户集合
		 * @Description
		 * @author hedong
		 * @date 2013-9-12 下午10:04:11
		 * @modifyNote 
		 * @param userIds
		 * @return
		 */
		@Override
		public List<User> findUserByIds(List<Long> userIds){
			return accumulationDao.findUserByIds(userIds);
		}
}
