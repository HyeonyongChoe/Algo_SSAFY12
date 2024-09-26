import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc=1 ; tc<=T ; tc++) {
			int N =  sc.nextInt();
			int[] coin = new int[N];
			
			for(int i=0 ; i<N ; i++) {
				coin[i] = sc.nextInt();
			}
			
			int M = sc.nextInt();
			
			int[] dp = new int[M+1];
			
			for(int i=0 ; i<N ; i++) {
				for(int j=1 ; j<=M ; j++) {
					if(j==coin[i]) dp[j]++;
					else if(j>coin[i]) dp[j] += dp[j-coin[i]];
				}
			}
			System.out.println(dp[M]);
		}
	}
}
