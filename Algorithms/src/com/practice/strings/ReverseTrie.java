package com.practice.strings;

import java.util.LinkedList;
import java.util.Queue;

public class ReverseTrie<Value> {
	final static int R = 256;
	Node root;
	
	static class Node{
		Object val;
		Node[] next = new Node[R];
	}
	
	public void put(String key, Value val){
		root = put(root, key, val, key.length());
		Queue<Integer> queue = new LinkedList<>();
	}
	
	private Node put(Node x, String key, Value val, int d){
		if(x == null) x = new Node();
		if(d < 0){
			x.val = val;
			return x;
		}
		char c = key.charAt(d);
		x.next[c] = put(x.next[c], key, val, d - 1);
		return x;
	}
	

}

//ab aaaba