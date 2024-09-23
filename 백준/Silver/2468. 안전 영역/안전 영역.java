import java.util.Scanner;

public class Main {
	static int N, maxh, ans, cnt;
	static int[][] map;
	static boolean[][] visited;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
 	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		map = new int[N][N];
		
		maxh = 0;
		for(int i=0 ; i<N ; i++) {
			for(int j=0 ; j<N ; j++) {
				map[i][j] = sc.nextInt();
				if(maxh<map[i][j]) maxh = map[i][j];
			}
		}
		
		ans = 1;
		for(int i=1 ; i<=maxh ; i++) {
			cnt = 0;
			visited = new boolean[N][N];
			for(int r=0 ; r<N ; r++) {
				for(int c=0 ; c<N ; c++) {
					if(!visited[r][c] &&  map[r][c]>i) {
						visited[r][c] = true;
						cnt++;
						dfs(r,c,i);
					}
				}
			}
			if(cnt>ans) ans = cnt;
		}
		System.out.println(ans);
	}

	static void dfs(int r, int c, int h) {
		for(int d=0 ; d<4 ; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			if(nr<0 || nr>=N || nc<0 || nc>=N || visited[nr][nc] || map[nr][nc]<=h) continue;
			visited[nr][nc] = true;
			dfs(nr,nc,h);
		}
	}
}
