import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	static int N, K;
	static int[] num;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc=1 ;tc<=T ; tc++) {
			N = sc.nextInt();
			K = sc.nextInt();
			
			num = new int[N];
			
			for(int i=0 ; i<N ; i++) {
				num[i] = sc.nextInt();
			}
			
			int ans = 0;
			for(int i=1 ; i<=N ; i++) {
				int[] arr = new int[i];
				ans += powerset(0,0,arr);
			}
			System.out.println("#"+tc+" "+ans);
		}
	}
	
	static int powerset(int idx, int sidx, int[] arr) {
		
		if(idx>=N && sidx<arr.length) return 0;
		if(sidx == arr.length) {
			int tmp = 0;
			for(int i=0 ; i<sidx ; i++) {
				tmp += arr[i];
			}
			if(tmp==K) {
				return 1;
			}
			
			else return 0;
		}
		arr[sidx] = num[idx];
		return powerset(idx+1, sidx+1, arr) + powerset(idx+1, sidx, arr);
	}
}
