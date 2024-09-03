import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	static int[][] cheese, visited;
	static int N, cnt;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc=1 ; tc<=T ; tc++) {
			N = sc.nextInt();
			cheese = new int[N][N];
			
			for(int i=0 ; i<N ; i++) {
				for(int j=0 ; j<N ; j++) {
					cheese[i][j] = sc.nextInt();
				}
			}
			
			int ans = 1;
			for(int i=1 ; i<=100 ; i++) {
				visited = new int[N][N];
				cnt = 0;
				for(int r=0 ; r<N ; r++) {
					for(int c=0 ; c<N ; c++) {
						if(cheese[r][c]>i && visited[r][c]==0) {
							dfs(i,r,c);		
							cnt++;
						}
					}
				}
				if(cnt>ans) ans = cnt;
				if(cnt==0) break;
			}
			
			System.out.println("#"+tc+" "+ans);
		}
	}
	
	static void dfs(int day, int r, int c) {
		visited[r][c] = 1;
		for(int d=0 ; d<4 ; d++) {
			int nr = r+dr[d];
			int nc = c+dc[d];
			if(nr>=0 && nr<N && nc>=0 && nc<N && cheese[nr][nc]>day && visited[nr][nc]==0) {
				dfs(day,nr,nc);
			}
		}
	}
}
