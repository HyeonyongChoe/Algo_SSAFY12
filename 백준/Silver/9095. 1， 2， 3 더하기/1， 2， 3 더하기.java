import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] dp = new int[11];
		
		for(int i=1 ; i<11 ; i++) {
			if(i==1) dp[i]++;
			if(i==2) dp[i]++;
			if(i==3) dp[i]++;
			if(i>1) {
				dp[i] += dp[i-1];
			}
			if(i>2) {
				dp[i] += dp[i-2];
			}
			if(i>3) {
				dp[i] += dp[i-3];
			}
		}
		
		int T = sc.nextInt();
		
		for(int tc=1 ; tc<=T ; tc++) {
			int n = sc.nextInt();
			System.out.println(dp[n]);
		}
	}
}
