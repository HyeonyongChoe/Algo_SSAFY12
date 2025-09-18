import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] dp = new int[1000001];
		
		for(int i=1 ; i<1000001 ; i++) {
			dp[i] = Integer.MAX_VALUE;
		}
		for(int i=1 ; i<1000001 ; i++) {
			if(i==1) dp[i] = 0;
			if(i*2<1000001) dp[i*2] = Math.min(dp[i*2],dp[i]+1);
			if(i*3<1000001) dp[i*3] = Math.min(dp[i*3],dp[i]+1);
			if(i+1<1000001) dp[i+1] = Math.min(dp[i+1],dp[i]+1);
		}
		int N = sc.nextInt();
		System.out.println(dp[N]);
	}
}
