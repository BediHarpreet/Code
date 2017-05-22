package com.practice.strings;

public class TrieTest {
	private static final int R = 256;
	private Node root = new Node();
	
	public static class Node{
		boolean isword;
		Node[] next = new Node[R];
	}
	
	public void put(String str){
		root = put(root, str, 0);
	}
	
	private Node put(Node node, String str, int length){
		if(node == null) node = new Node();
		if(length == str.length() - 1) {
			node.isword = true;
			return node;
		}
		node.next[str.charAt(length)] = put(node.next[str.charAt(length)], str,length + 1);
		return node;
		
	}
	
	public boolean contains(String str){
		return contains(root, str, 0);
	}
	
	private boolean contains(Node node, String str, int length){
		if(node == null) return false;
		if(length == str.length() - 1) {
			if(node.isword) return true;
			return false;
		} return contains(node.next[str.charAt(length)], str, length + 1);
	}

}
