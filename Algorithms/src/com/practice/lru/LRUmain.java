package com.practice.lru;

import java.util.Iterator;

public class LRUmain {

	public static void main(String[] args) {
		LRUCache cache = new LRUCache(5);
		cache.put(1, 43212);
		cache.put(2, 43212);
		cache.put(3, 43212);
		cache.put(4, 43212);
		cache.put(5, 43212);
		cache.get(1);
		cache.put(6, 32323);
		Iterator iterate = cache.entrySet().iterator();
		while(iterate.hasNext())
			System.out.println(iterate.next());

	}

}
