package DP;

import java.util.Scanner;

public class Subset {

	public static void main(String[] args) {
		Scanner pop = new Scanner(System.in);

		int n = pop.nextInt();

		int sum = pop.nextInt();

		int array[] = new int[n];

		for (int i = 0; i < array.length; i++) {
			array[i] = pop.nextInt();
		}

		boolean ans = Subsets(sum, array);
		if (ans) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}

	}

	public static boolean Subsets(int sum, int[] arr) {
		boolean[][] strg = new boolean[arr.length][sum + 1];

		int nr = arr.length;
		int nc = sum + 1;

		for (int row = 0; row < nr; row++) {
			for (int col = 0; col < nc; col++) {
				if (col == 0 || col == arr[row] ) {
					strg[row][col] = true;
				} else if (col < arr[row] && row>0) {
					strg[row][col] = strg[row - 1][col];
				} else if(col>arr[row] && row>0) {
					strg[row][col] = strg[row - 1][col - arr[row]] || strg[row-1][col];
				}

			}
		}
		return strg[nr-1][nc - 1];
	}
}
