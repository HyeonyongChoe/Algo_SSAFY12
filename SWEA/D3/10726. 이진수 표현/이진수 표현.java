import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc=1 ; tc<=T ; tc++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			int cnt=0;
			for(int i=0 ; i<N ; i++) {
				int tmp = M%2;
				if(tmp==0) break;
				else {
					cnt++;
					M /= 2;
				}
			}
			if(cnt==N) {
				System.out.println("#"+tc+" ON");
			} else {
				System.out.println("#"+tc+" OFF");
			}
		}
	} 
}
