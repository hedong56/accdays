package com.accdays.memcached;

import java.util.Date;

import com.danga.MemCached.MemCachedClient;
import com.danga.MemCached.SockIOPool;
import com.schooner.MemCached.MemcachedItem;

public final class MemcachedUtil {

	private MemcachedUtil() {}
	
	private static MemCachedClient mcc = new MemCachedClient();

	private static MemcachedUtil memcachedUtil = new MemcachedUtil(); 
	
	// 设置与缓存服务器的连接池  
    static {  
        // 服务器列表和其权重  
        String[] servers = {"192.168.43.132:11211"};// Ip地址和端口号  
        // 权重  
        Integer[] weights = {3};  
          
        // 获取socket连接池的实例对象  
        SockIOPool pool = SockIOPool.getInstance();  
          
        // 设置服务器信息  
        pool.setServers(servers);  
        pool.setWeights(weights);  
          
        // 设置初始连接数、最小和最大连接数以及最大处理时间  
        pool.setInitConn(5);  
        pool.setMinConn(5);  
        pool.setMaxConn(250);  
        pool.setMaxIdle(1000 * 60 * 60 * 6);  
          
        // 设置主线程的睡眠时间  
        pool.setMaintSleep(30);  
          
        // 设置TCP的参数，连接超时等  
        pool.setNagle(false);  
        pool.setSocketTO(3000);  
        pool.setSocketConnectTO(0);  
          
        // 初始化连接池  
        pool.initialize();  
          
        // 压缩设置，超过指定大小（单位为K）的数据都会被压缩  
        // mcc.setCompressEnable(true);  
        // mcc.setCompressThreshold(64 * 1024);  
          
        mcc.setPrimitiveAsString(true);// 设置序列化  
    }  
    
    public static MemcachedUtil getInstance() {  
        return memcachedUtil;  
    }  
    
    public boolean add(String key, Object value) {
    	// 不会存入缓存  
        return mcc.add(key, value);
    }
    
    public boolean add(String key, Object value, Date expiry) {  
        // 不会存入缓存  
        return mcc.add(key, value, expiry);  
        // return mcc.set(key, value, expiry);  
    }  
    
    public boolean delete(String key) {  
        return mcc.delete(key);
    }  
    
    public boolean replace(String key, Object value) {  
        return mcc.replace(key, value);  
    }  
    
    public boolean replace(String key, Object value, Date expiry) {  
        return mcc.replace(key, value, expiry);  
    }  
    
    public Object get(String key) {  
        return mcc.get(key);  
    } 
    
    public MemcachedItem gets(String key) {  
        return mcc.gets(key);  
    } 
    
    
    
    
}
