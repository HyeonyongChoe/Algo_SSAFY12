import java.util.Scanner;

public class Solution {
	static int[] dr = {0,-1,0,1,0};
	static int[] dc = {0,0,1,0,-1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc=1 ; tc<=T ; tc++) {
			int M = sc.nextInt();
			int A = sc.nextInt();
			
			int[] moveA = new int[M];
			int[] moveB = new int[M];
			
			for(int i=0 ; i<M ; i++) {
				moveA[i] = sc.nextInt();
			}
			for(int i=0 ; i<M ; i++) {
				moveB[i] = sc.nextInt();
			}
			
			int[][] BC = new int[A][4];
			
			for(int i=0 ; i<A ; i++) {
				for(int j=0 ; j<4 ; j++) {
					BC[i][j] = sc.nextInt();
				}
			}
			
			int rA = 1;
			int cA = 1;
			
			int rB = 10;
			int cB = 10;
			
			int ans = 0;
			
			int t=0;
			
			while(t<=M) {
				
				int[] validA = new int[A];
				int[] validB = new int[A];
				
				for(int i=0 ; i<A ; i++) {
					if((Math.abs(rA-BC[i][1])+Math.abs(cA-BC[i][0]))<=BC[i][2]) {
						validA[i] = 1;
					}
					if((Math.abs(rB-BC[i][1])+Math.abs(cB-BC[i][0]))<=BC[i][2]) {
						validB[i] = 1;
					}
				}
				
				int max = 0;
				int tmp = 0;
				int tmpA = 0;
				int tmpB = 0;
				for(int i=0 ; i<A ; i++) {
					for(int j=0 ; j<A ; j++) {
						if(i==j) {
							tmpA = validA[i]*BC[i][3];
							tmpB = validB[j]*BC[j][3];
							tmp = Math.max(tmpA, tmpB);
						} else {
							tmpA = validA[i]*BC[i][3];
							tmpB = validB[j]*BC[j][3];
							tmp = tmpA + tmpB;
						}
						if(tmp > max) max = tmp;
					}
				}
				
				
				ans += max;
				if(t>=M) break;
				rA += dr[moveA[t]];
				cA += dc[moveA[t]];
				rB += dr[moveB[t]];
				cB += dc[moveB[t]];
				t++;
			}
			System.out.println("#"+tc+" "+ans);
		}
	}
}
