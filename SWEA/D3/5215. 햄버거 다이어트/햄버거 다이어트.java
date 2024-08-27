import java.util.Scanner;

public class Solution {
	static int N, L;
	static int[][] score;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc=1 ; tc<=T ; tc++) {
			N = sc.nextInt();
			L = sc.nextInt();
			
			score = new int[N][2];
			
			for(int i=0 ; i<N ; i++) {
				score[i][0] = sc.nextInt();
				score[i][1] = sc.nextInt();
			}
					
			int ans = powerset(0,0,0);
			System.out.println("#"+tc+" "+ans);
		}
	}
	
	static int powerset(int idx, int sum, int cal) {
		if(cal>L) return 0;
		if(idx>=N) return sum;
		return Math.max(Math.max(powerset(idx+1,sum+score[idx][0],cal+score[idx][1]), powerset(idx+1,sum,cal)), sum);
	}
}
