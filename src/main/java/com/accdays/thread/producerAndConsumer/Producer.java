package com.accdays.thread.producerAndConsumer;

import org.apache.log4j.Logger;

/**
 * 生产者线程
 * @author hedong
 * @date 2016年4月10日 下午5:42:14
 * @modifyNote
 * @version 1.0
 */
public class Producer extends Thread {

	static Logger logger=Logger.getLogger(Producer.class);

	private ShareArea sharedObject;
	
	public Producer(ShareArea sharedObject) {
		super();
		this.sharedObject = sharedObject;
	}

	@Override
	public void run() {
		
		for(int count=1;count<=10;count++){
			
			try {
				Thread.sleep((int) (Math.random() * 3000));
			} catch (Exception e) {}
			
			sharedObject.setSharedInt(count);
			
//			logger.info("生产："+count);
			
		}
		
	}
	
	
	
	
}
