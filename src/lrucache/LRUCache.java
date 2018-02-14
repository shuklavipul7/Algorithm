package lrucache;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
	DLinkedNode head, tail;
	Map<Integer,DLinkedNode>cache=new HashMap<>();
	int capacity;
	int cacheSize=0;
	
	public LRUCache(int capacity){
		head=new DLinkedNode();
		tail=new DLinkedNode();
		this.capacity=capacity;
		
		head.next=tail;
		tail.previous=head;
	}
	
	class DLinkedNode{
		int key, value;
		DLinkedNode next, previous;
	}
	
	private void addNode(DLinkedNode node){
		DLinkedNode nextNode=head.next;
		
		head.next=node;

		node.previous=head;
		node.next=nextNode;
		
		nextNode.previous=node;
	}
	
	private void removeNode(DLinkedNode node){
		node.previous.next=node.next;
		node.next.previous=node.previous;
	}
	
	private void moveToHead(DLinkedNode node){
		removeNode(node);
		addNode(node);
	}
	
	private int removeTail(){
		DLinkedNode tailNode = tail.previous;
		removeNode(tailNode);
		return tailNode.key;
	}
	
	public void put(int key, int value){
		DLinkedNode node = cache.get(key);
		if(node!=null){
			node.value = value;
			moveToHead(node);
		}else{
			DLinkedNode newNode = new DLinkedNode();
			newNode.key = key;
			newNode.value = value;
			
			addNode(newNode);
			cache.put(key, newNode);
			cacheSize++;
			
			if(cacheSize>capacity){
				int keyOfTail = removeTail();
				cache.remove(keyOfTail);
				cacheSize--;
			}
		}
	}
	
	public int get(int key){
		DLinkedNode node = cache.get(key);
		if(node!=null){
			moveToHead(node);
			return node.value;
		}else{
			return -1;
		}
	}

}
