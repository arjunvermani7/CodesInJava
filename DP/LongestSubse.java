package DP;

import java.util.Scanner;

public class LongestSubse {

	public static void main(String[] args) {
		Scanner pop= new Scanner(System.in);
		
		String str1=pop.nextLine();
		
		String str2=pop.nextLine();
		
		System.out.println(LongestSubsequence(str1, str2));

	}
	
	public static int LongestSubsequence(String s1, String s2) {
		
		int [][] strg= new int[s1.length()+1][s2.length()+1];
		int nr=s1.length()+1;
		int nc=s2.length()+1;
		
		for(int row=1; row<nr; row++) {
			for(int col=1; col<nc; col++) {
				if(s1.charAt(row-1)== s2.charAt(col-1)) {
					strg[row][col]=strg[row-1][col-1]+1;
				}else {
					int left=strg[row][col-1];
					int right=strg[row-1][col];
					
					int max= Math.max(left, right);
					strg[row][col]=max;
				}
			}
		}
		
		return strg[nr-1][nc-1];
		
	}

}
