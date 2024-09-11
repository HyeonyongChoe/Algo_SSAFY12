import java.util.Scanner;

public class Main {
	static int w, h, cnt;
	static int[][] map;
	static boolean[][] visited;
	static int[] dr = {-1,-1,0,1,1,1,0,-1};
	static int[] dc = {0,1,1,1,0,-1,-1,-1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			w = sc.nextInt();
			h = sc.nextInt();
			
			if(w==0 && h==0) break;
			
			map = new int[h][w];
			
			for(int r=0 ; r<h ; r++) {
				for(int c=0 ; c<w ; c++) {
					map[r][c] = sc.nextInt();
				}
			}
			
			visited = new boolean[h][w];
			cnt = 0;
			
			for(int r=0 ; r<h ; r++) {
				for(int c=0 ; c<w ; c++) {
					if(map[r][c]==1 && !visited[r][c]) {
						visited[r][c] = true;
						cnt++;
						dfs(r,c);
					}
				}
			}
			System.out.println(cnt);
		}
	}
	
	static void dfs(int r, int c) {
		
		for(int d=0 ; d<8 ; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			if(nr<0 || nr>=h || nc<0 || nc>=w || map[nr][nc]==0 || visited[nr][nc]) continue;
			visited[nr][nc] = true;
			dfs(nr,nc);
		}
	}
}
