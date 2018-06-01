package recursion2;

import java.util.Scanner;

public class Snakes {

	public static void main(String[] args) {
		Scanner pop = new Scanner(System.in);
		int n = pop.nextInt();

		SnakesLadders(0, n, "");

	}

	public static void SnakesLadders(int curr, int end, String ans) {
		if (curr > end) {
			return;
		}
		if (curr == end) {
			System.out.println(ans);
			return;
		}
		for (int dice = 1; dice <= 6; dice++) {
			int cur = 2;
			for (int j = 2; j < cur; j++) {
                  if(cur%j==0) {
                	   
                  } else {
                	  
                  }
                  cur++;
			}
		}
	}
}
