import java.util.Scanner;

public class Main {
	static int n, m, cnt, ans, max;
	static int[][] map;
	static boolean[][] visited;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		
		map = new int[n][m];
		
		for(int r=0 ; r<n ; r++) {
			for(int c=0 ; c<m ; c++) {
				map[r][c] = sc.nextInt();
			}
		}
		visited = new boolean[n][m];
		ans = 0;
		cnt = 0;
		for(int r=0 ; r<n ; r++) {
			for(int c=0 ; c<m ; c++) {
				if(map[r][c]==1 && !visited[r][c]) {
					visited[r][c] = true;
					max = 1;
					cnt++;
					dfs(r,c);
					
					if(ans<max) ans = max;
				}
				
			}
		}
		System.out.println(cnt);
		System.out.println(ans);
	}
	
	static void dfs(int r, int c) {
		
		for(int d=0 ; d<4 ; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			if(nr<0 || nr>=n || nc<0 || nc>=m || visited[nr][nc] || map[nr][nc]==0) continue;
			visited[nr][nc] = true;
			max++;
			dfs(nr,nc);
		}
	}
}
