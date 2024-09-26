import java.util.Scanner;

public class Main {
	static int N, cnt1, cnt2;
	static char[][] map;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static boolean[][] visited_norm, visited_redgreen;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		
		map = new char[N][];
		
		for(int i=0 ; i<N ; i++) {
			map[i] = sc.next().toCharArray();
		}
		
		visited_norm = new boolean[N][N];
		visited_redgreen = new boolean[N][N];
		
		cnt1 = 0;
		cnt2 = 0;
		for(int r=0 ; r<N ; r++) {
			for(int c=0 ; c<N ; c++) {
				if(!visited_norm[r][c]) {
					cnt1++;
					dfs(r,c,false, map[r][c]);
				}
				if(!visited_redgreen[r][c]) {
					cnt2++;
					dfs(r,c,true, map[r][c]);
				}
			}
		}
		System.out.println(cnt1+" "+cnt2);
	}
	
	static void dfs(int r, int c, boolean flag, char color) {
		
		for(int d=0 ; d<4 ; d++) {
			int nr = r+dr[d];
			int nc = c+dc[d];
			if(nr<0 || nr>=N || nc<0 || nc>=N) continue;
			if(!visited_norm[nr][nc] && !flag && map[nr][nc]== color) {
				visited_norm[nr][nc] = true;
				dfs(nr,nc,flag,color);
			}
			if(flag && !visited_redgreen[nr][nc]) {
				if(color=='B' && map[nr][nc]=='B') {
					visited_redgreen[nr][nc] = true;
					dfs(nr,nc,flag,color);
				} else if(color!='B' && map[nr][nc]!='B') {
					visited_redgreen[nr][nc] = true;
					dfs(nr,nc,flag,color);
				}
			}
		}
	}
}
