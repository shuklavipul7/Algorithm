package practice;

import java.util.Stack;

public class LinkedList {
	LinkedList next;
	int data;
	
	public static void main(String[] args){
		LinkedList l= new LinkedList();
		LinkedList n1 = l.insertAtEnd(null, 1);
		LinkedList n2 = l.insertAtEnd(n1, 2);
		LinkedList n3 = l.insertAtEnd(n1, 2);
		LinkedList n4 = l.insertAtEnd(n1, 3);
		LinkedList n5 = l.insertAtEnd(n1, 5);
		LinkedList n6 = l.insertAtEnd(n1, 5);
	
		l.printLinkedList(n1);
		
		//l.printLinkedList(l.RemoveDuplicates(n1));
		
		/*LinkedList reversed = l.reverse(n1);
		l.printLinkedList(reversed);*/
		
		l.removeDuplicatesNew(n1);
		l.printLinkedList(n1);
	}
	
	public LinkedList insertAtEnd(LinkedList head, int data){
		LinkedList linkedListNode = new LinkedList();
		linkedListNode.data = data;
		if(head==null){
			return linkedListNode;
		}else{
			LinkedList h = head;
			while(head.next!=null){
				head=head.next;
			}
			head.next = linkedListNode;
			return h;
		}
	}
	
	public void printLinkedList(LinkedList head){
		while(head!=null){
			System.out.print(head.data+"-->");
			head = head.next;
		}
		System.out.println(" ");
	}
	
	public LinkedList reverse(LinkedList head){
		if(head==null){
			return null;
		}else{
			Stack<Integer> stack = new<Integer> Stack();
			while(head!=null){
				stack.push(head.data);
				head=head.next;
			}
			LinkedList h = null;
			LinkedList firstNode=null;
			while(!stack.empty()){
				if(h==null){
					LinkedList node = new LinkedList();
					node.data=stack.pop();
					h=node;
					firstNode=h;
				}else{
					LinkedList node = new LinkedList();
					node.data=stack.pop();
					h.next=node;
					h=h.next;
				}
			}
			return firstNode;
		}
	}
	
	LinkedList RemoveDuplicates(LinkedList head) {
		LinkedList node=null;
		LinkedList firstNode=null;
	  while(head!=null){
		  if(head.next!=null){
	      if(head.data!=head.next.data){
	    	  LinkedList n1=new LinkedList();
	          n1.data=head.data;
	          if(node==null){
	              node=n1;
	              firstNode=node;
	          }else{
	          node.next=n1;    
	          node=node.next;
	          }
	      }
	      head=head.next;
		  }else{
			  LinkedList nL = new LinkedList();
			  nL.data=head.data;
			  node.next=nL;
			  head=head.next;
		  }
	  }
	    return firstNode;
	}
	
	public void removeDuplicatesNew(LinkedList head){
		if(head==null)
			return;
		if(head!=null && head.next!=null){
			if(head.data==head.next.data){
				head.next=head.next.next;
			}
			head=head.next;
		}
		removeDuplicatesNew(head);
	}
	

}
