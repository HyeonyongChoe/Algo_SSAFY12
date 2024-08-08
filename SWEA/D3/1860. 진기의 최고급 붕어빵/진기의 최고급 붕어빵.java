import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc=1 ; tc<=T ; tc++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int K = sc.nextInt();
			
			int[] time = new int[N];
			for(int i=0 ; i<N ; i++) {
				time[i] = sc.nextInt();
			}
			Arrays.sort(time);
			
			int t=0;
			int remainT = M;
			int remainB = 0;
			int idx = 0;
			int ans = 1;
			
			while(t<time[N-1]) {
				if(time[idx]==0 || time[0] < M) {
					ans=0;
					break;
				}
				t++;
				remainT--;
				if(remainT==0) {
					remainB += K;
					remainT = M;
				}
				if(t==time[idx]) {
					while(t==time[idx] && idx<time.length-1) {
						remainB--;
						idx++;
					}
				}
				if(remainB<0) {
					ans = 0;
					break;
				}
				if(t==time[N-1] && remainB<=0) {
					ans = 0;
					break;
				}
			}
			
			if(ans==1) {
				System.out.println("#"+tc+" Possible");
			} else {
				System.out.println("#"+tc+" Impossible");
			}
		}
	}
}
