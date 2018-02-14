package linkedlist;

public class SortedListToBST {

	public static void main(String[] args) {
		SortedListToBST s = new SortedListToBST();
		ListNode minus10 = s.new ListNode(-10);
		ListNode minus3 = s.new ListNode(-3);
		ListNode zero = s.new ListNode(0);
		ListNode five = s.new ListNode(5);
		ListNode nine = s.new ListNode(9);
		
		minus10.next = minus3;
		minus3.next = zero;
		zero.next = five;
		five.next = nine;
		
		s.sortedListToBST(minus10);

	}
	
	class TreeNode{
		TreeNode left;
		TreeNode right;
		int val;
		public TreeNode(int val){
			this.val = val;
		}
	}
	
	class ListNode{
		ListNode next;
		int val;
		public ListNode(int val){
			this.val = val;
		}
	}
	
	public TreeNode sortedListToBST(ListNode head) {
        if(head==null){
            return null;
        }
        if(head.next==null){
           TreeNode node = new TreeNode(head.val);
           return node;
        }
        
        ListNode slow = head;
        ListNode fast = head;
        ListNode previous = null;
        while(fast!=null && fast.next!=null){
            previous = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        TreeNode node = new TreeNode(slow.val);
        previous.next = null;
        node.left = sortedListToBST(head);
        node.right = sortedListToBST(slow.next);
        return node;
    }

}
