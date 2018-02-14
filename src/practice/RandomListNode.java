package practice;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class RandomListNode {
int label;
RandomListNode next, random;
static Stack<RandomListNode> originalStackCopy = new Stack<>();
RandomListNode(int x) { this.label = x; }

public static void main(String[] args){
	RandomListNode head = new RandomListNode(1);
	RandomListNode n2 = new RandomListNode(2);
	RandomListNode n3 = new RandomListNode(3);
	
	head.next=n2;
	n2.next=n3;
	
	head.random=n3;
	n3.random=n2;
	n2.random=head;
	
	copyRandomList(head);
}


public static void copyRandomList(RandomListNode head) {
    /*RandomListNode clonedHead = cloneAndCopyNext(head);
    print(head);
    System.out.println("========================================");
    mapNextPointerOfOriginalToRespectiveClonedNodes(head,clonedHead);
    mapRandomPointerOfClonedNodesToRespectiveOriginalNodes(head,clonedHead);
    mappingRandomPointersOfCloedNodes(clonedHead);
    print(clonedHead);
    System.out.println("========================================");*/
    copyTheNodeUsingHashMap(head);
}

public static void mappingRandomPointersOfCloedNodes(RandomListNode clonedHead){
	while(clonedHead!=null){
		clonedHead.random = clonedHead.random.random.next;
		clonedHead=clonedHead.next;
	}
}

public static void mapRandomPointerOfClonedNodesToRespectiveOriginalNodes(RandomListNode head,RandomListNode clonedHead){
	Stack<RandomListNode> clonedStack = new Stack<>();
	
	while(clonedHead!=null){
		clonedStack.push(clonedHead);
		clonedHead=clonedHead.next;
	}
	
	while(!clonedStack.isEmpty()){
		RandomListNode cloned = clonedStack.pop();
		RandomListNode original = originalStackCopy.pop();
		cloned.random = original;
	}
}

public static void mapNextPointerOfOriginalToRespectiveClonedNodes(RandomListNode head,RandomListNode clonedHead){
	Stack<RandomListNode> originalStack = new Stack<>();
	Stack<RandomListNode> clonedStack = new Stack<>();
	
	while(head!=null){
		originalStack.push(head);
		originalStackCopy.push(head);
		head=head.next;
	}
	
	while(clonedHead!=null){
		clonedStack.push(clonedHead);
		clonedHead=clonedHead.next;
	}
	
	while(!originalStack.isEmpty()){
		RandomListNode original = originalStack.pop();
		RandomListNode clone = clonedStack.pop();
		original.next = clone;
	}
}

public static RandomListNode cloneAndCopyNext(RandomListNode head){
    if(head==null)
        return null;
    RandomListNode clonedHead = new RandomListNode(head.label);
    RandomListNode toReturn = clonedHead;
    head=head.next;
    while(head!=null){
        RandomListNode node = new RandomListNode(head.label);
        clonedHead.next=node;
        clonedHead=clonedHead.next;
        head=head.next;
    }
    return toReturn;
}

public static void print(RandomListNode head){
	while(head!=null){
    	if(head.next!=null)
			System.out.println(head.label+" "+head.next.label+" "+head.random.label);
		if(head.next==null)
			System.out.println(head.label+" "+"n"+" "+head.random.label);
        head=head.next;
    }
}

public static RandomListNode copyTheNodeUsingHashMap(RandomListNode head){
	Set<RandomListNode>set = new LinkedHashSet<>();
	while(head!=null){
		set.add(head);
		head=head.next;
	}
	
	RandomListNode toReturn=null;
	RandomListNode clonedNode=null;
	int i=0;
	for(RandomListNode node : set){
		if(i==0){
			clonedNode=node;
			toReturn=clonedNode;
			clonedNode=clonedNode.next;
			i++;
		}
		clonedNode = node;
		clonedNode=clonedNode.next;
	}
	return toReturn;
}
}
