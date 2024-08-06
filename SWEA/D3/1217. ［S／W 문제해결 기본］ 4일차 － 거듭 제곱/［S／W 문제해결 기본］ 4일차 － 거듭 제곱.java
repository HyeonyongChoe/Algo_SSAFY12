import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int tc=1 ; tc<=10 ; tc++) {
			int tCase = sc.nextInt();
			
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			int ans = pow(N,M);
			
			System.out.println("#"+tCase+" "+ans);
		}
	}
	
	static int pow(int N, int M) {
		if (M == 0) return 1;
		return N * pow(N,M-1);
	}
}
