package com.practice.strings;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

//Avoid examining the entire key. 
//
public class Trie<Value> {
	private static final int R = 256;
	private Node root = new Node();
	
	private static class Node{
		private Object value;
		private Node[] next = new Node[R];
	}
	
	public void put(String key, Value val){
		root = put(root, key, val, 0);
	}
	
	private Node put(Node x, String key, Value val, int d){
		if(x == null) x = new Node();
		if(d == key.length()) {
			x.value = val;
			return x;
		}
		char c = key.charAt(d);
		x.next[c] = put(x.next[c], key, val, d + 1);
		return x;
	}
	
	public Node get(String key){
		return get(root, key, 0);
	}
	private Node get(Node x, String key, int d){
		if(x == null) return null;
		if(d == key.length()) return x;
		return get(x.next[key.charAt(d)], key, d + 1);
		
	}
	
	public Queue<String> prefixMatch(String str){
		Node x = get(root, str, 0);
		if(x == null) return null;
		Queue<String> result = new LinkedList<String>();
		 sorted(x, str, result);
		 return result;
	}
	
	
	public Queue<String> sorted(){
		Queue<String> result = new LinkedList<>();
		sorted(root, "", result);
		return result;
	}
	
	private void sorted(Node x, String prefix, Queue<String> q){
		if(x == null) return;
		if(x.value != null) q.add(prefix);
		for(char c = 0; c < R; c++)
			sorted(x.next[c], prefix + c, q);
	}
	
	public Stack<String> decSort(){
		Stack<String> result = new Stack<>();
		decSort(root, "", result);
		return result;
	}
	
	private void decSort(Node x, String prefix, Stack<String> q){
		if(x == null) return;
		if(x.value != null) q.add(prefix);
		for(char c = 0; c < R; c++)
			decSort(x.next[c], prefix + c, q);
	}
	
	//Longest Prefix
	
	public String longestPrefix(String query){
		int length = search(root, query, 0,0);
		return query.substring(0, length);
	}
	
	private int search(Node x, String query, int d, int length){
		if(x == null) return length;
		if(x.value != null) length = d;
		if(d == query.length()) return length;
		char c = query.charAt(d);
		return search(x.next[c], query, d + 1, length);
	}
	
	
	
	
	
}
