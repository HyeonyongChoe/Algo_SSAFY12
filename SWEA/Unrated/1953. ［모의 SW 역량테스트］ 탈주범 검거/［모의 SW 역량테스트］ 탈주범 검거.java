import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	static int N, M, R, C, L,ans;
	static int[][] underworld;
	static boolean[][] visited;
	static int[][] typeInfo = {	{0}, // 
								{0,1,2,3}, //1번 구조물
								{0,2}, // 2번
								{1,3}, // 3번
								{0,1}, // 4번
								{1,2}, // 5번
								{2,3}, // 5번
								{3,0}}; // 7번
	static int[] path = {2,3,0,1};
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	
	static Queue<int[]> queue = new LinkedList<>();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc=1 ; tc<=T ; tc++) {
			N = sc.nextInt();
			M = sc.nextInt();
			R = sc.nextInt();
			C = sc.nextInt();
			L = sc.nextInt();
			
			underworld = new int[N][M];
			visited = new boolean[N][M];
			
			for(int r=0 ; r<N ; r++) {
				for(int c=0 ; c<M ; c++) {
					underworld[r][c] = sc.nextInt();
				}
			}
			ans = 1;
			
			visited[R][C] = true;
			queue.offer(new int[] {R,C,1});
			bfs();
			
			System.out.println("#"+tc+" "+ans);
		}
	}
	
	static void bfs() {
		while(!queue.isEmpty()) {
			int[] roc = queue.poll();
			int r = roc[0];
			int c = roc[1];
			int l = roc[2];
			if(l==L) continue;
			for(int d=0 ; d<typeInfo[underworld[r][c]].length ; d++) {
				int nr = r+dr[typeInfo[underworld[r][c]][d]];
				int nc = c+dc[typeInfo[underworld[r][c]][d]];
				
				if(nr<0 || nr>=N || nc<0 || nc>=M || visited[nr][nc] || underworld[nr][nc]==0) continue;
				for(int nd=0 ; nd<typeInfo[underworld[nr][nc]].length ; nd++) {
					if(path[typeInfo[underworld[r][c]][d]]==typeInfo[underworld[nr][nc]][nd]) {
						visited[nr][nc] = true;
						ans++;
						queue.offer(new int[] {nr,nc,l+1});
					}
				}
			}
		}
	}
}
