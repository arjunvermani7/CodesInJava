package recursion2;

import java.util.Scanner;

public class queen {

	public static void main(String[] args) {
		
	  Scanner pop= new Scanner(System.in);
	  int n=pop.nextInt();
	  
	  boolean [][]board=new boolean[n][n];
	  
	 int ans= Nqueen(board,0,"");
	  System.out.println(ans);
	    Nqueens(board,0,"");

	}
	public static int Nqueen(boolean[][] board, int row, String asf) {
		if(row==board.length) {
		//	System.out.println(asf+" ");
			return 1;
		}
		
		int res=0;
		for(int col=0; col<board[0].length; col++) {
			if(isItSafe(board, row, col)) {
				board[row][col]=true;
				res+=  Nqueen(board, row+1, asf+"{"+row+"-"+col+"}");
				board[row][col]=false;	
			}
		}
		return res;
	}
	public static void Nqueens(boolean[][] board, int row, String asf) {
		if(row==board.length) {
			System.out.print(asf+" ");
			return ;
		}
		
		
		for(int col=0; col<board[0].length; col++) {
			if(isItSafe(board, row, col)) {
				board[row][col]=true;
				  Nqueens(board, row+1, asf+"{"+(row+1)+"-"+(col+1)+"}"+" ");
				board[row][col]=false;	
			}
		}
		
	}
  public static boolean isItSafe(boolean[][]board, int row, int col) {
	  int r=row;
	  int c=col;
	  while(r>=0) {
		  if(board[r][c]==true) {
			  return false;
		  }
		  r--;
	  }
	  r=row;
	  c=col;
	   while(r>=0 && c>=0) {
		   if(board[r][c]==true) {
			   return false;
		   }
		   r--;
		   c--;
	   }
	   r=row;
	   c=col;
	    while(r>=0 && c<board[0].length) {
	    	if(board[r][c]==true) {
	    		return false;
	    	}
	    	r--;
	    	c++;
	    }
	    
	    return true;
  }
}
