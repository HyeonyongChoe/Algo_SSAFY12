import java.util.Scanner;
import java.util.TreeSet;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		
		for(int tc=1 ; tc<=T ; tc++) {
			int N = sc.nextInt();
			
			int ans = 0;
			TreeSet<Integer> set = new TreeSet<>();
			while(set.size()<10) {
				ans += N;
				int tmp = ans;
				while(tmp!=0) {
					int num = tmp%10;
					set.add(num);
					tmp /= 10;
				}
			}
			
			System.out.println("#"+tc+" "+ans);
		}
	}
}
