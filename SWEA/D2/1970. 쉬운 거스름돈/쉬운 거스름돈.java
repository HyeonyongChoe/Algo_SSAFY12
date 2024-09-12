import java.util.Scanner;

public class Solution {
	static int N;
	static int[][] dp;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		dp = new int[100001][9];
		
		for(int i=1 ; i<=100000 ; i++) {
			int minCnt = 987654321;
			
			if(i>=1) {
				if(minCnt > dp[i-1][0]+1) {
					for(int j=1 ; j<9 ; j++) {
						dp[i][j] = dp[i-1][j];
					}
					dp[i][1]++;
					minCnt = dp[i-1][0]+1;
				}
			}
			if(i>=5) {
				if(minCnt > dp[i-5][0]+1) {
					for(int j=1 ; j<9 ; j++) {
						dp[i][j] = dp[i-5][j];
					}
					dp[i][2]++;
					minCnt = dp[i-5][0]+1;
				}
			}
			if(i>=10) {
				if(minCnt > dp[i-10][0]+1) {
					for(int j=1 ; j<9 ; j++) {
						dp[i][j] = dp[i-10][j];
					}
					dp[i][3]++;
					minCnt = dp[i-10][0]+1;
				}
			}
			if(i>=50) {
				if(minCnt > dp[i-50][0]+1) {
					for(int j=1 ; j<9 ; j++) {
						dp[i][j] = dp[i-50][j];
					}
					dp[i][4]++;
					minCnt = dp[i-50][0]+1;
				}
			}
			if(i>=100) {
				if(minCnt > dp[i-100][0]+1) {
					for(int j=1 ; j<9 ; j++) {
						dp[i][j] = dp[i-100][j];
					}
					dp[i][5]++;
					minCnt = dp[i-100][0]+1;
				}
			}
			if(i>=500) {
				if(minCnt > dp[i-500][0]+1) {
					for(int j=1 ; j<9 ; j++) {
						dp[i][j] = dp[i-500][j];
					}
					dp[i][6]++;
					minCnt = dp[i-500][0]+1;
				}
			}
			if(i>=1000) {
				if(minCnt > dp[i-1000][0]+1) {
					for(int j=1 ; j<9 ; j++) {
						dp[i][j] = dp[i-1000][j];
					}
					dp[i][7]++;
					minCnt = dp[i-1000][0]+1;
				}
			}
			if(i>=5000) {
				if(minCnt > dp[i-5000][0]+1) {
					for(int j=1 ; j<9 ; j++) {
						dp[i][j] = dp[i-5000][j];
					}
					dp[i][8]++;
					minCnt = dp[i-5000][0]+1;
				}
			}
			dp[i][0] = minCnt;
		}
		
		int T = sc.nextInt();
		
		for(int tc=1; tc<=T ; tc++) {
			N = sc.nextInt();
			
			System.out.println("#"+tc);
			for(int i=8 ; i>=1 ; i--) {
				System.out.print(dp[N/10][i]+" ");
			}
			System.out.println();
		}
	}
}
