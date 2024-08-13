import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[][] board  = new int[100][100];
		
		int ans = 0;
		for(int i=0 ; i<4 ; i++) {
			int x1 = sc.nextInt();
			int y1 = sc.nextInt();
			int x2 = sc.nextInt();
			int y2 = sc.nextInt();
			
			for(int r=y1 ; r<y2 ; r++) {
				for(int c=x1 ; c<x2 ; c++) {
					if(board[r][c]==0) {
						ans++;
						board[r][c] = 1; 
					}
					
				}
			}
		}
		
		System.out.println(ans);
	}
}
