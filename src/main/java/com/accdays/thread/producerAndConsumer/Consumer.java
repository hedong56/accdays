package com.accdays.thread.producerAndConsumer;

import org.apache.log4j.Logger;

/**
 * 消费者线程
 * @author hedong
 * @date 2016年4月10日 下午5:41:02
 * @modifyNote
 * @version 1.0
 */
public class Consumer extends Thread {
	
	static Logger logger=Logger.getLogger(Consumer.class);

	private ShareArea sharedObject;
	
	public Consumer(ShareArea sharedObject) {
		super();
		this.sharedObject = sharedObject;
	}



	@Override
	public void run() {
		int value;
		do{
			
			try {
				Thread.sleep((int) (Math.random() * 3000));
			} catch (Exception e) {
				logger.error(e);
			}
			
			value=sharedObject.getSharedInt();
//			logger.info("消费："+value);
			
		}while(value!=10);
		
	}
	
	
	
}
