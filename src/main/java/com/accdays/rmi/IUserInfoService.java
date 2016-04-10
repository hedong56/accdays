package com.accdays.rmi;

import java.rmi.RemoteException;
import java.util.List;

import com.accdays.model.User;

/**
 * 服务器端接口必须继承Remote，且必须抛出RemoteException
 * @author hedong
 * @date 2013-9-12 下午9:57:21
 * @modifyNote
 * @version 1.0
 */
public interface IUserInfoService{

	/**
	 * 根据userId查询用户
	 * @Description
	 * @author hedong
	 * @date 2013-9-12 下午10:05:24
	 * @modifyNote 
	 * @param userId
	 * @return
	 * @throws RemoteException
	 */
	public abstract User getUserById(Long userId);
	
	/**
	 * 根据userName查询用户集合
	 * @Description
	 * @author hedong
	 * @date 2013-9-12 下午10:05:24
	 * @modifyNote 
	 * @param userName
	 * @return
	 * @throws RemoteException
	 */
	public abstract List<User> findUserByName(String userName);

	/**
	 * 根据userIds查询用户集合
	 * @Description
	 * @author hedong
	 * @date 2013-9-12 下午10:04:55
	 * @modifyNote 
	 * @param userIds
	 * @return
	 * @throws RemoteException
	 */
	public abstract List<User> findUserByIds(List<Long> userIds);
}