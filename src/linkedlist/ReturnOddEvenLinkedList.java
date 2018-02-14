package linkedlist;

public class ReturnOddEvenLinkedList {
	
	class ListNode{
		int val;
		ListNode next;
	}
	
	ListNode createNode(int val){
		ListNode newNode = new ListNode();
		newNode.val = val;
		return newNode;
	}
	
	void print(ListNode node){
		while(node!=null){
			System.out.print(node.val+"->");
			node = node.next;
		}
	}
	
	public ListNode oddEvenList(ListNode head) {
        if(head==null){
            return null;
        }
        ListNode fakeOdd = createNode(-1);
        ListNode fakeEven = createNode(-2);
        ListNode copyFakeOdd = fakeOdd;
        ListNode copyFakeEven = fakeEven;
        
        ListNode copy = head;
        
        while(copy!=null && copy.next!=null){
        	fakeOdd.next = copy;
        	copy = copy.next.next;
        	fakeOdd = fakeOdd.next;
        }
        if(copy!=null){
        	fakeOdd.next = copy;
        	fakeOdd = fakeOdd.next;
        }
        print(copyFakeOdd);
         
        head = head.next;
        copy = head;
        while(copy!=null && copy.next!=null){
        	fakeEven.next = copy;
        	copy = copy.next.next;
        	fakeEven = fakeEven.next;
        }
        if(copy!=null){
        fakeEven.next = copy;
        fakeEven = fakeEven.next;
        }

        fakeOdd.next = copyFakeEven.next;

        return copyFakeOdd.next;
    }

	public static void main(String[] args) {
		ReturnOddEvenLinkedList r = new ReturnOddEvenLinkedList();
		ListNode one = r.createNode(1);
		ListNode two = r.createNode(2);
		ListNode three = r.createNode(3);
		ListNode four = r.createNode(4);
		ListNode five = r.createNode(5);
		
		one.next = two;
		two.next = three;
		three.next = four;
		four.next = five;
		
		r.print(one);
		System.out.println(" ");
		ListNode result = r.oddEvenList(one);
		
		r.print(result);
	}

}
