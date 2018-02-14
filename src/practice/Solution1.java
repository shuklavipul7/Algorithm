package practice;

import java.util.HashMap;

//MaximumSumInBinaryTree

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution1 {
    HashMap<Integer,Integer>maxSums=new HashMap<Integer,Integer>();
    int sum=0;
    
    public static void main(String args[]){
      	 TreeNode t1 = new TreeNode(4);
      	 TreeNode t2 = new TreeNode(2);
      	 TreeNode t3 = new TreeNode(6);
      	 TreeNode t4 = new TreeNode(3);
      	 TreeNode t5 = new TreeNode(1);
      	 TreeNode t6 = new TreeNode(5);
      	 
      	 t1.left=t2;
      	 t1.right=t3;
      	 t2.left=t4;
      	 t2.right=t5;
      	 t3.left=t6;
      	 
      	Solution1 solution1 = new Solution1();
      	int[] answer = solution1.findFrequentTreeSum(t1);
      	
      	for(int i=0; i<answer.length;i++){
      		System.out.println(answer[i]+" ");
      	}
    }
    
    public int[] findFrequentTreeSum(TreeNode root) {
        
        preOrder(root);
        int maximum=Integer.MIN_VALUE;
        int maxKey=Integer.MIN_VALUE;
        
        for(Integer key : maxSums.keySet()){
        	if(maxSums.get(key)>maximum){
        		maximum=maxSums.get(key);
        	}
        }
        int maxCount=0;
        for(Integer key : maxSums.keySet()){
        	if(maxSums.get(key)==maximum){
        		maxKey=key;
        		maxCount++;
        	}
        }
        
        int[] maxArray=new int[maxCount];
        int l=0;
        if(maxCount==1){
        	maxArray[0]=maxKey;
        }else{
        	for(Integer key : maxSums.keySet()){
            	if(maxSums.get(key)==maximum){
            		maxArray[l]= key;
            		l++;
            	}
            }
        }
        return maxArray;
    }

    public int preOrder(TreeNode root){
        if(root==null){
            return 0;
        }else{
            int sum = root.val+preOrder(root.left)+preOrder(root.right);
            if(maxSums.containsKey(sum)){
                int value = maxSums.get(sum);
                int newValue = value+1;
                maxSums.put(sum,newValue);
            }else{
                maxSums.put(sum,1);
            }
            return sum;
        }
    }
}