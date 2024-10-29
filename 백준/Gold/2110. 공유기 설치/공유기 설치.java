import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int C = sc.nextInt();
		
		int[] home = new int[N];
		for(int i=0 ; i<N ; i++) {
			home[i] = sc.nextInt();
		}
		Arrays.sort(home);
		
		int left = 1;
		int right = home[N-1] - home[0] + 1;
		
		while(left<right) {
			int mid = (left+right)/2;
			
			int cnt = 1;
			int start = home[0];
			for(int i=1 ; i<N ; i++) {
				int now = home[i];
				
				if(now - start >= mid) {
					cnt++;
					start = now;
				}
			}
			
			if(cnt<C) {
				right = mid;
			} else {
				left = mid+1;
			}
		}
		
		System.out.println(left-1);
	}
}
