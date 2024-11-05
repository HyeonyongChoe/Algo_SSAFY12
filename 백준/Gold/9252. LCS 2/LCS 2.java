import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		char[] a = sc.next().toCharArray();
		char[] b = sc.next().toCharArray();
		
		int[][] dp = new int[a.length+1][b.length+1];
		
		for(int i=0 ; i<a.length ; i++) {
			for(int j=0 ;j<b.length ; j++) {
				if(a[i]==b[j]) {
					dp[i+1][j+1] = dp[i][j]+1;
				} else {
					dp[i+1][j+1] = Math.max(dp[i][j+1], dp[i+1][j]);
				}
			}
		}
		
		int n = dp[a.length][b.length];
		char[] arr = new char[n];
		
		int idx = n-1;
		int x = a.length;
		int y = b.length;
		while(idx>=0) {
			if(a[x-1]==b[y-1]) {
				arr[idx] = a[x-1];
				x--;
				y--;
				idx--;
			} else {
				if(dp[x][y-1]>dp[x-1][y]) {
					y--;
				} else {
					x--;
				}
			}
		}
		
		String ans = String.valueOf(arr);
		
		System.out.println(n);
		if(n>0) System.out.println(ans);
	}
}
