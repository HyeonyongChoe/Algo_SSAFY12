import java.util.Scanner;

public class Solution {
	static int dFee, mFee, qFee, yFee, ans, sum;
	static int[] plan = new int[13];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc=1 ; tc<=T ; tc++) {
			dFee = sc.nextInt();
			mFee = sc.nextInt();
			qFee = sc.nextInt();
			yFee = sc.nextInt();
			
			for(int i=1;  i<=12 ; i++) {
				plan[i] = sc.nextInt();
			}
			
			ans = yFee;
			sum = 0;
			
			permu(1);
			System.out.println("#"+tc+" "+ans);
		}
	}
	
	static void permu(int idx) {
		if(idx>12) {
			if(ans>sum) ans = sum;
			return;
		}
		if(plan[idx]==0) {
			permu(idx+1);
		} else {
			sum += dFee*plan[idx];
			permu(idx+1);
			sum -= dFee*plan[idx];
			
			sum += mFee;
			permu(idx+1);
			sum -= mFee;
			
			sum += qFee;
			permu(idx+3);
			sum -= qFee;
		}
	}
}
