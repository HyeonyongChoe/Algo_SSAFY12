import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int[] dx = {0,0,-1,0,1,0};
	static int[] dy = {0,0,0,1,0,-1};
	static int[] dz = {1,-1,0,0,0,0};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int M = sc.nextInt();
		int N = sc.nextInt();
		int H = sc.nextInt();
		
		int[][][] tomato = new int[H][N][M];
		
		Queue<int[]> queue = new LinkedList<>();
		
		int tot = 0;
		
		for(int i=0 ; i<H ; i++) {
			for(int j=0 ; j<N ; j++) {
				for(int k=0 ; k<M ; k++) {
					tomato[i][j][k] = sc.nextInt();
					if(tomato[i][j][k]==1) queue.add(new int[] {i,j,k});
					if(tomato[i][j][k]==0) tot++;					
				}
			}
		}
		
		int days = 0;
		
		while(!queue.isEmpty() && tot!=0) {
			int l = queue.size();
			
			for(int i=0 ; i<l ; i++) {
				int[] now = queue.poll();
				
				int z = now[0];
				int x = now[1];
				int y = now[2];
				
				for(int d=0 ; d<6 ; d++) {
					int nx = x + dx[d];
					int ny = y + dy[d];
					int nz = z + dz[d];
					
					if(nx<0 || nx>=N || ny<0 || ny>=M || nz<0 || nz>=H || tomato[nz][nx][ny]!=0) continue;
					tomato[nz][nx][ny] = 1;
					tot--;
					queue.add(new int[] {nz,nx,ny});
				}
			}
			days++;
			
		}
		
		if(tot!=0) days = -1;
		
		System.out.println(days);
	}
}
