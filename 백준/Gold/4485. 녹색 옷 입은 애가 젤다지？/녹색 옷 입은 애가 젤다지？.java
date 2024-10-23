import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long tc = 1;
		while(true) {
			int N = sc.nextInt();
			
			if(N==0) break;
			
			int[][] map = new int[N][N];
			int[][] dist = new int[N][N];
			
			for(int i=0 ; i<N ; i++) {
				for(int j=0 ; j<N ; j++) {
					map[i][j] = sc.nextInt();
					dist[i][j] = 987654321;
				}
			}
			
			PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {

				@Override
				public int compare(int[] o1, int[] o2) {
					return o1[2] - o2[2];
				}
			});
			pq.add(new int[] {0,0,map[0][0]});
			dist[0][0] = map[0][0];
			
			boolean[][] visited = new boolean[N][N];
			while(!pq.isEmpty()) {
				int[] now = pq.poll();
				
				int r = now[0];
				int c = now[1];
				int dis = now[2];
				
				for(int d=0 ; d<4 ; d++) {
					int nr = r + dr[d];
					int nc = c + dc[d];
					
					if(nr<0 || nr>=N || nc<0 || nc>=N || visited[nr][nc]) continue;
					
					if(dist[nr][nc]<dis+map[nr][nc]) continue;
					
					visited[nr][nc] = true;
					dist[nr][nc] = dis + map[nr][nc];
					pq.add(new int[] {nr,nc,dist[nr][nc]});
				}
			}
			
			System.out.println("Problem "+tc+": "+dist[N-1][N-1]);
			tc++;
		}
	}
}
