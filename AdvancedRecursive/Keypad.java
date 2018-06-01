package recursion2;

import java.util.Scanner;

public class Keypad {

	public static void main(String[] args) {
		Scanner pop= new Scanner(System.in);
		
		String str=pop.nextLine();
		 System.out.println(KPC1(str, ""));
		KPC(str,"");

	}
	public static String getCode(char ch) {
		if (ch == '1') {
			return "abc";
		} else if (ch == '2') {
			return "def";
		} else if (ch == '3') {
			return "ghi";
		} else if (ch == '4') {
			return "jk";
		} else if (ch == '5') {
			return "lmno";
		} else if (ch == '6') {
			return "pqr";
		} else if (ch == '7') {
			return "stu";
		} else if (ch == '8') {
			return "vwx";
		} else if (ch == '9') {
			return "yz";
		} else if (ch == '0') {
			return "@#";
		} else
			return "";
	}
  public static void KPC(String str, String ans) {
	  if(str.length()==0) {
		  System.out.print(ans+" ");
		  return ;
	  }
	  
	  char ch=str.charAt(0);
	  
	  String ros=str.substring(1);
	  
	    String code=getCode(ch);
	    
	    for(int i=0; i<code.length(); i++) {
	    	KPC(ros, ans+code.charAt(i));
	    }
  }
  public static int KPC1(String str, String ans) {
	  if(str.length()==0) {
		 return 1;
	  }
	  
	  char ch=str.charAt(0);
	  
	  String ros=str.substring(1);
	  
	    String code=getCode(ch);
	    
	    int res=0;
	    for(int i=0; i<code.length(); i++) {
	    	res+=KPC1(ros, ans+code.charAt(i));
	    }
	    return res;
  }
}
