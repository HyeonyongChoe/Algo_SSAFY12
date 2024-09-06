import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	static int N, ans, cnt, sum;
	static int[][] maxinos, processor;
	static boolean[][] visited;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc=1 ; tc<=T ; tc++) {
			N = sc.nextInt();
			
			maxinos = new int[N][N];
			visited = new boolean[N][N];
			cnt = 0;
			for(int i=0 ; i<N ; i++) {
				for(int j=0 ; j<N ; j++) {
					maxinos[i][j] = sc.nextInt();
					if(maxinos[i][j]==1) {
						visited[i][j]=true;
						cnt++;
					}
				}
			}
			processor = new int[cnt][3];
			cnt = 0;
			
			for(int i=1 ; i<N-1 ; i++) {
				for(int j=1 ; j<N-1 ; j++) {
					if(maxinos[i][j]==1) {
						processor[cnt][0] = i;
						processor[cnt][1] = j;
						cnt++;
					}
				}
			}
			
			ans = 12*N+1;
			sum = 0;
			for(int i=cnt ; i>=1 ; i--) {
				combi(0,0,i);
				if (ans != 12*N+1) break;
			}
			
			System.out.println("#"+tc+" "+ans);
		}
	}
	
	static void combi(int idx, int sidx, int n) {
		
		if(idx>=cnt) {
			if(sidx<n) return;
			if(ans>sum) ans = sum;
			return;
		}
		
		for(int i=0 ; i<4 ; i++) {
			int con = connect(processor[idx][0],processor[idx][1],i);
			if(con!=0) {
				combi(idx+1, sidx+1,n);
				disconnect(processor[idx][0],processor[idx][1],i,con);
			} else {
				combi(idx+1, sidx,n);
			}
		}
	}
	
	static int connect(int r,int c, int dir) {
		int R = r;
		int C = c;
		while(r>=0 && r<N && c>=0 && c<N) {
			if(r==0 || r==N-1 || c==0 || c==N-1) {
				sum += Math.max(Math.abs(r-R), Math.abs(c-C));
				return Math.max(Math.abs(r-R), Math.abs(c-C));
			}
			
			int nr = r + dr[dir];
			int nc = c + dc[dir];
			if(nr<0 || nr>=N || nc<0 || nc>=N || visited[nr][nc]) break;
			visited[nr][nc] = true;
			r = nr;
			c = nc;
		}
		int rr = R;
		int cc = C;
		for(int i=0 ; i<Math.max(Math.abs(r-R), Math.abs(c-C)) ; i++) {
			rr += dr[dir];
			cc += dc[dir];
			visited[rr][cc] = false;
		}
		return 0;
	}
	
	static void disconnect(int r, int c, int dir, int l) {
		sum -= l;
		for(int i=0 ; i<l ; i++) {
			r += dr[dir];
			c += dc[dir];
			visited[r][c] = false;
		}
		
	}
}
