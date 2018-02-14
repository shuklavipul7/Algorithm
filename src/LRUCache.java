import java.util.HashMap;
import java.util.Map;

public class LRUCache {
	private Map<Integer,DLinkedNode>cache=new HashMap<>();
	DLinkedNode head,tail;
	int count,capacity;

	public LRUCache(int capacity){
		this.capacity=capacity;
		
		head = new DLinkedNode();
		tail = new DLinkedNode();
		head.next = tail;
		tail.previous = head;
	}
	
	class DLinkedNode{
		int key;
		int value;
		DLinkedNode previous;
		DLinkedNode next; 
	}
	
	private void addNode(DLinkedNode node){
		DLinkedNode nextNode = head.next;
		
		head.next=node;
		node.previous=head;
		
		node.next=nextNode;
		nextNode.previous=node;
	}
	
	private void removeNode(DLinkedNode node){
		DLinkedNode previousNode = node.previous;
		DLinkedNode nextNode = node.next;
		
		previousNode.next=nextNode;
		nextNode.previous=previousNode;
	}
	
	private void moveToHead(DLinkedNode node){
		removeNode(node);
		addNode(node);
	}
	
	private DLinkedNode removeTail(){
		DLinkedNode currentTail=tail.previous;
		removeNode(currentTail);
		return currentTail;
	}
	
	public int get(int key){
		DLinkedNode node = cache.get(key);
		if(node==null){
			return -1;
		}else{
			moveToHead(node);
			return node.value;
		}
	}
	
	public void set(int key, int value){
		DLinkedNode node = cache.get(key);
		if(node!=null){
			node.value=value;
			moveToHead(node);
		}else{
			DLinkedNode newNode = new DLinkedNode();
			newNode.key = key;
			newNode.value = value;
			
			addNode(newNode);
			cache.put(key, newNode);
			count++;
			
			if(count>capacity){
				DLinkedNode nodeRemoved = removeTail();
				cache.remove(nodeRemoved.key);
				count--;
			}
		}
		
	}

}
