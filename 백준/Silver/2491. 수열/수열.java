import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int[] nums = new int[N];
		
		for(int i=0 ; i<N ; i++) {
			nums[i] = sc.nextInt();
		}
		int max = 1;
		int cnt=1;
		for(int i=0 ; i<N-1 ; i++) {
			if(nums[i]<=nums[i+1]) {
				cnt++;
				if(max<cnt) max=cnt;
			} else {
				cnt=1;
			}
		}
		cnt=1;
		for(int i=0 ; i<N-1 ; i++) {
			if(nums[i]>=nums[i+1]) {
				cnt++;
				if(max<cnt) max=cnt;
			} else {
				cnt=1;
			}
		}
		
		System.out.println(max);
	}
}
