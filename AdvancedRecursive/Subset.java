package recursion2;

import java.util.Scanner;

public class Subset {

	public static void main(String[] args) {
		Scanner pop= new Scanner(System.in);
		int n=pop.nextInt();
		
		int []arr= new int[n];
		for(int i=0; i<arr.length; i++) {
			arr[i]=pop.nextInt();
		}
		int target=pop.nextInt();
		
		int ans=SubsetProblems(arr, 0, target, "");
		System.out.println(ans);
		SubsetProblem(arr,0,target,"");

	}
  public static void SubsetProblem(int []arr,int vidx, int target, String asf) {
	  if(vidx==arr.length) {
		  if(target==0) {
			  System.out.print(asf+" ");
		  }
		  return ;
	  }
	  SubsetProblem(arr, vidx+1, target-arr[vidx], asf+arr[vidx]+" ");
	  SubsetProblem(arr, vidx+1, target, asf);
  }
  public static int SubsetProblems(int []arr,int vidx, int target, String asf) {
	  if(vidx==arr.length) {
		  if(target==0) {
			  return 1;
		  }
		  return 0;
	  }
	  int res=0;
	  res+=SubsetProblems(arr, vidx+1, target-arr[vidx], asf+arr[vidx]+" ");
	  res+= SubsetProblems(arr, vidx+1, target, asf);
	 return res;
  }
}
