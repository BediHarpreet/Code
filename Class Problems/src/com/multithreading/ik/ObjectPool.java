package com.multithreading.ik;

import java.util.Queue;

public class ObjectPool {
	int limit;
	int count;
	Queue<Object> q =new Queue<Object>();

	public ObjectPool(int limit){
		this.limit = limit;
	}
	
	Mutex mutex = new Mutex();
	CV full = new CV();
	
	Object get(){
		Mutex.wait();
		
		while(queueIsEmpty() && limit == count){
			full.wait();
		}
		
		Obj obj;
		if(!queueIsEmpty())
			obj = queue.deque();
	}
}
