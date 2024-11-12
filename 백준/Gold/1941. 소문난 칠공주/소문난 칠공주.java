import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static char[][] girlClass;
	static int[] selected;
	static boolean[][] visited;
	static boolean[][] sevenPrincess;
	static int tmp, ans;
 	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		girlClass = new char[5][];
		
		for(int i=0 ; i<5 ; i++) {
			girlClass[i] = sc.next().toCharArray();
		}
		
		selected = new int[7];
		
		ans = 0;
		combi(0,0);
		
		System.out.println(ans);
		
	}
	
	static void combi(int idx, int sidx) {
		if(sidx==7) {
			int x = 0;
			int cnt = 0;
			sevenPrincess = new boolean[5][5];
			visited = new boolean[5][5];
			
			out :
			for(int i=0 ; i<5 ; i++) {
				for(int j=0 ; j<5 ; j++) {
					if(selected[x]==i*5+j) {
						sevenPrincess[i][j] = true;
						x++;
						if(girlClass[i][j]=='S') cnt++;
					}
					if(x==7) break out;
				}
			}
			
			if(cnt<4) return;
			tmp = 1;
			visited[selected[0]/5][selected[0]%5] = true;
			dfs(selected[0]/5,selected[0]%5);
			if(tmp<7) return;
			ans++;
			return;
		}
		
		for(int i=idx ; i<25 ; i++) {
			selected[sidx] = i;
			combi(i+1,sidx+1);
		}
	}
	
	static void dfs(int r, int c) {
		
		for(int d=0 ; d<4 ; d++) {
			int nr = r+dr[d];
			int nc = c+dc[d];
			
			if(nr<0 || nr>=5 || nc<0 || nc>=5 || !sevenPrincess[nr][nc] || visited[nr][nc]) continue;
			visited[nr][nc] = true;
			tmp++;
			dfs(nr, nc);
		}
	}
}
