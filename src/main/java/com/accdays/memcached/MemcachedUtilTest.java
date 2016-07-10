package com.accdays.memcached;

import com.accdays.model.User;
import com.schooner.MemCached.MemcachedItem;

public class MemcachedUtilTest {
	
	private User user;  
    private MemcachedUtil cache;
	public MemcachedUtilTest() {
		user = new User();  
		user.setId(100L);
		user.setName("张三");
          
        // 缓存对象  
        cache = MemcachedUtil.getInstance();  
        cache.add("user", user);  
          
        // 缓存基本数据  
        cache.add("Your salary", 12345.00);
	}
	
	public static void main(String[] args) {
		new MemcachedUtilTest();
		
		/** 
         * 缓存基本数据 
         */  
        MemcachedUtil cache = MemcachedUtil.getInstance();  
          
        System.out.println("Your salary : " + cache.get("Your salary")); 
        cache.replace("Your salary", 54321);
        System.out.println("Your salary : " + cache.get("Your salary")); 
        cache.delete("Your salary");
        System.out.println("Your salary : " + cache.get("Your salary")); 
        
        User user=(User)cache.get("user");
        System.out.println(user.getId()+","+user.getName());
        
        MemcachedItem memcachedItem=cache.gets("user");
        System.out.println(memcachedItem.casUnique);
        
        
        
//        cache.delete("user");
//        User user2=(User)cache.get("user");
//        if(user2!=null){
//        	System.out.println(user2.getId()+","+user2.getName());
//        }else{
//        	System.out.println("user没有被缓存，已经被删除了");
//        }
        
	}
    
    

}
