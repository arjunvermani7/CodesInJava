package Links;

public class LinkedlistClient {

	public static void main(String[] args) throws Exception {
		LinkedList ll =new LinkedList ();
		
		ll.addLast(10);
		ll.addLast(20);
		ll.addLast(40);
		ll.addLast(50);
		ll.addLast(60);
		
		ll.display();
		
		ll.addAt(28, 2);
		ll.display();
	
		
		ll.removeFirst();
		ll.removeLast();
		ll.display();
		
		ll.addFirst(10);
		ll.display();
		
		System.out.println(ll.getAt(2));
		
		System.out.println(ll.getFirst());

	}

}
