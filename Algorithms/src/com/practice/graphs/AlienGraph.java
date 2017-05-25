package com.practice.graphs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

public class AlienGraph {
	
	HashMap<Character, Node> reference = new HashMap<>();
	
	private static class Node{
		char c;
		HashSet<Node> adj = new HashSet<>();
		
		public Node(char c){
			this.c = c;
		}
	}
	
	public void put(char c){
		if(!reference.containsKey(c))
			reference.put(c, new Node(c));
	}
	
	public void addEdge(char source, char destination){
		Node a = reference.get(source);
		if(a == null) {
			put(source);
			a = reference.get(source);
		}
		Node b = reference.get(destination);
		if(b == null){
			put(destination);
			b = reference.get(destination);
		}
		a.adj.add(b);
	}
	
	public void printTopologicalSort(char source){
		Node a = reference.get(source);
		Stack<Node> stack = new Stack<>();
		HashSet<Node> visited = new HashSet<>();
		topologicalSort(a, stack, visited);
		while(!stack.isEmpty())
			System.out.println(stack.pop().c);
	}
	
	private void topologicalSort(Node s, Stack<Node> stack, HashSet<Node> visited){
		visited.add(s);
		
		for(Node x : s.adj){
			if(!visited.contains(x))
				topologicalSort(x, stack, visited);
		}
		stack.push(s);
	}
	
	
	public static void main(String[] args){
		StringBuffer buffer = new StringBuffer();
		AlienGraph graph = new AlienGraph();
		String[] strDict = {"caa", "aaa","aab"};
		for(int i = 0; i < strDict.length - 1; i++){
			for(int j = 0; j < Math.min(strDict[i].length(), strDict[i + 1].length());j++){
				if(strDict[i].charAt(j) != strDict[i+1].charAt(j))
					graph.addEdge(strDict[i].charAt(j), strDict[i+1].charAt(j));
			}
		}
		buffer.toString();
		graph.printTopologicalSort(strDict[0].charAt(0));
	}

}
