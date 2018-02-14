import java.util.PriorityQueue;

public class PriorityQueueClass {

	public static void main(String[] args) {
		PriorityQueue pq = new PriorityQueue();
		pq.add(3);
		pq.add(8);
		pq.add(1);
		pq.add(5);
		
		
		
		while(!pq.isEmpty()){
			System.out.println(pq.poll());
		}
	}

}
