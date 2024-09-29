import java.util.Scanner;

public class Solution {
	static int ans;
	static char[][] maze;
	static boolean[][] visited;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = 10;
		
		for(int tc=1 ; tc<=T ; tc++) {
			int tCase = sc.nextInt();
			
			maze = new char[16][];
			visited = new boolean[16][16];
			
			int r=0;
			int c=0;
			for(int i=0 ; i<16 ; i++) {
				maze[i] = sc.next().toCharArray();
				for(int j=0 ; j<16 ; j++) {
					if(maze[i][j]=='2') {
						r=i;
						c=j;
					}
				}
			}
			ans = 0;
			visited[r][c] = true;
			dfs(r,c);
			
			System.out.println("#"+tCase+" "+ans);
		}
	}
	
	static void dfs(int r, int c) {
		if(maze[r][c]=='3') {
			ans = 1;
			return;
		}
		
		
		for(int d=0 ; d<4 ; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			if(nr<0 || nr>=16 || nc<0 || nc>=16 || maze[nr][nc]=='1' || visited[nr][nc]) continue;
			visited[nr][nc] = true;
			dfs(nr,nc);
			if(ans == 1) return;
		}
	}
}
