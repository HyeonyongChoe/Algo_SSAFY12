import java.util.Scanner;

public class Solution {
	static int N, K, max, ans;
	static int[][] map, visited;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc=1 ; tc<=T ; tc++) {
			N = sc.nextInt();
			K = sc.nextInt();
			
			map = new int[N][N];
			
			max = 0;
			
			for(int r=0 ; r<N ; r++) {
				for(int c=0 ; c<N ; c++) {
					map[r][c] = sc.nextInt();
					if(max<map[r][c]) max = map[r][c];
				}
			}
			
			ans = 0;
			visited = new int[N][N];
			for(int r=0 ; r<N ; r++) {
				for(int c=0 ; c<N ; c++) {
					if(map[r][c]==max) {
						visited[r][c]++;
						dfs(r,c,1,1);
						visited[r][c]--;
					}
				}
			}
			System.out.println("#"+tc+" "+ans);
			
		}
	}
	
	static void dfs(int r, int c, int length, int chk) {
		if(ans<length) ans = length;
		
		for(int d=0 ; d<4 ; d++) {
			int nr = r+dr[d];
			int nc = c+dc[d];
			
			if(nr>=0 && nr<N && nc>=0 && nc<N && visited[nr][nc]==0) {
				if(map[nr][nc]<map[r][c]) {
					visited[nr][nc]++;
					dfs(nr,nc,length+1,chk);
					visited[nr][nc]--;
				} else if(chk==1) {
					for(int i=1 ; i<=K ; i++) {
						map[nr][nc] -= i;
						if(map[nr][nc]<map[r][c]) {
							visited[nr][nc]++;
							dfs(nr,nc,length+1,chk-1);
							visited[nr][nc]--;
						}
						map[nr][nc] += i;
					}
				}
			}
		}
	}
}
