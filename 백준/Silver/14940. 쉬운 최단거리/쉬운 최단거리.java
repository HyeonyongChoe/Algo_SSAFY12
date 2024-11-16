import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N][M];
		int[][] visited = new int[N][M];
		
		int startR = -1;
		int startC = -1;
		for(int i=0 ; i<N ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0 ; j<M ; j++) {				
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==2) {
					startR = i;
					startC = j;
				}
			}
		}
		
		Queue<int[]> queue = new LinkedList<>();
		
		queue.add(new int[] {startR, startC});
		
		int cnt = 1;
		while(!queue.isEmpty()) {
			int len = queue.size();
			
			for(int i=0 ; i<len ; i++) {
				int[] roc = queue.poll();
				
				for(int d=0 ; d<4 ; d++) {
					int nr = roc[0] + dr[d];
					int nc = roc[1] + dc[d];
					
					if(nr<0 || nr>=N || nc<0 || nc>=M || visited[nr][nc]!=0 || map[nr][nc]!=1) continue;
					visited[nr][nc] = cnt;
					queue.add(new int[] {nr,nc});
				}
			}
			cnt++;
		}
		
		for(int i=0 ; i<N ; i++) {
			for(int j=0 ; j<M ; j++) {
				if(visited[i][j]==0 && map[i][j]==1) {
					sb.append(-1).append(" ");										
				} else {
					sb.append(visited[i][j]).append(" ");					
				}
			}
			sb.append("\n");
		}
 		
		System.out.println(sb);
	}
}
