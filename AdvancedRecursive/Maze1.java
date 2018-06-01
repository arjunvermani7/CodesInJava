package recursion2;

import java.util.Scanner;

public class Maze1 {
	
	public static void main (String[] args) {
		
			Scanner pop= new Scanner(System.in);
			int N1 =pop.nextInt();
			int N2 =pop.nextInt();
			
			String ans="";
			
			int an=Maze2D(1, 1, N1,N2);
			System.out.println(an);
			
			MazeD(1,1,N1,N2,ans);

	}
		public static void MazeD(int cr, int cc, int er, int ec, String ans) {
			if(cr>er||cc>ec) {
				return;
			}
			if(cr==er && cc==ec) {
				System.out.print(ans+" ");
				return ;
			}
			
			
			MazeD(cr+1, cc, er, ec, ans+'V');
			
			MazeD(cr, cc+1, er, ec, ans+'H');
			
			
		}
		public static int Maze2D(int cr, int cc, int er, int ec) {
			if(cr>er||cc>ec) {
				return 0;
			}
			if(cr==er && cc==ec) {
				return 1;
			}
			
			int res=0;
			res+=Maze2D(cr+1, cc, er, ec);
			
			res+=Maze2D(cr, cc+1, er, ec);
		
			
			
			return res;
		}

}
