package com.accdays.basePoints;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import com.accdays.model.User;

public class ListRemoveTest {

	/**
	 * 循环删除list中的对象
	 * @Description
	 * @author hedong
	 * @date 2013-9-11 上午11:15:32
	 * @modifyNote 
	 * @param args
	 */
	public static void main(String[] args) {
		List<User> allUsers=tempUtil.getAllListUsers();
		List<User> subUsers=tempUtil.getSubListUsers();
		System.out.println("初始时length:"+allUsers.size());//6
		
		Set<User> userSet=new HashSet<User>();
		userSet.addAll(allUsers);
		allUsers.clear();
		allUsers.addAll(userSet);
		System.out.println("去重复后length:"+allUsers.size());//还是6,说明Id相同，并不是对象相等;set可以去除对象equals的元素
		
		Iterator<User> allUserIterator = allUsers.iterator();  
		while(allUserIterator.hasNext()){  
			User allUser = allUserIterator.next();  
			for (User subUser : subUsers) {
				if(allUser.getId().equals(subUser.getId())){
					allUserIterator.remove();
				}
			}
		}
		
		System.out.println("删除后length:"+allUsers.size());
		for (User user : allUsers) {
			System.out.println(user.getId());
		}
	}

}

class tempUtil{
	public static List<User> getAllListUsers(){
		List<User> users=new ArrayList<User>();
		User u1=new User();
		u1.setId(1L);
		User u2=new User();
		u2.setId(2L);
		User u3=new User();
		u3.setId(3L);
		User u4=new User();
		u4.setId(4L);
		User u5=new User();
		u5.setId(5L);
		User u6=new User();
		u6.setId(2L);
		users.add(u1);
		users.add(u2);
		users.add(u3);
		users.add(u4);
		users.add(u5);
		users.add(u6);
		return users;
	}
	
	public static List<User> getSubListUsers(){
		List<User> users=new ArrayList<User>();
		User u2=new User();
		u2.setId(2L);
		User u4=new User();
		u4.setId(4L);
		users.add(u2);
		users.add(u4);
		return users;
	}
}
