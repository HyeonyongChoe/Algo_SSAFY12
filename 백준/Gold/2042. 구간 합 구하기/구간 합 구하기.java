import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static long[] arr;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		int K = sc.nextInt();
		
		arr = new long[2*N+1];
		
		for(int i=N+1 ; i<=2*N ; i++) {
			arr[i] = sc.nextLong();
			int idx = i/2;
			while(idx!=0) {
				arr[idx] += arr[i];
				idx /= 2;
			}
		}
		
		for(int i=0 ; i<M+K ; i++) {
			int action = sc.nextInt();
			
			if(action==1) {
				int idx = N+sc.nextInt();
				long num = sc.nextLong();
				long pre_num = arr[idx];
				while(idx!=0) {
					arr[idx] -= pre_num;
					arr[idx] += num;
					idx /= 2;
				}
			} else {
				int left = N+sc.nextInt();
				int right = N+1+sc.nextInt();
				
				long ans = 0;
				
				while(left!=right) {
					if(left%2==1) ans += arr[left++];
					if(right%2==1) ans += arr[--right];
					
					left /= 2;
					right /= 2;
				}
				
				System.out.println(ans);
			}
		}
		
	}
}
