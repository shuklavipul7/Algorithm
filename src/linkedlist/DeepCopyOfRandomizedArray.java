package linkedlist;

import java.util.HashMap;
import java.util.Map;

public class DeepCopyOfRandomizedArray {
	
	class CustomLinkedList{
		int val;
		CustomLinkedList next;
		CustomLinkedList random;
	}
	
	CustomLinkedList createNode(int val){
		CustomLinkedList newNode = new CustomLinkedList();
		newNode.val=val;
		return newNode;
	}
	
	void print(CustomLinkedList head){
		while(head!=null){
			System.out.print(head.val+","+head.random.val+"->");
			head = head.next;
		}
	}
	
	CustomLinkedList createDeepCopy(CustomLinkedList head){
		if(head==null){return null;}
		
		Map<CustomLinkedList, CustomLinkedList>map = new HashMap<>();
		CustomLinkedList copy = head;
		
		//Creating and initializing the map
		while(copy!=null){
			map.put(copy, createNode(copy.val));
			copy = copy.next;
		}
		
		//Assigning the next and random pointers
		copy = head;
		while(copy!=null){
			map.get(copy).next = map.get(copy.next);
			map.get(copy).random = map.get(copy.random);
			copy = copy.next;
		}
		
		return map.get(head);
	}
	
	/*CustomLinkedList createDeepCopy(CustomLinkedList head){
		CustomLinkedList headCopy1 = head;
		CustomLinkedList headCopy2 = head;
		CustomLinkedList headCopy3 = head;
		CustomLinkedList headCopy4 = headCopy3;
		
		CustomLinkedList returnCopy1 = createNode(-1);
		CustomLinkedList returnCopy2 = returnCopy1;
		CustomLinkedList returnCopy3 = returnCopy1;
		CustomLinkedList returnCopy4 = returnCopy1;
		CustomLinkedList returnCopy5 = returnCopy1;
		
		while(headCopy1!=null){
			returnCopy1.next = createNode(headCopy1.val);
			returnCopy1 = returnCopy1.next;
			headCopy1 = headCopy1.next;
		}
		
		returnCopy2 = returnCopy2.next;
		while(returnCopy2!=null){
			returnCopy2.random = headCopy2;
			returnCopy2 = returnCopy2.next;
			headCopy2 = headCopy2.next;
		}
		
		returnCopy3 = returnCopy3.next;
		CustomLinkedList temp = null;
		while(headCopy3!=null && returnCopy3!=null && temp!=null){
			temp = headCopy3.next;
			headCopy3.next = returnCopy3;
			returnCopy3 = returnCopy3.next;
			headCopy3 = temp.next;
		}
		
		print(headCopy4);
		
		returnCopy4 = returnCopy4.next;
		while(returnCopy4!=null){
			returnCopy4.random = returnCopy4.random.random.next;
			returnCopy4 = returnCopy4.next;
		}
		
		return returnCopy5.next;
	}*/

	public static void main(String[] args) {
		DeepCopyOfRandomizedArray d = new DeepCopyOfRandomizedArray();
		CustomLinkedList one = d.createNode(1);
		CustomLinkedList two = d.createNode(2);
		CustomLinkedList three = d.createNode(3);
		CustomLinkedList four = d.createNode(4);
		CustomLinkedList five = d.createNode(5);
		
		one.next = two;
		two.next = three;
		three.next = four;
		four.next = five;
		
		one.random = three;
		two.random = four;
		three.random = five;
		four.random = one;
		five.random = two;

		d.print(one);
		System.out.println(" ");
		CustomLinkedList deepCopyHead = d.createDeepCopy(one);
		d.print(deepCopyHead);
	}

}
