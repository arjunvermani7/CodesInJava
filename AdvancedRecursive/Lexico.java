package recursion2;

import java.util.Scanner;

public class Lexico {

	public static void main(String[] args) {
		Scanner pop= new Scanner(System.in);
		int n=pop.nextInt();
		
		Lexicographical(0,n);

	}
  public static void Lexicographical(int curr, int end) {
	  if(curr>end) {
		
		  return ;
	  }
	  System.out.print(curr+" ");
	  if(curr==0) {
		  for(int i=1; i<=9; i++) {
			  Lexicographical(curr*10+i, end);
		  }
	  } else {
		  for(int i=0; i<=9; i++) {
			  Lexicographical(curr*10+i, end);
		  }
	  }
  }
}
