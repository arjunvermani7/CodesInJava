package recursion2;

import java.util.Scanner;

public class Nknight {

	public static void main(String[] args) {
		Scanner pop = new Scanner(System.in);
		int n = pop.nextInt();

		boolean[][] board = new boolean[n][n];

		int ans=nKnight1(board, 0, 0, "", 0);
		System.out.println(ans);
		nKnight(board, 0, 0, "", 0);

	}

	public static int nKnight1(boolean[][] board, int row, int col, String asf, int kpsf) {
		if (kpsf == board.length) {
			return 1;
		}
         
		int res=0;
		for (int c = col; c < board[0].length; c++) {
			if (IsitSafe(board, row, c)) {
				board[row][c] = true;
				res+= nKnight1(board, row, c + 1, asf + "{" + row + "-" + c + "}"+" ", kpsf + 1);
				board[row][c] = false;
			}
		}
		for (int r = row + 1; r < board.length; r++) {
			for (int c = 0; c < board[0].length; c++) {
				if (IsitSafe(board, r, c)) {
					board[r][c] = true;
					res+= nKnight1(board, r, c + 1, asf + "{" + r + "-" + c + "}"+" ", kpsf + 1);
					board[r][c]=false;
				}
			}
		}
            return res;
	}

	public static void nKnight(boolean[][] board, int row, int col, String asf, int kpsf) {
		if (kpsf == board.length) {
			System.out.print(asf+" ");
			return;
		}

		for (int c = col; c < board[0].length; c++) {
			if (IsitSafe(board, row, c)) {
				board[row][c] = true;
				nKnight(board, row, c + 1, asf + "{" + row + "-" + c + "}"+" ", kpsf + 1);
				board[row][c] = false;
			}
		}
		for (int r = row + 1; r < board.length; r++) {
			for (int c = 0; c < board[0].length; c++) {
				if (IsitSafe(board, r, c)) {
					board[r][c] = true;
					nKnight(board, r, c + 1, asf + "{" + r + "-" + c + "}"+" ", kpsf + 1);
					board[r][c]=false;
				}
			}
		}

	}

	public static boolean IsitSafe(boolean[][] board, int row, int col) {
		int r = row;
		int c = col;

		while (r >= 0 && c >= 0) {
			if (board[r][c] == true) {
				return false;
			}
			r -= 2;
			c--;
		}
		r = row;
		c = col;
		while (r >= 0 && c >= 0) {
			if (board[r][c] == true) {
				return false;
			}
			r--;
			c -= 2;
		}
		r = row;
		c = col;
		while (r < board.length && c >= 0) {
			if (board[r][c] == true) {
				return false;
			}
			r++;
			c -= 2;
		}
		r = row;
		c = col;
		while (r < board.length && c >= 0) {
			if (board[r][c] == true) {
				return false;
			}
			r += 2;
			c--;
		}
		r = row;
		c = col;
		while (r < board.length && c < board[0].length) {
			if (board[r][c] == true) {
				return false;
			}
			r += 2;
			c++;
		}

		r = row;
		c = col;
		while (r < board.length && c < board[0].length) {
			if (board[r][c] == true) {
				return false;
			}
			r++;
			c += 2;
		}
		r = row;
		c = col;
		while (r >= 0 && c < board[0].length) {
			if (board[r][c] == true) {
				return false;
			}
			r--;
			c += 2;
		}
		r = row;
		c = col;
		while (r >= 0 && c < board[0].length) {
			if (board[r][c] == true) {
				return false;
			}
			r -= 2;
			c++;
		}
		return true;

	}
}
