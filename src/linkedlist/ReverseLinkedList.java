package linkedlist;

import java.util.Stack;

public class ReverseLinkedList {
	
	class LinkedListImpl{
		int val;
		LinkedListImpl next;
	}
	
	LinkedListImpl createNode(int val){
		LinkedListImpl node = new LinkedListImpl();
		node.val = val;
		return node;
	}
	
	void printLinkedList(LinkedListImpl head){
		while(head!=null){
			System.out.print(head.val+"->");
			head = head.next;
		}
	}

	public static void main(String[] args) {
		ReverseLinkedList r = new ReverseLinkedList();
		LinkedListImpl one = r.createNode(1);
		LinkedListImpl two = r.createNode(2);
		LinkedListImpl three = r.createNode(3);
		one.next = two;
		two.next = three;
		r.printLinkedList(one);
		System.out.println(" ");
		LinkedListImpl reversedHead = r.reverseLinkedList(one);
		r.printLinkedList(reversedHead);
	}

	private LinkedListImpl reverseLinkedList(LinkedListImpl head) {
		Stack<LinkedListImpl>stack = new Stack<>();
		while(head!=null){
			stack.push(head);
			head=head.next;
		}
		System.out.println(" ");
		LinkedListImpl dummy = createNode(-1);
		LinkedListImpl current = dummy;
		while(!stack.isEmpty()){
			current.next = stack.pop();
			current = current.next;
			current.next = null;
		}
		return dummy.next;
	}

}
