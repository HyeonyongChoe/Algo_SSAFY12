import java.util.Scanner;

public class Solution {
	static int[] dr = {-1,-1,0,1,1,1,0,-1};
	static int[] dc = {0,1,1,1,0,-1,-1,-1};
	static char[][] map;
	static boolean[][] visited;
	static int N;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc=1 ; tc<=T ; tc++) {
			N = sc.nextInt();
			
			map = new char[N][];
			for(int i=0 ; i<N ; i++) {
				map[i] = sc.next().toCharArray();
				for(int j=0 ; j<N ; j++) {
					if(map[i][j]=='.') map[i][j] = '0';
				}
			}
			
			for(int r=0 ; r<N ; r++) {
				for(int c=0 ; c<N ; c++) {
					if(map[r][c]=='*') {
						for(int d=0 ; d<8 ; d++) {
							int nr = r+dr[d];
							int nc = c+dc[d];
							if(nr<0 || nr>=N || nc<0 || nc>=N || map[nr][nc]=='*') continue;
							map[nr][nc] = (char) (map[nr][nc] -'0' + '1');
						}
					}
				}
			}
			
			int ans = 0;
			visited = new boolean[N][N];
			for(int r=0 ; r<N ; r++) {
				for(int c=0 ; c<N ; c++) {
					if(map[r][c]!='0' || visited[r][c]) continue;
					ans++;
					visited[r][c] = true;
					dfs(r,c);
				}
			}
			
			for(int r=0 ; r<N ; r++) {
				for(int c=0 ; c<N ; c++) {
					if(visited[r][c] || map[r][c]=='*') continue;
					visited[r][c] = true;
					ans++;
				}
			}
			
			System.out.println("#"+tc+" "+ans);
		}
		
	}
	
	static void dfs(int r, int c) {
		int count = 0;
		for(int d=0 ; d<8 ; d++) {
			int nr = r+dr[d];
			int nc = c+dc[d];
			if(nr<0 || nr>=N || nc<0 || nc>=N || visited[nr][nc]) continue;
			visited[nr][nc] = true;
			if(map[nr][nc]=='0') dfs(nr, nc);
		}

	}
}
