package binarytree;

public class LevelOrderTraversalUsingHeight {

	class BinaryTree {
		BinaryTree left;
		BinaryTree right;
		int val;
	}

	BinaryTree createNode(int val) {
		BinaryTree treeNode = new BinaryTree();
		treeNode.val = val;
		return treeNode;
	}

	/*
	   1 
	  / \ 
	 2   3
	/\   /\ 
   4  5 6 7 */

	public static void main(String[] args) {
		LevelOrderTraversalUsingHeight bt = new LevelOrderTraversalUsingHeight();

		BinaryTree one = bt.createNode(1);
		BinaryTree two = bt.createNode(2);
		BinaryTree three = bt.createNode(3);
		BinaryTree four = bt.createNode(4);
		BinaryTree five = bt.createNode(5);
		BinaryTree six = bt.createNode(6);
		BinaryTree seven = bt.createNode(7);

		one.left = two;
		one.right = three;
		two.left = four;
		two.right = five;
		three.left = six;
		three.right = seven;

		int height = bt.findHeight(one);
		System.out.println("Tree Height = "+height);
		
		for(int i=1;i<=height;i++){
			System.out.println(" ");
			printLevelOrder(one,i);
		}
	}
	
	private static void printLevelOrder(BinaryTree root, int level){
		if(root==null){
			return;
		}else if(level==1){
			System.out.print(root.val+" ");
		}else{
			printLevelOrder(root.left,level-1);
			printLevelOrder(root.right,level-1);
		}
	}

	private int findHeight(BinaryTree head) {
		if(head==null){
			return 0;
		}
		int lHeight = findHeight(head.left);
		int rHeight = findHeight(head.right);
		return Math.max(lHeight, rHeight)+1;
	}

}
