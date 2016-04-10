package com.accdays.thread;

/**
 * 栈
 * @author hedong
 * @date 2016年4月10日 下午4:14:48
 * @modifyNote
 * @version 1.0
 */
public class Stack {
	
	int idx=0;
	
	char[] data=new char[10];
	
	//保存数据
	public void push(char c){
		synchronized (this) {
			data[idx]=c;
			idx++;
		}
	}

	//取数据
	public synchronized char pop(){
		idx--;
		return data[idx];
	}
	
}