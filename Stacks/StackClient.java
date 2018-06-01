package Stacks;

public class StackClient {

	public static void main(String[] args) throws Exception {
		Stack stack = new Stack();
		stack.push(10);
		stack.push(20);
		stack.push(30);
		stack.push(40);
		stack.push(50);
		
		stack.display();
	  
		System.out.println("Display Reverse");
	   displayReverse(stack);
	    System.out.println();
	    Stack helper = new Stack(stack.size());
	    
	    System.out.println("Actual Reverse");
	    ActualReverse(stack,helper);
	    stack.display();
	    
	}

	public static void displayReverse(Stack s) throws Exception {
		 if(s.isEmpty()) { 
			 return ;
		 }
		
		  int rv= s.pop();
		 
		 displayReverse(s);
		 
		 System.out.print(rv+" ");
		 
		 s.push(rv); 
		 		 
	}
	
	public static void ActualReverse(Stack s, Stack helper) throws Exception {
		if(s.isEmpty()) {
		   Reverse(s,helper);	
			return ;
		}
		
		int n= s.pop();
		
		helper.push(n);
		
		ActualReverse(s, helper);
		
		
		
	}
	public static void Reverse(Stack s, Stack helper) throws Exception {
		 if(helper.isEmpty()) {
			 return ;
		 }
		 int n=helper.pop();
		 
		 Reverse(s,helper);
		 
		 s.push(n);
	}
}
