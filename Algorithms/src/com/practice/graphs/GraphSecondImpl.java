package com.practice.graphs;

public class GraphSecondImpl {

	public static void main(String[] args) {
		GraphSecond gs = new GraphSecond();
		gs.addNodeToLookUp(1);
		gs.addNodeToLookUp(2);
		gs.addNodeToLookUp(3);
		gs.addNodeToLookUp(4);
		gs.addNodeToLookUp(5);
		gs.addNodeToLookUp(6);
		gs.addNodeToLookUp(7);
		gs.addEdge(1, 2);
		gs.addEdge(1, 3);
		gs.addEdge(2, 3);
		gs.addEdge(2, 4);
		gs.addEdge(2, 5);
		gs.addEdge(4, 5);
		gs.addEdge(3, 6);
		gs.addEdge(7, 6);
		gs.addEdge(1, 7);
		gs.printTopologicalSort(1);
	}

}
