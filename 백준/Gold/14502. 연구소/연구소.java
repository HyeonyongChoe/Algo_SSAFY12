import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
	static int N, M, tot, cnt, ans;
	static int[][] map;
	static boolean[][] visited;
	static int[] selected;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static List<int[]> virus;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		map = new int[N][M];
		virus = new LinkedList<>();
		
		tot = 0;
		for(int i=0 ; i<N ; i++) {
			for(int j=0 ; j<M ; j++) {
				map[i][j] = sc.nextInt();
				if(map[i][j]==0) tot++;
				if(map[i][j]==2) {
					virus.add(new int[] {i,j});
				}
			}
		}
		
		selected = new int[3];
		ans = 0;
		
		combi(0,0);
		System.out.println(ans);

	}
	
	static void combi(int idx, int sidx) {
		if(sidx>=3) {
			visited = new boolean[N][M];
//			Arrays.fill(visited,false);
			cnt = 0;
			for(int i=0 ; i<virus.size() ; i++) {
				int r = virus.get(i)[0];
				int c = virus.get(i)[1];
				
				dfs(r,c);
			}
			if(tot-cnt>ans) ans = tot-cnt;
			return;
		}
		
		for(int i=idx ; i<N*M ; i++) {
			if(map[i/M][i%M]!=0) continue;
			selected[sidx] = i;
			tot--;
			map[i/M][i%M] = 1;
			combi(i+1,sidx+1);
			map[i/M][i%M] = 0;
			tot++;
		}
	}
	
	static void dfs(int r, int c) {
		
		for(int d=0 ; d<4 ; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			if(nr<0 || nr>=N || nc<0 || nc>=M || map[nr][nc]!=0 || visited[nr][nc]) continue;
			visited[nr][nc] = true;
			cnt++;
			dfs(nr, nc);
		}
	}
}
