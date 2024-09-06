import java.util.Scanner;

public class Solution {
	static int r,c,max, d, tot, N, M, K, ans;
	static int[] dr = {0,-1,1,0,0};
	static int[] dc = {0,0,0,-1,1};
	static int[] path = {0,2,1,4,3};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc=1 ; tc<=T ; tc++) {
			N = sc.nextInt();
			M = sc.nextInt();
			K = sc.nextInt();
			
			int[][] bacteria = new int[K][4];
			// 세로위치, 가로위치, 미생물 수, 이동방향
			for(int i=0 ; i<K ; i++) {
				for(int j=0 ; j<4 ; j++) {
					bacteria[i][j] = sc.nextInt();
				}
			}
			
			for(int t=0 ; t<M ; t++) {
				
				for(int i=0 ; i<K ; i++) {
					if(bacteria[i][2]==0) continue;
					bacteria[i][0] += dr[bacteria[i][3]];
					bacteria[i][1] += dc[bacteria[i][3]];
					r = bacteria[i][0];
					c = bacteria[i][1];
					if(r==0 || r==N-1 || c==0 || c==N-1) {
						bacteria[i][2] /=2;
						bacteria[i][3] = path[bacteria[i][3]];
					}
				}
				
				for(int i=0 ; i<K ; i++) {
					if(bacteria[i][2]==0) continue;
					r = bacteria[i][0];
					c = bacteria[i][1];
					max = bacteria[i][2];
					d = bacteria[i][3];
					
					for(int j=i ; j<K ; j++) {
						if(bacteria[j][0]!=r || bacteria[j][1]!=c || bacteria[j][2]==0) continue;
						if(max<bacteria[j][2]) {
							max = bacteria[j][2];
							d = bacteria[j][3];
						}
					}
					tot = 0;
					for(int j=i ; j<K ; j++) {
						if(bacteria[j][0]!=r || bacteria[j][1]!=c || bacteria[j][2]==0) continue;
						tot += bacteria[j][2];
						bacteria[j][2] = 0;
					}
					bacteria[i][2] = tot;
					bacteria[i][3] = d;
				}
				
			}
			ans = 0;
			for(int i=0 ; i<K ; i++) {
				ans += bacteria[i][2];
			}
			System.out.println("#"+tc+" "+ans);
		}
	}
}
