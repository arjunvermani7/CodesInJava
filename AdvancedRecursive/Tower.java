package recursion2;

import java.util.Scanner;

public class Tower {

	public static void main(String[] args) {
		Scanner pop= new Scanner(System.in);
		
		int nDiscs=pop.nextInt();
		
	 int ans= TowerofHanoi(nDiscs ,"T1","T2","T3");
	 System.out.println(ans-1);

	}
  public static int TowerofHanoi(int n, String src, String dest, String helper) {
	  if(n==0) {
		  return 1;
	  }
	  int res=0;
	   res+= TowerofHanoi(n-1, src, helper, dest);
	  
	  System.out.println("Move "+n+"th disc from "+src+" to "+dest);
	  
	  res+=TowerofHanoi(n-1, helper, dest, src);
	  
	  return res;
  }
}
