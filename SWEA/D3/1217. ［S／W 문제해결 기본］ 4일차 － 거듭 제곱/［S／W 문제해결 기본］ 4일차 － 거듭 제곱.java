import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int tc=1 ; tc<=10 ; tc++) {
			int tCase = sc.nextInt();
			
			int N = sc.nextInt();
			int M = sc.nextInt();
			int ans = pow(N,M);
			
			System.out.println("#"+tc+" "+ans);
		}
	}
	
	static int pow(int n, int m) {
		if(m==0) return 1;
		if(m%2==0) {
			int tmp = pow(n,m/2);
			return tmp * tmp; 
		} else {
			int tmp = pow(n,(m-1)/2);
			return tmp * tmp * n;
		}
	}
}
