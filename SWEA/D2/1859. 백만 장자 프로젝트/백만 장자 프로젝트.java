import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc=1 ; tc<=T ; tc++) {
			int N = sc.nextInt();
			int[] predict = new int[N];
			for(int i=0 ; i<N ; i++) {
				predict[i] = sc.nextInt();
			}
			
			long ans = 0;
			int max = predict[N-1];
			for(int i=N-2 ; i>=0 ; i--) {
				if(max<predict[i]) {
					max = predict[i];
				} else {
					ans += max-predict[i];
				}
			}
			
			System.out.println("#"+tc+" "+ans);
		}
	}
}

