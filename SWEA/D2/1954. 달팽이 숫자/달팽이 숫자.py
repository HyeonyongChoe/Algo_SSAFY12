import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int tc=1 ; tc<=T ; tc++) {
			int N = sc.nextInt();
			
			int[][] snail = new int[N][N];
			int cnt = 1;
			int r =0;
			int c =0;
			int[] dr = {0,1,0,-1};
			int[] dc = {1,0,-1,0};
			int d = 0;
			while(cnt<=N*N) {
				snail[r][c] = cnt;
				if (cnt==N*N) break;
				int nr = r+dr[d];
				int nc = c+dc[d];
				if(nr>=0 && nr<N && nc>=0 && nc<N && snail[nr][nc]==0) {
					r = nr;
					c = nc;
					cnt++;
				} else {
					d = (d+1)%4;
				}
				
			}
			System.out.println("#"+tc);
			for(int i=0 ; i<N ; i++) {
				for (int j=0 ; j<N ; j++) {
					System.out.print(snail[i][j]+" ");
				}
				System.out.println();
			}
			
		}
	}
}
