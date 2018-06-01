package recursion2;

import java.util.Scanner;

public class Maze {

	public static void main(String[] args) {
		Scanner pop= new Scanner(System.in);
		int N=pop.nextInt();
		
		
		String ans="";
		
		int an=Maze2D(1, 1, N, N,N+1);
		System.out.println(an);
		
		MazeD(1,1,N,N,ans,N+1);

	}
	public static void MazeD(int cr, int cc, int er, int ec, String ans,int N) {
		if(cr>er||cc>ec) {
			return;
		}
		if(cr==er && cc==ec) {
			System.out.print(ans+" ");
			return ;
		}
		
		
		MazeD(cr+1, cc, er, ec, ans+'V',N);
		
		MazeD(cr, cc+1, er, ec, ans+'H',N);
		if (cr==cc ||cr+cc==N )
		MazeD(cr+1, cc+1, er, ec, ans+'D',N);
	}
	public static int Maze2D(int cr, int cc, int er, int ec,int N) {
		if(cr>er||cc>ec) {
			return 0;
		}
		if(cr==er && cc==ec) {
			return 1;
		}
		
		int res=0;
		res+=Maze2D(cr+1, cc, er, ec,N);
		
		res+=Maze2D(cr, cc+1, er, ec,N);
		if (cr==cc || cr+cc==N)
		res+=Maze2D(cr+1, cc+1, er, ec,N);
		
		return res;
	}

}
