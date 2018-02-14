package graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.Stack;

public class DepthFirstSearch {

	LinkedList<Integer>[]arrayOfLinkedList;
	Set<Integer>visitedSet = new HashSet<>();
	Stack<Integer>stack = new Stack<>();
	int size;
	
	void initialize(int size){
		this.size = size;
		this.arrayOfLinkedList = new LinkedList[size];
		for(int i=0;i<size;i++)
			arrayOfLinkedList[i]=new LinkedList<>();
	}
	
	int getSize(){
		return this.size;
	}
	
	void createUndirectedEdge(int startNode, int endNode){
		this.arrayOfLinkedList[startNode].addFirst(endNode);
		this.arrayOfLinkedList[endNode].addFirst(startNode);
	}
	
	void print(){
		for(int i=0;i<getSize();i++){
			System.out.println(i+" => "+this.arrayOfLinkedList[i]);
		}
	}

	
	void depthFirstSearch(int startNode){
			stack.push(startNode);
			visitedSet.add(startNode);
			System.out.print(startNode+" -> ");
			while(!stack.isEmpty()){
				Integer neighbour = findUnvisitedNeighbour(stack.peek());
				if(neighbour!=null){
					depthFirstSearch(neighbour);
				}else{
					stack.pop();
				}
			}
	}
	
	private Integer findUnvisitedNeighbour(int startNode) {
		LinkedList<Integer>neighbours = arrayOfLinkedList[startNode];
		if(neighbours==null || neighbours.size()==0){
			return null;
		}
		for(Integer neighbour : neighbours){
			if(!visitedSet.contains(neighbour)){
				return neighbour;
			}
		}
		return null;
	}

	public static void main(String[] args) {
		DepthFirstSearch dfs = new DepthFirstSearch();
		dfs.initialize(5);
		dfs.createUndirectedEdge(0, 1);
		dfs.createUndirectedEdge(0, 2);
		dfs.createUndirectedEdge(0, 4);
		dfs.createUndirectedEdge(1, 3);
		dfs.createUndirectedEdge(3, 4);
		dfs.createUndirectedEdge(4, 2);
		dfs.print();
		dfs.depthFirstSearch(0);
	}

}
