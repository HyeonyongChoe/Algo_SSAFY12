import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		char[][] map = new char[N][];
		
		for(int i=0 ; i<N ; i++) {
			map[i] = sc.next().toCharArray();
		}
		
		boolean[][] visited = new boolean[N][M];
		boolean[][] visited2 = new boolean[N][M];
		int[][] dist = new int[N][M];
		Queue<int[]> queue = new LinkedList<>();
		int ans = 987654321;
			
		queue.add(new int[] {0,0,1});
		dist[0][0] = 1;
		visited[0][0] = true;
		int cnt = 1;
		
		out :
		while(!queue.isEmpty()) {
			int l = queue.size();
			
			cnt++;
			for(int k=0 ; k<l ; k++) {
				
				int[] roc = queue.poll();
				
				if(roc[0]==N-1 && roc[1]==M-1) {
					break out;
				}
				
				for(int d=0 ; d<4 ; d++) {
					int nr = roc[0] + dr[d];
					int nc = roc[1] + dc[d];
					
					if(nr<0 || nr>=N || nc<0 || nc>=M) continue;
					if(roc[2]==1 && !visited[nr][nc]) {
						if(map[nr][nc]=='0') {
							visited[nr][nc] = true;
							dist[nr][nc] = cnt;
							queue.add(new int[] {nr,nc,1});
						} else {
							visited2[nr][nc] = true;
							dist[nr][nc] = cnt;
							queue.add(new int[] {nr,nc,0});
						}
					} else if (roc[2]==0 && !visited2[nr][nc]) {
						if(map[nr][nc]=='0') {
							visited2[nr][nc] = true;
							dist[nr][nc] = cnt;
							queue.add(new int[] {nr,nc,0});
						} else {
							continue;
						}
					}
				}
			}
		}
		ans = dist[N-1][M-1];
		
		if(ans==0) {
			System.out.println(-1);
		} else {
			System.out.println(ans);
		}
	}
}
