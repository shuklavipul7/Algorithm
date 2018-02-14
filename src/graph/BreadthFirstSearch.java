package graph;

import java.util.LinkedList;

public class BreadthFirstSearch {
	private LinkedList<Integer>[]arrayOfLinkedList;
	private int size;
	
	LinkedList[] initializeGraph(int size){
		this.size = size;
		this.arrayOfLinkedList = new LinkedList[size];
		for(int i=0;i<size;i++){
			this.arrayOfLinkedList[i]= new LinkedList<>();
		}
		return arrayOfLinkedList;
	}
	
	

	public static void main(String[] args) {

	}

}
