package binarytree;

import java.util.HashMap;
import java.util.Map;

public class VerticalDistanceOfBinaryTree {
	Map<Integer,Integer>map = new HashMap<>();
	int minDistance = 0;
	int maxDistance = 0;
	
	
	class BinaryTree{
		int val;
		BinaryTree left;
		BinaryTree right;
	}
	
	BinaryTree createNode(int val){
		BinaryTree node = new BinaryTree();
		node.val = val;
		return node;
	}

	public static void main(String[] args) {
		VerticalDistanceOfBinaryTree v = new VerticalDistanceOfBinaryTree();
		BinaryTree one = v.createNode(1);
		BinaryTree two = v.createNode(2);
		BinaryTree three = v.createNode(3);
		BinaryTree four = v.createNode(4);
		BinaryTree five = v.createNode(5);
		BinaryTree six = v.createNode(6);
		BinaryTree seven = v.createNode(7);
		
		one.left = two;
		one.right = three;
		two.left = four;
		two.right = five;
		three.left = seven;
		three.right = six;
		
		v.findVerticalSum(one);
		
	}
	
	void findVerticalSum(BinaryTree root){
		findMinMaxDistances(root,0);
		for(int i=minDistance;i<=maxDistance;i++){
			findSumByVerticalDistance(root,i,0);
		}
		
		for(int i=minDistance;i<=maxDistance;i++){
			System.out.println("Vertical Distance: "+i+", Sum Of Level: "+map.get(i));
		}
	}
	
	void findSumByVerticalDistance(BinaryTree root, int verticalLevel, int distance){
		if(root==null){
			return;
		}
		if(verticalLevel == distance){
			if(map.containsKey(verticalLevel)){
				int levelSum = map.get(verticalLevel);
				levelSum+=root.val;
				map.put(verticalLevel, levelSum);
			}else{
				map.put(verticalLevel, root.val);
			}
		}
		findSumByVerticalDistance(root.left,verticalLevel,distance-1);
		findSumByVerticalDistance(root.right,verticalLevel,distance+1);
	}
	
	void findMinMaxDistances(BinaryTree node, int distance){
		if(node==null){
			return;
		}
		if(distance<minDistance){
			minDistance = distance;
		}
		if(distance>maxDistance){
			maxDistance = distance;
		}
		findMinMaxDistances(node.left,distance-1);
		findMinMaxDistances(node.right,distance+1);
	}

}
