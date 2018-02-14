import java.util.HashMap;
import java.util.Map;

class LFUCache {
    Map<Integer,DLinkedNode>cache=new HashMap<>();
    int capacity, cacheSize;
    DLinkedNode head, tail;

    public LFUCache(int capacity) {
        this.capacity=capacity;
        head=new DLinkedNode();
        tail=new DLinkedNode();
        head.next=tail;
        tail.previous=head;
    }
    
    class DLinkedNode{
        int key, value;
        DLinkedNode next, previous;
    }
    
    private void addNode(DLinkedNode node){
        DLinkedNode nextNode = head.next;
        head.next=node;
        node.next=nextNode;
        node.previous=head;
        nextNode.previous=node;
    }
    
    private void removeNode(DLinkedNode node){
        DLinkedNode nextNode = node.next;
        DLinkedNode previousNode = node.previous;
        nextNode.previous=previousNode;
        previousNode.next=nextNode;
    }
    
    private void moveToHead(DLinkedNode node){
        removeNode(node);
        addNode(node);
    }
    
    private DLinkedNode removeTail(){
        DLinkedNode tailNode = tail.previous;
        removeNode(tailNode);
        return tailNode;
    }
    
    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if(node==null){
            return -1;
        }else{
            moveToHead(node);
            return node.value;
        }
    }
    
    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);
        if(node==null){
            DLinkedNode newNode = new DLinkedNode();
            newNode.key=key;
            newNode.value=value;
            addNode(newNode);
            cache.put(key,newNode);
            cacheSize++;
            
            if(cacheSize>capacity){
                DLinkedNode tailNode = removeTail();
                cache.remove(tailNode.key);
                cacheSize--;
            }
        }else{
            node.value=value;
            moveToHead(node);
        }
    }
    
    public static void main(String[] args) {
    	LFUCache obj = new LFUCache(2);
    	 obj.put(1,1);
    	 obj.put(2,2);
    	 System.out.println(obj.get(1));
    	 obj.put(3,3);
    	 System.out.println(obj.get(2));
    	 System.out.println(obj.get(3));
	}
}