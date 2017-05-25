package com.practice.graphs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Stack;

public class GraphSecond {
	private HashMap<Integer, Node> nodeLookup = new HashMap<Integer, Node>();

	public GraphSecond(HashMap<Integer, Node> nodeLookup){
		this.nodeLookup = nodeLookup;
	}
	
	
	public GraphSecond(){
		
	}
	
	public void addNodeToLookUp(int i){
		if(!nodeLookup.containsKey(i))
			nodeLookup.put(i, new Node(i));
	}
	
	public static class Node {
		private int id;
		LinkedHashSet<Node> adj = new LinkedHashSet<>();
		
		public Node(int id){
			this.id = id;
		}
	}

	private Node get(int id) {
		return nodeLookup.get(id);
	}

	public void addEdge(int source, int destination) {
		Node s = get(source);
		Node d = get(destination);
		if(s== null || d == null) throw new IllegalArgumentException("Either the source or the destination values don't exist. Please check");
		s.adj.add(d);
	}

	public boolean hasPathDFS(int source, int destination) {
		Node s = get(source);
		Node d = get(destination);
		HashSet<Integer> set = new HashSet<>();
		return hasPathDFS(s, d, set);
	}

	private boolean hasPathDFS(Node s, Node d, HashSet<Integer> set) {
		if(set.contains(d)) return false;
		set.add(s.id);
		if (s.id == d.id){
			return true;
		}
		for (Node next : s.adj) {
			if (hasPathDFS(next, d, set))
				return true;
		}
		return false;
	}
	
	public void printDFS(int source){
		Node s = get(source);
		HashSet<Node> visited = new HashSet<>();
		printDFS(s, visited);
	}
	
	private void printDFS(Node s, HashSet<Node> visited){
		visited.add(s);
		System.out.println(s.id);
		for(Node x : s.adj){
			if(!visited.contains(x))
				printDFS(x, visited);
		}
	}
	
	public void printTopologicalSort(int source){
		Node s = get(source);
		Stack<Node> stack = new Stack();
		HashSet<Node> visited = new HashSet<>();
		topologicalSort(s,stack, visited);
		while(!stack.isEmpty())
			System.out.println(stack.pop().id);
	}
	
	private void topologicalSort(Node s, Stack<Node> stack, HashSet<Node> visited){
		visited.add(s);
		for(Node x : s.adj){
			if(!visited.contains(x))
				topologicalSort(x, stack, visited);
		}
		stack.push(s);
	}
	
	public boolean hasPathBFS(int source, int destination){
		Node s = get(source);
		Node d = get(destination);
		return hasPathBFS(s, d);
	}
	
	private boolean hasPathBFS(Node s, Node d){
		HashSet<Integer> set = new HashSet<>();
		LinkedList<Node> queue = new LinkedList<>();
		if(s == d) return true;
		queue.add(s);
		while(!queue.isEmpty()){
			Node node = queue.remove();
			if(node == d) return true;
			if(!set.contains(node.id)) set.add(node.id);
			for(Node child : node.adj){
				queue.add(child);
			}
		}
		return false;
	}

}
