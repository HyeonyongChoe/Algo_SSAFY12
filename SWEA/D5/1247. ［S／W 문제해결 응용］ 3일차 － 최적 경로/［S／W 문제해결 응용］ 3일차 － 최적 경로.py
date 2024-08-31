import java.util.Scanner;

public class Solution {
	static int N, home_x, home_y, comp_x, comp_y, ans;
	static int[][] cust;
	static boolean[] visited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc=1 ; tc<=T ; tc++) {
			N = sc.nextInt();
			
			home_x = sc.nextInt();
			home_y = sc.nextInt();
			
			comp_x = sc.nextInt();
			comp_y = sc.nextInt();
			
			cust = new int[N][2];
			
			for(int i=0 ; i<N ; i++) {
				cust[i][0] = sc.nextInt();
				cust[i][1] = sc.nextInt();
			}
			
			visited = new boolean[N];
			ans = N*200+1;
			permu(0,0, home_x, home_y);
			
			System.out.println("#"+tc+" "+ans);
		}
	}
	
	static void permu(int idx, int min, int nx, int ny) {
		if(min>ans) return;
		if(idx>=N) {
			min += Math.abs(nx-comp_x) + Math.abs(ny-comp_y);
			if(ans>min) ans = min;
			min -= Math.abs(nx-comp_x) + Math.abs(ny-comp_y);
			return;
		}
		
		for(int i=0 ; i<N ; i++) {
			if(visited[i]) continue;
			
			visited[i] = true;
			min += Math.abs(nx-cust[i][0]) + Math.abs(ny-cust[i][1]);
			permu(idx+1, min, cust[i][0], cust[i][1]);
			min -= Math.abs(nx-cust[i][0]) + Math.abs(ny-cust[i][1]);
			visited[i] = false;
		}
	}
}
