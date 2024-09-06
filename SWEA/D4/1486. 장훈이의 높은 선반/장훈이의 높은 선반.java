import java.util.Scanner;

public class Solution {
	static int N, B, ans, sum;
	static int[] height;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc=1 ; tc<=T ; tc++) {
			N = sc.nextInt();
			B = sc.nextInt();
			
			height = new int[N];
			
			ans = 0; 
			for(int i=0 ; i<N ; i++) {
				height[i] = sc.nextInt();
				ans += height[i];
			}
			sum = 0;
			combi(0,0);
			
			ans -= B;
			System.out.println("#"+tc+" "+ans);
		}
	}
	
	static void combi(int sidx, int idx) {
		if(sum>=B) {
			if(ans>sum) ans = sum;
			return;
		}
		if(idx>=N) return;
		
		sum += height[idx];
		combi(sidx+1, idx+1);
		sum -= height[idx];
		combi(sidx, idx+1);
	}
}
