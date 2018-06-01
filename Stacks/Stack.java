package Stacks;

public class Stack {

	private int tos;
	protected int[] data;
	
	public Stack() {
		this(20);
	}
	
	public Stack(int cap) {
		this.tos=-1;
		this.data= new int[cap];
	}
	
	public void push(int item) throws Exception {
		if(this.size() == this.data.length) {
			throw new Exception ("Stack Full");
		}
		this.tos++;
		this.data[this.tos]=item;
		
	}
	public int pop() throws Exception {
		if(isEmpty()) {
			throw new Exception("Stack Empty");
		}
		int rv=this.data[this.tos];
		this.data[this.tos]=0;
		this.tos--;
		return rv;
	}
	
	public boolean isEmpty() {
		return this.size()==0;
	}
	
	public int size() {
		return this.tos+1;
	}
	public void display() {
		for(int i=this.tos; i>=0; i--) {
			System.out.print(this.data[i]+" ");
		}
		System.out.println();
	}
}
