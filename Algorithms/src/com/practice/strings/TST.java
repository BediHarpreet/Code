package com.practice.strings;

public class TST<Value>{
	private Node root = new Node();
	
	private class Node{
		private Value val;
		private char c;
		private Node left, right, center;
	}
	
	
	public void put(String key, Value val){
		root = put(root, key, val, 0);
	}
	
	public Node put(Node x, String key, Value val, int d){
		
		char a = key.charAt(d);
		if(x == null) {
			x = new Node();
			x.c = a;
		}
		if(d == key.length() - 1){
			x.val = val;
			return x;
		}
		if(x.c > a) x.left = put(x.left,key, val, d);
		else if(x.c == a) x.center = put(x.center, key, val, d);
		else if(x.c < a) x.right = put(x.right, key, val, d + 1);
		else x.val = val;  
		return x;
	}
}
