package binarytree;
import java.util.Stack;

public class BinaryTreeTraversal {

	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
	}

	TreeNode createNode(int val) {
		TreeNode newNode = new TreeNode();
		newNode.val = val;
		return newNode;
	}

	void preOrderTraversalRecursive(TreeNode root) {
		if(root==null){
			return;
		}
		System.out.print(root.val+" ");
		preOrderTraversalRecursive(root.left);
		preOrderTraversalRecursive(root.right);
	}

	void postOrderTraversalRecursive(TreeNode root) {
		if(root==null){
			return;
		}
		postOrderTraversalRecursive(root.left);
		postOrderTraversalRecursive(root.right);
		System.out.print(root.val+" ");
	}

	void inOrderTraversalRecursive(TreeNode root) {
		if(root==null){
			return;
		}
		inOrderTraversalRecursive(root.left);
		System.out.print(root.val+" ");
		inOrderTraversalRecursive(root.right);
	}
	
	void preOrderTraversalNonRecursive(TreeNode root){
		Stack<TreeNode>stack = new Stack<>();
		while(true){
			while(root!=null){
				System.out.print(root.val+" ");
				stack.push(root);
				root=root.left;
			}
			if(stack.isEmpty()){
				break;
			}
			TreeNode temp = stack.pop();
			root = temp.right;
		}
	}
	
	void inOrderTraversalNonRecursive(TreeNode root){
		Stack<TreeNode>stack = new Stack<>();
		while(true){
			while(root!=null){
				stack.push(root);
				root=root.left;
			}
			if(stack.isEmpty()){
				break;
			}
			TreeNode temp = stack.pop();
			System.out.print(temp.val+" ");
			root = temp.right;
		}
	}
	
	void postOrderTraversalNonRecursive(TreeNode root){
		Stack<TreeNode>stack1 = new Stack<>();
		Stack<TreeNode>stack2 = new Stack<>();
		stack1.push(root);
		while(!stack1.isEmpty()){
			TreeNode temp = stack1.pop();
			stack2.push(temp);
			if(temp.left!=null){
				stack1.push(temp.left);
			}
			if(temp.right!=null){
				stack1.push(temp.right);
			}
		}
		
		while(!stack2.isEmpty()){
			System.out.print(stack2.pop().val+" ");
		}
	}

	public static void main(String[] args) {
		BinaryTreeTraversal bTree = new BinaryTreeTraversal();
		TreeNode one = bTree.createNode(1);
		TreeNode two = bTree.createNode(2);
		TreeNode three = bTree.createNode(3);
		TreeNode four = bTree.createNode(4);
		TreeNode five = bTree.createNode(5);
		TreeNode six = bTree.createNode(6);
		TreeNode seven = bTree.createNode(7);
		
		one.left = two;
		one.right = three;
		two.left = four;
		two.right = five;
		three.left = six;
		three.right = seven;
		
		System.out.println("Pre Order Traversal Recursive");
		bTree.preOrderTraversalRecursive(one);
		System.out.println("");
		System.out.println("==============================");
		
		System.out.println("Post Order Traversal Recursive");
		bTree.postOrderTraversalRecursive(one);
		System.out.println("");
		System.out.println("==============================");
		
		System.out.println("In Order Traversal Recursive");
		bTree.inOrderTraversalRecursive(one);
		System.out.println("");
		System.out.println("==============================");
		
		System.out.println("Pre Order Traversal Recursive");
		bTree.preOrderTraversalNonRecursive(one);
		System.out.println("");
		System.out.println("==============================");
		
		System.out.println("In Order Traversal Recursive");
		bTree.inOrderTraversalNonRecursive(one);
		System.out.println("");
		System.out.println("==============================");
		
		System.out.println("Post Order Traversal Recursive");
		bTree.postOrderTraversalNonRecursive(one);
		System.out.println("");
		System.out.println("==============================");
	}

}
