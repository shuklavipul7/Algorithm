package practice;

import java.util.ArrayList;
import java.util.HashMap;

public class Tree {
	int data;
    Tree left;
    Tree right;

	public static void main(String[] args) {
		Tree n1 = new Tree();
		n1.data=1;
		
		Tree n2 = new Tree();
		n2.data=2;
		
		Tree n3 = new Tree();
		n3.data=5;
		
		Tree n4 = new Tree();
		n4.data=3;
		
		Tree n5 = new Tree();
		n5.data=4;
		
		Tree n6 = new Tree();
		n6.data=6;
		
		n1.right=n2;
		n2.right=n3;
		n3.left=n4;
		n4.right=n5;
		n3.right=n6;

		Tree t = new Tree();
		t.inFix(n1);
		System.out.println(" ");
		t.topView(n1);
	}

	class InternalTree{
	    Tree Tree;
	    Integer index;
	}
	int i=0;
	HashMap<Integer,InternalTree> hMap = new HashMap<>();
	InternalTree parent = new InternalTree();
	InternalTree first = parent;
	   void topView(Tree root) {
	     if(root!=null){
	         if(i==0){
	         parent.Tree=root;
	         parent.index=i;
	         hMap.put(parent.index,parent);
	         i++;
	         }
	         
	         if(root.left!=null){
	         InternalTree internalTree = new InternalTree();
	         internalTree.Tree=root.left;
	         internalTree.index=parent.index-1;
	         if(!hMap.containsKey(internalTree.index)){
	           hMap.put(internalTree.index,internalTree);
	         }
	         parent = internalTree;
	         topView(root.left);       
	         }
	         
	         if(root.right!=null){
	         InternalTree internalTree = new InternalTree();
	         internalTree.Tree=root.right;
	         internalTree.index=parent.index+1;
	         if(!hMap.containsKey(internalTree.index)){
	           hMap.put(internalTree.index,internalTree);
	         }
	         parent = internalTree;
	         topView(root.right);
	         }
	     }
	       for(Integer i: hMap.keySet()){
	           InternalTree in = (hMap.get(i));
	           System.out.print(in.Tree.data);
	       }
	    }

	
	void inFix(Tree root){
		if(root!=null){
			System.out.print(root.data+" ");
			inFix(root.left);
			inFix(root.right);
		}
	}

}
