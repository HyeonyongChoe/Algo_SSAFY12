import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc=1 ; tc<=T ; tc++) {
			int[] cost = new int[4];
			
			for(int i=0 ; i<4 ; i++) {
				cost[i] = sc.nextInt();
			}
			
			int[] plan = new int[13];
			
			for(int i=1 ; i<=12 ; i++) {
				plan[i] = sc.nextInt();
			}
			
			int[] dp = new int[13];
			
			for(int i=1 ; i<=12 ; i++) {
				int min = dp[i-1] + Math.min(cost[0]*plan[i], cost[1]);
				if(i>=3) min = Math.min(dp[i-3]+cost[2], min);
				if(i==12) min = Math.min(dp[i-12]+cost[3], min);
				dp[i] = min;
			}
			System.out.println("#"+tc+" "+dp[12]);
		}
	}
}
