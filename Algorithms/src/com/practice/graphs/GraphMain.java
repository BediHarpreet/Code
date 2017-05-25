package com.practice.graphs;

public class GraphMain {

	public static void main(String[] args) {
		Graph graph = new Graph(5);
		graph.addEdge(1, 2);
		graph.addEdge(1, 3);
		graph.addEdge(2, 3);
		graph.addEdge(3, 4);
		graph.addEdge(2, 4);
		graph.addEdge(0, 1);
		System.out.println(graph.E());
	}

}
