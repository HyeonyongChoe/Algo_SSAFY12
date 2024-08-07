import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc=1 ; tc<=T ; tc++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			int[] deck1 = new int[N+1];
			int[] deck2 = new int[M+1];
			
			int[] cnt = new int[N+M+1];
			int max = -1;
			for(int i=1 ; i<=N ; i++) {
				for(int j=1 ; j<=M ; j++) {
					cnt[i+j]++;
					if(max<cnt[i+j]) max=cnt[i+j];
				}
			}
			
			System.out.print("#"+tc+" ");
			for(int i=1 ; i<=M+N ; i++) {
				if(cnt[i]==max) System.out.print(i+" ");
			}
			System.out.println();
		}
	}
}
