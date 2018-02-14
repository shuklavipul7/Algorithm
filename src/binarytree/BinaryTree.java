package binarytree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree {
	BinaryTree left;
	BinaryTree right;
	Integer data;
	
	static int minVerticalDistance, maxVerticalDistance;
	static Map<Integer,Integer>verticalSum=new HashMap<>();

	public static void main(String args[]) {
		BinaryTree bt1 = new BinaryTree();
		bt1.data = 1;

		BinaryTree bt2 = new BinaryTree();
		bt2.data = 2;

		BinaryTree bt3 = new BinaryTree();
		bt3.data = 3;

		BinaryTree bt4 = new BinaryTree();
		bt4.data = 4;

		BinaryTree bt5 = new BinaryTree();
		bt5.data = 5;

		bt1.left = bt2;
		bt1.right = bt3;
		bt2.left = bt4;
		bt2.right = bt5;
		
		//inOrderTraversalNonRecursive(bt1);
		
		findVerticalSum(bt1);
		
		for(Integer key : verticalSum.keySet()){
			System.out.println(key+" : "+verticalSum.get(key));
		}

		System.out.println("Level Order Traversal using Queue: ");
		levelOrderTraversalUsingQueue(bt1);
		System.out.println(" ");
		System.out.println("Level Order Traversal using Recursion: ");
		for(int i=1; i<=depthOfBinaryTree(bt1); i++){
			System.out.println(" ");
			System.out.println("level: "+i);
		levelOrderTraversalUsingRecursion(bt1,i);
		}
		System.out.println(" ");
		System.out.println("Level Order Traversal in reverse order using Recursion: ");
		for(int i=depthOfBinaryTree(bt1); i>=1; i--){
			System.out.println(" ");
			System.out.println("level: "+i);
		levelOrderTraversalUsingRecursion(bt1,i);
		}
		int max = findMaximumElement(bt1);
		System.out.println(" ");
		System.out.println("Max: "+max);
		System.out.println("Size: "+sizeOfBinaryTree(bt1));
		System.out.println("Depth: "+depthOfBinaryTree(bt1));

	}

	public static void levelOrderTraversalUsingQueue(BinaryTree root) {
		Queue<BinaryTree> queue = new LinkedList();
		queue.add(root);
		while (!queue.isEmpty()) {
			BinaryTree temp = queue.remove();
			System.out.print(temp.data + " ");
			if (temp.left != null) {
				queue.add(temp.left);
			}
			if (temp.right != null) {
				queue.add(temp.right);
			}
		}
	}
	
	public static void levelOrderTraversalUsingRecursion(BinaryTree root,int level){
		if(root==null){
			return;
		}
		if(level==1){
			System.out.print(root.data+" ");
		}
		else if(level>1){
			levelOrderTraversalUsingRecursion(root.left,level-1);
			levelOrderTraversalUsingRecursion(root.right,level-1);
		}
	}

	public static int findMaximumElement(BinaryTree root) {
		Queue<BinaryTree> queue = new LinkedList<>();
		int max=Integer.MIN_VALUE;
		queue.add(root);
		while (!queue.isEmpty()) {
			BinaryTree temp = queue.remove();
			if(temp.data>max){
				max=temp.data;
			}
			if (temp.left != null) {
				queue.add(temp.left);
			}
			if (temp.right != null) {
				queue.add(temp.right);
			}
		}
		return max;
	}
	
	public static int sizeOfBinaryTree(BinaryTree root){
		if(root==null){
			return 0;
		}
		return (sizeOfBinaryTree(root.left)+1+sizeOfBinaryTree(root.right));
	}
	
	public static int depthOfBinaryTree(BinaryTree root){
		int leftDepth=0;
		int rightDepth=0;
		if(root==null){
			return 0;
		}else{
			leftDepth = depthOfBinaryTree(root.left);
			rightDepth = depthOfBinaryTree(root.right);
			if(leftDepth>rightDepth){
				return leftDepth+1;
			}else{
				return rightDepth+1;
			}
		}
	}
	
	public static void preOrderTraversalNonRecursive(BinaryTree node){
		Stack<BinaryTree> stack=new Stack<>();
		if(node==null)
			return;
		while(true){
			while(node!=null){
				System.out.print(node.data+" ");
				stack.push(node);
				node=node.left;
			}
			if(stack.size()==0){
				break;
			}
			node=stack.pop().right;
		}
	}
	
	public static void inOrderTraversalNonRecursive(BinaryTree node){
		Stack<BinaryTree>stack=new Stack<>();
		if(node==null)
			return;
		while(true){
			while(node!=null){
				stack.push(node);
				node=node.left;
			}
			if(stack.size()==0)
				break;
			BinaryTree bt=stack.pop();
			System.out.print(bt.data+" ");
			node=bt.right;
		}
	}
	
	public static void findVerticalSum(BinaryTree root){
		//If we consider root at zero, find the maximum left and right distance from level zero
		findMinMax(root,0);
		
		//Now iterate from minDistance to maxDistance, finding sum of all the vertical lines
		for(int i=minVerticalDistance;i<=maxVerticalDistance;i++){
			printVerticalLine(root,i,0);
			System.out.println(" ");
		}
	}
	
	
	
	public static void printVerticalLine(BinaryTree node,int lineNo,int horizontalDistance){
		if(node==null)
			return;
		if(lineNo==horizontalDistance){
			if(verticalSum.containsKey(lineNo)){
				int oldSum=verticalSum.get(lineNo);
				int newSum=oldSum+node.data;
				verticalSum.put(lineNo, newSum);
			}else{
				verticalSum.put(lineNo, node.data);
			}
		}
		
		printVerticalLine(node.left, lineNo, horizontalDistance-1);
		printVerticalLine(node.right, lineNo, horizontalDistance+1);
	}
	
	public static void findMinMax(BinaryTree root, int distance){
		if(root==null){
			return;
		}
		if(distance>maxVerticalDistance){
			maxVerticalDistance=distance;
		}
		if(distance<minVerticalDistance){
			minVerticalDistance=distance;
		}
		
		findMinMax(root.left,distance-1);
		findMinMax(root.right,distance+1);
	}
}
