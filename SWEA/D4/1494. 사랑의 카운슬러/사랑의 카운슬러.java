import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	static int N;
	static int[][] worm;
	static boolean[] visited;
	static long ans;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc=1 ; tc<=T ; tc++) {
			N = sc.nextInt();
			worm = new int[N][2];
			
			for(int i=0 ; i<N ; i++) {
				worm[i][0] = sc.nextInt();
				worm[i][1] = sc.nextInt();
			}
			
			visited = new boolean[N];
			
			ans = Long.MAX_VALUE;
			
			permu(0,0);
			System.out.println("#"+tc+" "+ans);
		}
	}
	
	static void permu(int idx, int sidx) {
		if(sidx>=N/2) {
			long xx = 0;
			long yy = 0;
			for(int i=0 ; i<N ; i++) {
				if(visited[i]) {
					xx += worm[i][0];
					yy += worm[i][1];
				} else {
					xx -= worm[i][0];
					yy -= worm[i][1];
				}
			}
			long vec = xx*xx + yy*yy;
			if(ans>vec) ans = vec;
			return;
		}
		
		for(int i=idx ; i<N ; i++) {
			if(!visited[i]) {
				visited[i] = true;
				permu(i+1,sidx+1);
				visited[i] = false;
			}
		}
	}
}
