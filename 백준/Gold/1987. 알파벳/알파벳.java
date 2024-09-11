import java.util.Scanner;

public class Main {
	static int R, C, cnt, ans;
	static char[][] map;
	static boolean[] visited;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		R = sc.nextInt();
		C = sc.nextInt();
		
		map = new char[R][C];
		
		for(int i=0 ; i<R ; i++) {
			map[i] = sc.next().toCharArray();
		}
		visited = new boolean[26];
		
		cnt = 1;
		ans = 0;
		visited[map[0][0]-'A'] = true;
		dfs(0,0);
		System.out.println(ans);
	}
	
	static void dfs(int r, int c) {
		if(cnt>ans) ans = cnt;
		
		for(int d=0 ; d<4 ; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if(nr<0 || nr>=R || nc<0 || nc>=C || visited[map[nr][nc]-'A']) continue;
			cnt++;
			visited[map[nr][nc]-'A'] = true;
			dfs(nr,nc);
			visited[map[nr][nc]-'A'] = false;
			cnt--;
		}
	}
}
