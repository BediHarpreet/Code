package com.practice.lru;

import java.util.Map.Entry;
import java.util.LinkedHashMap;

public class LRUCache extends LinkedHashMap<Integer, Object>{
	
	private int capacity;
	
	public LRUCache(int capacity){
		super(capacity, 1.0f, true);
		this.capacity = capacity;
	}
	
	protected boolean removeEldestEntry(Entry entry){
		return (size() > this.capacity);
	}
}
