import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc=1 ; tc<=T ; tc++) {
			int K = sc.nextInt();
			
			int[] bills = new int[K];
			
			int idx=0;
			for(int i=0 ; i<K ; i++) {
				int input = sc.nextInt();
				if(input!=0) {
					bills[idx++] = input;
				}
				else {
					bills[--idx] = 0;
				}
			}
			int ans = 0;
			for(int i=0 ; i<K ; i++) {
				ans += bills[i];
				if(bills[i]==0) break;
			}
			System.out.println("#"+tc+" "+ans);
		}
	}
}
