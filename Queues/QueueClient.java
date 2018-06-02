package Queues;

public class QueueClient {

	public static void main(String[] args) throws Exception {
		Queue queue= new Queue();
		queue.enqueue(10);
		queue.enqueue(20);
		queue.enqueue(40);
		queue.enqueue(50);
		queue.enqueue(60);
		
		queue.display();
  //	queue.dequeue();
		
	//	queue.display();
		
		Queue helper= new Queue();
		
		//ActualReverse(queue);
		displayReverse(queue, helper,0);
		System.out.println();
		queue.display();
		
	//	queue.display();

	}
	
	
	public static void ActualReverse(Queue q) throws Exception {
		if(q.isEmpty()) {
			return ;
		}
		
		int n= q.dequeue();
		
		ActualReverse(q);
		
		q.enqueue(n);
		
		
	}
	
	public static void displayReverse(Queue q, Queue helper, int cnt) throws Exception {
		 if(q.isEmpty()) {
			 return ;
		 }
		 int n= q.dequeue();
		 
		 displayReverse(q, helper, cnt+1);
		 
		 System.out.print(n+" ");
		 
		 helper.enqueue(n);
		 
		 if(cnt == 0)
		 Reverse(q,helper);
		 
	}
	
	public static void Reverse(Queue q, Queue helper) throws Exception {
		 if(helper.isEmpty()) {
			 return ;
		 }
		 
		 int n = helper.dequeue();
		 
		 Reverse(q, helper);
		 
		 q.enqueue(n);
	}

}
