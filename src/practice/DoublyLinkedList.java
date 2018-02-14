package practice;

import java.util.Stack;

public class DoublyLinkedList {
int data;
DoublyLinkedList next;
DoublyLinkedList prev;

public static void main(String[] args){
	DoublyLinkedList n1 = new DoublyLinkedList();
	n1.data=1;
	
	DoublyLinkedList n2 = new DoublyLinkedList();
	n2.data=2;
	
	DoublyLinkedList n3 = new DoublyLinkedList();
	n3.data=3;
	
	n1.next = n2;
	n2.prev = n1;
	n2.next = n3;
	n3.prev = n2;
	
	print(n1);
	DoublyLinkedList rev = reverse(n1);
	System.out.println(" ");
	print(rev);
}

static DoublyLinkedList reverse(DoublyLinkedList head) {
Stack<Integer> stack = new Stack<>();
DoublyLinkedList firstNode=null;
    int size = 0;
    while(head!=null){
        stack.push(head.data);
        head=head.next;
        size++;
    }
    DoublyLinkedList first = new DoublyLinkedList();
    while(stack.size()>0){
        if(stack.size()==size){
        first.data = stack.pop();
        firstNode = first;
        }else{
        	DoublyLinkedList node = new DoublyLinkedList();
            node.data = stack.pop();
            first.next = node;
            node.prev = first;
            first = node;
        }
    }
    return firstNode;
}

public static void print(DoublyLinkedList node){
	while(node!=null){
		System.out.print(node.data+" ");
		node = node.next;
	}
}

}
