package DP;

import java.util.ArrayList;
import java.util.Scanner;

import javax.sound.midi.Synthesizer;

public class DPdemos {

	public static void main(String[] args) {
		Scanner pop = new Scanner(System.in);

//		int n = pop.nextInt();
//		System.out.println(fibonacciRBtr(n, new int[n + 1]));
//		System.out.println(fibonacciSlide(n));
		// System.out.println(BoardPath(0, 10));
//		System.out.println(BoardPathSLide(n));
//		System.out.println(MazePath(0, 0, n, n, new int[n + 1][n + 1]));
//		System.out.println(MazePathI(n, n));
//		System.out.println(MazePathSLider(3, 4));
//		System.out.println(MazePathSLiderBUdia(3, 4));
//		System.out.println(LCSBU("abcd", "agcfd"));
//		System.out.println(EditDistance("saturday", "sunday"));
//		System.out.println(EditDistanceBU("Saturday", "Sunday"));
		int []arr= {1,2,3,4,5,6,7};
		System.out.println(MCM(arr, 0, arr.length-1, new int[arr.length][arr.length]));
//		System.out.println(MCMBU(arr));
		int []wt= {1,3,4,5,7};
		int []price= {1,4,5,7,7};
		System.out.println(Knapsack(wt, price, 0, 7, new int[w bt.length][8]));
		System.out.println(knapsackBU(wt, price, 7));
	}

	public static int fibonacciRBtr(int n, int[] memo) {
		if (n == 0 || n == 1) {
			return n;
		}
		if (memo[n] != 0)
			return memo[n];
		int fbn1 = fibonacciRBtr(n - 1, memo);
		int fbn2 = fibonacciRBtr(n - 2, memo);

		int fib = fbn1 + fbn2;

		memo[n] = fib;

		return fib;
	}

	public static int fibonacciI(int n) {
		int[] memo = new int[n + 1];

		memo[0] = 0;
		memo[1] = 1;

		for (int i = 2; i <= n; i++) {
			memo[i] = memo[i - 1] + memo[i - 2];
		}
		return memo[n];
	}

	public static int fibonacciSlide(int n) {
		int[] memo = new int[2];
		memo[0] = 0;
		memo[1] = 1;

		int temp = 0;
		for (int i = 2; i <= n; i++) {
			temp = memo[0] + memo[1];
			memo[0] = memo[1];
			memo[1] = temp;
		}
		return memo[1];
	}

	public static int BoardPath(int curr, int end, int[] memo) {
		if (curr == end) {
			return 1;
		}
		if (curr > end) {
			return 0;
		}
		if (memo[curr] != 0)
			return memo[curr];

		int res = 0;
		for (int dice = 1; dice <= 6; dice++) {

			res += BoardPath(curr + dice, end, memo);

		}
		memo[curr] = res;
		return res;
	}

	public static int BoardPathBU(int n) {
		int[] memo = new int[n + 6];

		memo[n] = 1;

		for (int i = n - 1; i >= 0; i--) {
			memo[i] = memo[i + 1] + memo[i + 2] + memo[i + 3] + memo[i + 4] + memo[i + 5] + memo[i + 6];
		}

		return memo[0];
	}

	public static int BoardPathSLide(int n) {
		int[] memo = new int[6];

		memo[0] = 1;
		int temp = 0;
		for (int i = 1; i <= n; i++) {
			temp = memo[0] + memo[1] + memo[2] + memo[3] + memo[4] + memo[5];
			memo[5] = memo[4];
			memo[4] = memo[3];
			memo[3] = memo[2];
			memo[2] = memo[1];
			memo[1] = memo[0];
			memo[0] = temp;
		}
		return memo[0];
	}

	public static int MazePath(int cr, int cc, int er, int ec, int[][] memo) {

		if (cr == er && cc == ec) {
			return 1;
		}
		if (cr > er || cc > ec) {
			return 0;
		}
		if (memo[cr][cc] != 0)
			return memo[cr][cc];

		int vh = MazePath(cr, cc + 1, er, ec, memo);

		int ch = MazePath(cr + 1, cc, er, ec, memo);

		memo[cr][cc] = vh + ch;

		return memo[cr][cc];

	}

	public static int MazePathI(int er, int ec) {
		int[][] memo = new int[er + 1][ec + 1];

		for (int row = er; row >= 0; row--) {
			for (int col = ec; col >= 0; col--) {
				if (row == er || col == ec) {
					memo[row][col] = 1;
				} else {
					int cc = memo[row][col + 1];
					int cr = memo[row + 1][col];
					memo[row][col] = cr + cc;
				}
			}
		}
		return memo[0][0];
	}

	public static int MazePathSLider(int er, int ec) {
		int[] memo = new int[ec + 1];

		for (int i = 0; i < memo.length; i++) {
			memo[i] = 1;
		}
		for (int j = 0; j < er; j++) {
			memo[ec] = 1;
			for (int k = ec - 1; k >= 0; k--) {
				memo[k] = memo[k] + memo[k + 1];
			}
		}

		return memo[0];
	}

	public static int MazePathSLiderBUdia(int er, int ec) {
		int[] memo = new int[ec + 1];

		for (int i = 0; i < memo.length; i++) {
			memo[i] = 1;
		}
		int diag = 0;
		for (int row = 0; row < er; row++) {
			for (int col = ec; col >= 0; col--) {
				if (col == ec) {
					memo[col] = 1;
					diag = 1;
				} else {
					int val = memo[col] + memo[col + 1] + diag;
					diag = memo[col];
					memo[col] = val;
				}
			}
		}

		return memo[0];
	}

	public static int LCS(String s1, String s2) {
		if (s1.length() == 0 || s2.length() == 0) {
			return 0;
		}
		char ch1 = s1.charAt(0);
		char ch2 = s2.charAt(0);

		String ros1 = s1.substring(1);
		String ros2 = s2.substring(1);
		int ans = 0;
		if (ch1 == ch2) {
			ans = LCS(ros1, ros2) + 1;
		} else {
			int c1 = LCS(ros1, s2);
			int c2 = LCS(s1, ros2);

			ans = Math.max(c1, c2);
		}
		return ans;
	}

	public static int LCSBU(String s1, String s2) {
		int[][] memo = new int[s1.length() + 1][s2.length() + 1];

		for (int i = s1.length() - 1; i >= 0; i--) {
			for (int j = s2.length() - 1; j >= 0; j--) {
				if (s1.charAt(i) == s2.charAt(j)) {
					memo[i][j] = memo[i + 1][j + 1] + 1;
				} else {
					memo[i][j] = Math.max(memo[i + 1][j], memo[i][j + 1]);
				}
			}
		}
		return memo[0][0];
	}

	public static int EditDistance(String s1, String s2) {
		if (s1.length() == 0 && s2.length() != 0) {
			return s2.length();
		}
		if (s1.length() != 0 && s2.length() == 0) {
			return s1.length();
		}
		if (s1.length() == 0 && s2.length() == 0) {
			return 0;
		}

		char ch1 = s1.charAt(0);
		char ch2 = s2.charAt(0);

		String ros1 = s1.substring(1);
		String ros2 = s2.substring(1);

		int ans = 0;
		if (ch1 == ch2) {
			ans = EditDistance(ros1, ros2);
		} else {
			int in = EditDistance(ros1, s2);
			int del = EditDistance(s1, ros2);
			int re = EditDistance(ros1, ros2);

			ans = Math.min(in, Math.min(del, re)) + 1;
		}
		return ans;
	}

	public static int EditDistanceBU(String s1, String s2) {

		int[][] strg = new int[s1.length() + 1][s2.length() + 1];

		for (int row = s1.length(); row >= 0; row--) {
			for (int col = s2.length(); col >= 0; col--) {
				if (row == s1.length()) {
					strg[row][col] = s2.length() - col;
					continue;
				}
				if (col == s2.length()) {
					strg[row][col] = s1.length() - row;
					continue;
				}

				else if (s1.charAt(row) == s2.charAt(col)) {
					strg[row][col] = strg[row + 1][col + 1];
				} else {
					int ins = strg[row][col + 1];
					int del = strg[row + 1][col];
					int re = strg[row + 1][col + 1];
					strg[row][col] = Math.min(ins, Math.min(del, re)) + 1;
				}
			}
		}
		return strg[0][0];
	}

	public static int MCM(int[] arr, int si, int ei, int[][] strg) {
		if (si + 1 == ei) {
			return 0;
		}
		
		if(strg[si][ei]!=0) {
			return strg[si][ei];
		}
		int min = Integer.MAX_VALUE;
		for (int k = si + 1; k <= ei - 1; k++) {
			int fh = MCM(arr, si, k, strg);
			int sh = MCM(arr, k, ei, strg);
			int sw = arr[si] * arr[k] * arr[ei];

			int ans = fh + sh + sw;
			if (ans < min) {
				min=ans;
			}
			
		}
		strg[si][ei]=min;
		return min;

	}
	public static int MCMBU(int []arr) {
		int n=arr.length;
		
		int [][]strg= new int[n][n];
		
		for(int slide=2; slide<=n-1; slide++) {
			for(int si=0; si<=n-slide-1; si++) {
				int ei=si+slide;
				int min = Integer.MAX_VALUE;
				for (int k = si + 1; k <= ei - 1; k++) {
					int fh = strg[si][k];
					int sh = strg[k][ei];
					int sw = arr[si] * arr[k] * arr[ei];

					int ans = fh + sh + sw;
					if (ans < min) {
						min=ans;
					}
					
				}
				strg[si][ei]=min;
				
			}
			
		}
		return strg[0][n-1];
	}
	public static int Knapsack(int []wt, int []price, int vidx, int cap, int[][]strg) {
		if(vidx==price.length) {
			return 0;
		}
		if(strg[vidx][cap]!=0) {
			return strg[vidx][cap];
		}
		
		int include=0;
		int exclude=0;
		if(wt[vidx]<=cap) {
		include=price[vidx]+Knapsack(wt, price, vidx+1, cap-wt[vidx], strg);
		}
		exclude= Knapsack(wt, price, vidx+1, cap, strg);
		int max= Math.max(include, exclude);
		
		return max;
		
	}
	public static int knapsackBU(int []wt, int[]price,int cap) {
		int nr= wt.length+1;
		int nc= cap+1;
		
		int[][]strg= new int[nr][nc];
		
		for(int row=1; row<nr; row++) {
			for(int col=1; col<nc; col++) {
				if(wt[row-1]>col) {
					strg[row][col]=strg[row-1][col];
				} else {
					int incl= price[row-1]+ strg[row-1][col-wt[row-1]];
					int excl= strg[row-1][col];
					int max= Math.max(incl, excl);
					strg[row][col]=max;
				}
			}
		}
		return strg[nr-1][nc-1];
	}
}