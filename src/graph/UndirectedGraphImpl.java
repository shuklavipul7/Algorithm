package graph;

import java.util.LinkedList;
import java.util.List;

public class UndirectedGraphImpl {
	
	class UndirectedGraph{
		int numberOfVertices;
		LinkedList<Integer>[]arrayOfLinkedList;
		
		public int size(){
			return this.numberOfVertices;
		}
	}
	
	public UndirectedGraph createGraph(int n) {
		UndirectedGraph graph = new UndirectedGraph();
		graph.numberOfVertices=n;
		graph.arrayOfLinkedList=new LinkedList[n];
		for(int i=0;i<n;i++){
			graph.arrayOfLinkedList[i]=new LinkedList<Integer>();
		}
		return graph;
	}
	
	public void printGraph(UndirectedGraph graph){
		for(int i=0;i<graph.size();i++){
			System.out.println(i+" ==> "+graph.arrayOfLinkedList[i]);
		}
	}	
	
	public void createEdge(UndirectedGraph graph, int source, int destination){
		/*for(int i=0;i<graph.size();i++){
			if(i==source){
				graph.arrayOfLinkedList[i].addFirst(destination);
			}
			if(i==destination){
				graph.arrayOfLinkedList[i].addFirst(source);
			}
		}*/
		graph.arrayOfLinkedList[source].addFirst(destination);
		graph.arrayOfLinkedList[destination].addFirst(source);
	}
	
	
	
	public static void main(String[] args) {
		UndirectedGraphImpl graphImplementation1=new UndirectedGraphImpl();
		UndirectedGraph graph = graphImplementation1.createGraph(5);
		graphImplementation1.printGraph(graph);
		System.out.println("===========");
		graphImplementation1.createEdge(graph, 0, 3);
		graphImplementation1.createEdge(graph, 0, 1);
		graphImplementation1.createEdge(graph, 1, 2);
		graphImplementation1.createEdge(graph, 3, 2);
		graphImplementation1.createEdge(graph, 3, 4);
		graphImplementation1.printGraph(graph);
		
	}

}
