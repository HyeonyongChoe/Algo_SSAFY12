import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	static char[][] map;
	static int N, M, ans;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static int[][] visited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc=1 ; tc<=T ; tc++) {
			N = sc.nextInt();
			M = sc.nextInt();
			
			map = new char[N][M];
			
			for(int i=0 ; i<N ; i++) {
				map[i] = sc.next().toCharArray();
			}
			
			Queue<int[]> queue = new LinkedList<>();
			visited = new int[N][M];
			boolean[][] chk = new boolean[N][M];
			
			for(int r=0 ; r<N ; r++) {
				for(int c=0 ; c<M ; c++) {
					if(map[r][c]=='W') {
						int[] roc = new int[2];
						roc[0] = r;
						roc[1] = c;
						queue.offer(roc);
						chk[r][c] = true;
					}
				}
			}
			int dis = 0;
			while(!queue.isEmpty()) {
				int s = queue.size();
				for(int i=0 ; i<s ; i++) {
					int[] roc = queue.poll();
					visited[roc[0]][roc[1]] = dis;
					
					for(int d=0 ; d<4 ; d++) {
						int nr = roc[0] + dr[d];
						int nc = roc[1] + dc[d];
						
						if(nr>=0 && nr<N && nc>=0 && nc<M && map[nr][nc]=='L' && visited[nr][nc]==0 && !chk[nr][nc]) {
							int[] nroc = new int[2];
							nroc[0] = nr;
							nroc[1] = nc;
							chk[nr][nc] = true;
							queue.offer(nroc);
						}
					}
				}
				dis++;
				
			}
			
			ans = 0;
			for(int r=0 ; r<N ; r++) {
				for(int c=0 ; c<M ; c++) {
					ans += visited[r][c];
				}
			}
			
			System.out.println("#"+tc+" "+ans);
		}
	}
}
