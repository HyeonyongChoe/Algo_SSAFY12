import java.util.Scanner;

public class Main {
	static int N, M, tot, ans;
	static int[][] cheese;
	static boolean[][] melt, air, visited;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		cheese = new int[N][M];
		tot = 0;
		
		for(int i=0 ; i<N ; i++) {
			for(int j=0 ; j<M ; j++) {
				cheese[i][j] = sc.nextInt();
				if(cheese[i][j]==1) tot++;
			}
		}
		
		air = new boolean[N][M];
		melt = new boolean[N][M];
		ans = 0;
		while(tot>0) {
			visited = new boolean[N][M];
			dfsAir(0,0);
			
			
			for(int r=0 ; r<N ; r++) {
				for(int c=0 ; c<M ; c++) {
					if(cheese[r][c]==1) {
						int cnt = 0;
						for(int d=0 ; d<4 ; d++) {
							int nr = r + dr[d];
							int nc = c + dc[d];
							if(air[nr][nc]) cnt++;
							if(cnt>=2) {
								tot--;
								melt[r][c] = true;
								break;
							}
						}
					}
				}
			}
			
			for(int r=0 ; r<N ; r++) {
				for(int c=0 ; c<M ; c++) {
					if(melt[r][c]) cheese[r][c] = 0;
				}
			}
			ans++;
		}
		System.out.println(ans);
	}

	static void dfsAir(int r, int c) {
		
		for(int d=0 ; d<4 ; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			if(nr<0 || nr>=N || nc<0 || nc>=M || visited[nr][nc] || cheese[nr][nc]==1) continue;
			visited[nr][nc] = true;
			air[nr][nc] = true;
			dfsAir(nr,nc);
		}
	}
	
	
	
}
