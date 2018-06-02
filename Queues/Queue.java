package Queues;

public class Queue {
	
	protected int front;
	private int size;
	protected int [] data;
	
	public Queue() {
		this(20);
	}
	
	public Queue(int cap) {
		this.front=0;
		this.data= new int[cap];
		this.size=0;
	}
	
	public void enqueue(int item) throws Exception {
		if(this.size == this.data.length) {
			throw new Exception("Queue is the full");
		}
		int idx=(this.front+this.size)% this.data.length;
		this.data[idx]=item;
		this.size++;
	}
	public int dequeue() throws Exception {
		if(isEmpty()) {
			throw new Exception("Queue is the empty");
		}
		int rv=this.data[this.front];
		this.front=(this.front+1)%this.data.length;
		this.size--;
		
		return rv;
	}
	public int getFirst() throws Exception {
		if(isEmpty()) {
			throw new Exception("Queue is the full");
		}
		int n=this.data[this.front];
		
		return n;
	}
	
	public boolean isEmpty() {
		return this.size == 0;
	}
	
	public int size() {
		return this.size;
	}
	
	public void display() {
		
		for(int i=0; i<this.size; i++) {
			int idx=(i+this.front) % this.data.length;
			System.out.print(this.data[idx]+" ");
		}
		System.out.println();
	}

}
