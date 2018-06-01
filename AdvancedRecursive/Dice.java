package recursion2;

import java.util.Scanner;

public class Dice {

	public static void main(String[] args) {
		Scanner pop= new Scanner(System.in);
		
		int n=pop.nextInt();
		int m=pop.nextInt();
		
		System.out.println(DiceProblem1(0, n, m, ""));
		DiceProblem(0,n,m,"");

	}
  public static void DiceProblem(int curr, int end, int faces, String ans) {
	  if(curr>end) {
		  return;
	  }
	  if(curr==end) {
		  System.out.print(ans+" ");
		  return ;
	  }
	  
	  for(int dice=1; dice<=faces; dice++) {
		  DiceProblem(curr+dice, end, faces, ans+dice);
	  }
  }
  public static int DiceProblem1(int curr, int end, int faces, String ans) {
	  if(curr>end) {
		  return 0;
	  }
	  if(curr==end) {
		  return 1;
	  }
	  
	  int res=0;
	  for(int dice=1; dice<=faces; dice++) {
		 res+= DiceProblem1(curr+dice, end, faces, ans+dice);
	  }
	  return res;
  }
}
