package com.accdays.thread.producerAndConsumer;

import org.apache.log4j.Logger;

public class ShareArea {
	
	static Logger logger=Logger.getLogger(ShareArea.class);
	
	//共享的整数
	private int sharedInt=-1;
	//条件变量
	private boolean writeable=true;
	
	public synchronized int getSharedInt() {
		
		//如果只能生产，则消费者等待
		while(writeable){
			try{
				wait();
			}catch(Exception e){}
		}
		
		writeable=true;
		
		notify();
		logger.info("消费："+sharedInt);
		return sharedInt;
	}

	public synchronized void setSharedInt(int count) {
		
		//当不被允许写入时，就等待
		while(!writeable){
			try{
				wait();
			}catch(Exception e){}
		}
		//生产一个数据
		sharedInt=count;
		
		logger.info("生产："+sharedInt);
		
		//消费者消费前，生产者不能再写另外一个值
		writeable=false;
		//唤醒等待的资源
		notify();
		
	}

}
