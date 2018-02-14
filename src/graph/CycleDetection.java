package graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.Stack;

public class CycleDetection {

	LinkedList<Integer>[] arrayOfLinkedList;
	int size;
	Set<Integer> visitedSet = new HashSet<>();
	Stack<Integer> stack = new Stack<>();

	LinkedList[] initializeGraph(int size) {
		this.size = size;
		this.arrayOfLinkedList = new LinkedList[size];
		for (int i = 0; i < size; i++) {
			this.arrayOfLinkedList[i] = new LinkedList<>();
		}
		return arrayOfLinkedList;
	}

	void addEdge(int start, int end) {
		arrayOfLinkedList[start].addFirst(end);
		//arrayOfLinkedList[end].addFirst(start);
	}

	boolean hasCycle(LinkedList<Integer>[] linkedListArrayToCheck) {
		return depthFirstSearch(0);
	}

	boolean depthFirstSearch(Integer nodeToCheck) {
		stack.push(nodeToCheck);
		visitedSet.add(nodeToCheck);
		while(!stack.isEmpty()) {
			Integer neighbour = findNeighbour(stack.peek());
			if (neighbour != null) {
				if (visitedSet.contains(neighbour)) {
					return  true;
				}else{
					depthFirstSearch(neighbour);
				}
			} else {
				stack.pop();
			}
		}
		return false;
	}

	private Integer findNeighbour(Integer nodeToCheck) {
		LinkedList<Integer> neighbours = arrayOfLinkedList[nodeToCheck];
		for (Integer neighbour : neighbours) {
			if (!neighbour.equals(nodeToCheck)) {
				return neighbour;
			}
		}
		return null;
	}

	public static void main(String[] args) {
		CycleDetection c = new CycleDetection();
		c.initializeGraph(2);
		c.addEdge(0, 1);
		//c.addEdge(1, 2);
		//c.addEdge(2, 0);
		System.out.println(c.hasCycle(c.arrayOfLinkedList));
	}

}
