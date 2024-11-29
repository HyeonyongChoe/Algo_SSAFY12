import java.util.Scanner;

public class Main {
	static int[][] map;
	static int N, M, K;
	static boolean[][] visited;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc=0 ; tc<T ; tc++) {
			M = sc.nextInt();
			N = sc.nextInt();
			K = sc.nextInt();
			
			map = new int[N][M];
			visited = new boolean[N][M];
			
			for(int i=0; i<K ; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				map[y][x] = 1;
			}
			int ans = 0;
			for(int r=0 ; r<N ; r++) {
				for(int c=0 ; c<M ; c++) {
					if(!visited[r][c] && map[r][c]==1) {
						ans++;
						dfs(r,c);
					}
				}
			}
			
			System.out.println(ans);
		}
	}

	static void dfs(int r, int c) {
		for(int d=0 ; d<4 ; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			if(nr<0 || nr>=N || nc<0 || nc>=M || visited[nr][nc] || map[nr][nc]==0) continue;
			visited[nr][nc] = true;
			dfs(nr,nc);
		}
		
	}
}
