import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int[] stair = new int[N+1];
		
		for(int i=1  ; i<=N ; i++) {
			stair[i] = sc.nextInt();
		}
		
		int[][] dp = new int[N+1][2];
		
		for(int i=1 ; i<=N ; i++) {
			int max = 0;
			
			if(i>=1 && dp[i-1][0]<2 && dp[i-1][1]+stair[i]>max) {
				max = dp[i-1][1] + stair[i];
				dp[i][0] += dp[i-1][0] + 1;
			} else if(i>=1 && dp[i-1][0]>=2) {
				max = stair[i] + stair[i-1] + dp[i-3][1];
				dp[i][0] = 2;
			}
			
			if(i>=2 && dp[i-2][1]+stair[i]>max) {
				max = dp[i-2][1] + stair[i];
				dp[i][0] = 1;
			}
			
			dp[i][1] = max;
		}
		
		System.out.println(dp[N][1]);
	}
}