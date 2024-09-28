import java.util.Scanner;

public class Main {
	static int N;
	static long[] dp;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		dp = new long[N+1];
		dp[0] = 1;
		dp[1] = 3;
		
		for(int i=2 ; i<=N ; i++) {
			dp[i] = (2*dp[i-1] + dp[i-2])%9901;
		}
		System.out.println(dp[N]%9901);
	}
	
}
