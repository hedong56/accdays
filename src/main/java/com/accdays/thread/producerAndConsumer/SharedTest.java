package com.accdays.thread.producerAndConsumer;

public class SharedTest {

	public static void main(String[] args) {
		ShareArea shareArea=new ShareArea();
		
		Producer producer=new Producer(shareArea);
		Consumer consumer=new Consumer(shareArea);
		
		producer.start();
		consumer.start();
		
	}

}
