package recursion2;

import java.util.Scanner;

public class subsequence {

	public static void main(String[] args) {
		Scanner pop= new Scanner(System.in);
		
		String str=pop.nextLine();
		
		int ans=Subsequence(str, "");
		System.out.println(ans);
		Subsequences(str,"");

	}
	public static void Subsequences(String str, String ans) {
		if(str.length()==0) {
			System.out.print(ans+" ");
			return;
		}
		char ch=str.charAt(0);
		String ros= str.substring(1);
		Subsequences(ros, ans);
		Subsequences(ros, ans+ch);
		Subsequences(ros, ans+(int)ch);
	}
	public static int Subsequence(String str, String ans) {
		if(str.length()==0) {
			
			return 1;
		}
		char ch=str.charAt(0);
		String ros= str.substring(1);
		int res=0;
		res+=Subsequence(ros, ans);
		res+=Subsequence(ros, ans+ch);
		res+=Subsequence(ros, ans+(int)ch);
		return res;
	}


}
