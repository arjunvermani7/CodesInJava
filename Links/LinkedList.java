package Links;

public class LinkedList {

	 class Node {
		 int data;
		 
		 Node next;
	 }
 private Node head;
 private Node tail;
 private int size;
 
  public int size() {
	  return this.size;
  }
  
  public boolean isEmpty() {
	  return this.size ==0;
  }
  
   public int getFirst() throws Exception {
	   
	   if(this.size == 0) {
		   throw new Exception ("LL is empty");
	   }
	   
	   return this.head.data;
   }
   
 public int getLast() throws Exception {
	   
	   if(this.size == 0) {
		   throw new Exception ("LL is empty");
	   }
	   
	   return this.tail.data;
   }
 
   public void addLast(int item) {	
	   
	   Node nn = new Node();
	   
	   nn.data=item;
	   nn.next=null;
	   
	   if(this.size == 0) { 
		   this.head=nn;
		   this.tail=nn;
		   this.size++;
	   } else {
		   this.tail.next=nn;
		   this.tail=nn;
		   this.size++;
	   }
	   
   }
   
   public void addFirst(int item) {
	   Node nn = new Node();
	   
	   nn.data=item;
	   nn.next=null;
	   
	   if(this.size > 0) {
		   
	   nn.next=this.head;
	   this.head=nn;
	   this.size++;
	   
	   } else {
		   this.head=nn;
		   this.tail=nn;
		   this.size++;
	   }
   }
    private Node getNodeAt (int idx) throws Exception {
    	
    	if(this.size == 0) {
    		throw new Exception ("LL is empty");
    	}
    	
    	if(idx <0 || idx >= this.size) {
    		throw new Exception ("Index out of range");
    	}
    	
    	Node temp =this.head;
    	
    	for(int i=0; i<idx; i++) {
    		temp=temp.next;
    	}
    	
    	return temp;	
    }
     public int getAt (int idx) throws Exception {
    	
    	if(this.size == 0) {
    		throw new Exception ("LL is empty");
    	}
    	
    	if(idx <0 || idx >= this.size) {
    		throw new Exception ("Invalid Index");
    	}
    	
    	Node temp =this.head;
    	
    	for(int i=0; i<idx; i++) {
    		temp=temp.next;
    	}
    	
    	return temp.data;	
    }
    
    public void addAt(int item, int idx) throws Exception {
    	
    	if(idx < 0 || idx > this.size) {
    		throw new Exception ("Index out of range");
    	}
    	
    	if(idx == 0) {
    		addFirst(item);
    	} else if( idx == this.size) {
    		addLast(item);
    	} else {
    		Node nn = new Node();
    		
    		nn.data=item;
    		
    		nn.next=null;
    		
    		Node ni = getNodeAt(idx);
    		
    		Node nm1=getNodeAt(idx-1);
    		
    		nm1.next=nn;
    		nn.next=ni;
    		this.size++;
    	}
    }
    
    public void display() {
    	
    	Node temp =this.head;
    	
    	for(int i=0; i<this.size; i++) {
    		System.out.print(temp.data+"-->");
    		temp=temp.next;
    	}
    	System.out.println();
    }
    public int removeFirst() throws Exception {
    	if(isEmpty()) {
    		throw new Exception ("LL empty");
    	}
    	Node temp= this.head;
    	
    	if(this.size == 1) {
    		this.head=null;
    		this.tail=null;
    		this.size=0;
    	} else {
    	
    	this.head=temp.next;
    	
    	temp.next=null;
    	
    	this.size--;
    	}
    	return temp.data;
    }
    
    public int removeLast() throws Exception {
    	if(isEmpty()) {
    		throw new Exception("LL Empty");
    	}
    	Node temp =this.tail;
    	
    	if(this.size == 1) {
    		this.head=null;
    		this.tail= null;
    		this.size=0;
    	} else {
    		Node nm1= getNodeAt(this.size-2);
    		this.tail=nm1;
    		this.tail.next= null;
    		this.size--;
    	}
    	
    	return temp.data;
    }
    public int removeAt(int idx) throws Exception {
    	if(isEmpty()) {
    		throw new Exception ("LL is the empty");
    	}
    	if(idx <0 || idx>=this.size) {
    		throw new Exception("Invalid Index");
    	}
    	if(idx ==0) {
    		return removeFirst();
    	} else if(idx == this.size-1) {
    		return removeLast();
    	} else {
    		Node temp= this.head;
    		
    		for(int i=0; i<idx; i++) {
    			temp=temp.next;
    		}
    		
    		Node nm1= getNodeAt(idx-1);
    		Node np1= getNodeAt(idx+1);
    		
    		nm1.next=np1;
    		this.size--;
    		
    		return temp.data;
    	}
    }
}
