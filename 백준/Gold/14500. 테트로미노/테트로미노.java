import java.util.Scanner;

public class Main {
	static int N, M, ans, cnt;
	static int[][] map;
	static boolean[][] visited;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		map = new int[N][M];
		
		for(int i=0 ; i<N ; i++) {
			for(int j=0 ; j<M ; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		ans = 0;
		
		visited = new boolean[N][M];
		for(int r=0 ; r<N ; r++) {
			for(int c=0 ; c<M ; c++) {
				cnt = map[r][c];
				visited[r][c] = true;
				dfs(r,c,1);
				visited[r][c] = false;
			}
		}
		System.out.println(ans);
	}

	static void dfs(int r, int c, int sidx) {
		if(sidx==4) {
			if(ans<cnt) ans = cnt;
			return;
		}
		
		for(int d=0 ; d<4 ; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			if(nr<0 || nr>=N || nc<0 || nc>=M || visited[nr][nc]) continue;
			visited[nr][nc] = true;
			cnt += map[nr][nc];
			dfs(nr,nc,sidx+1);
			dfs(r,c,sidx+1);
			cnt -= map[nr][nc];
			visited[nr][nc] = false;
		}
	}
}
