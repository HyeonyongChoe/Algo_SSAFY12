import java.util.Scanner;

public class Main {
	static int N, M;
	static int[] nums, sets;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		nums = new int[N+1];
		sets = new int[M];
		
		permu(0);
	}
	
	static void permu(int sidx) {
		if(sidx>=M) {
			for(int i=0 ; i<M ; i++) {
				System.out.print(sets[i]+" ");
			}
			System.out.println();
			return;
		}
		
		for(int i=1 ; i<=N ; i++) {
			if(nums[i]!=0) continue;
			
			nums[i]++;
			sets[sidx] = i;
			permu(sidx+1);
			nums[i]--;
		}
		
	}
}
