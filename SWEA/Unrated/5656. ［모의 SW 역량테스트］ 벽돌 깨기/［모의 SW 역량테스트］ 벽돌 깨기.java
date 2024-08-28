import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	static int N, W, H, min, tmpmin;
	static int[] ball;
	static int[][] brick, copybrick;
	static Queue<int[]> queue = new LinkedList<>();
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc=1 ; tc<=T ; tc++) {
			N = sc.nextInt();
			W = sc.nextInt();
			H = sc.nextInt();
			
			brick = new int[H][W];
			
			for(int i=0 ; i<H ; i++) {
				for(int j=0 ; j<W ; j++) {
					brick[i][j] = sc.nextInt();
				}
			}
			
			ball = new int[N];
			min = W*H+1;
			permu(0,0);
			
			System.out.println("#"+tc+" "+min);
		}
	}
	
	static void permu(int idx, int sidx) {
		if (idx>=W) return;
		if(sidx>=N) {
			
			
			copybrick = new int[H][W];
			for(int i=0 ; i<H ; i++) {
				for(int j=0 ; j<W ; j++) {
					copybrick[i][j] = brick[i][j];
				}
			}
			tmpmin = 0;
			
			
			for(int i=0 ; i<N ; i++) {
				crushBrick(ball[i]);
			}
			for(int i=0 ; i<H ; i++) {
				for(int j=0 ; j<W ; j++) {
					if(copybrick[i][j]!=0) tmpmin++;
				}
			}
			if(tmpmin<min) min = tmpmin;
			
			return;
		}
	
		ball[sidx] = idx;
		permu(0, sidx+1);
		permu(idx+1, sidx);
	
	
	}
	
	static void crushBrick(int idx) {
		int r = 0 ;
		int c = idx;
		
		
		
		while(copybrick[r][c]==0) {
			if(r == H-1) break;
			r++;
		}
			
		int[] roc = {r,c};
		queue.offer(roc);
		
		while(!queue.isEmpty()) {
			roc = queue.poll();
			int power = copybrick[roc[0]][roc[1]];
			copybrick[roc[0]][roc[1]] = 0;
			
			if (power<=1) continue;
			for(int d=0 ; d<4 ; d++) {
				for(int p=1 ; p<power ; p++) {
					int nr = roc[0]+ p*dr[d];
					int nc = roc[1]+ p*dc[d];
					if(nr>=0 && nr<H && nc>=0 && nc<W && copybrick[nr][nc]!=0) {
						int[] nroc = {nr,nc};
						queue.offer(nroc);
					}
				}
			}
		}
		
		for(int j=0 ; j<W ; j++) {
			int a = H-1;
			for(int i=H-1 ; i>=0; i--) {
				
				if(copybrick[i][j]!=0) {
					copybrick[a][j] = copybrick[i][j];
					
					if(a!=i) {
						copybrick[i][j]=0;
					}
					a--;
					
				}	
			}
		}
		
	}
}