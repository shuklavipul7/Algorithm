package graph;

import java.util.LinkedList;

public class DirectedGraphImpl {
	
	class DirectedGraph{
		int numberOfVertices;
		LinkedList<Integer>[]arrayOfLinkedList;
		
		public int size(){
			return this.numberOfVertices;
		}
	}
	
	public DirectedGraph createGraph(int size){
		DirectedGraph directedGraph=new DirectedGraph();
		directedGraph.numberOfVertices=size;
		directedGraph.arrayOfLinkedList = new LinkedList[size];
		for(int i=0;i<size;i++){
			directedGraph.arrayOfLinkedList[i]=new LinkedList<Integer>();
		}
		return directedGraph;
	}
	
	public void createDirectedEdge(DirectedGraph graph, int source, int destination){
		for(int i=0;i<graph.size();i++){
			if(i==source){
				graph.arrayOfLinkedList[i].addFirst(destination);
			}
		}
	}
	
	public void printGraph(DirectedGraph graph){
		for(int i=0;i<graph.size();i++){
			System.out.println(i+" ==> "+graph.arrayOfLinkedList[i]);
		}
	}

	public static void main(String[] args) {
		DirectedGraphImpl directedGraphImpl = new DirectedGraphImpl();
		DirectedGraph graph = directedGraphImpl.createGraph(5);
		directedGraphImpl.createDirectedEdge(graph, 1, 2);
		directedGraphImpl.createDirectedEdge(graph, 1, 0);
		directedGraphImpl.createDirectedEdge(graph, 0, 3);
		directedGraphImpl.createDirectedEdge(graph, 2, 3);
		directedGraphImpl.createDirectedEdge(graph, 3, 4);
		directedGraphImpl.printGraph(graph);
	}

}
