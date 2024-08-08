import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc=1 ; tc<=T ; tc++) {
			int N = sc.nextInt();
			
			char[][] farm = new char[N][];
			
			for(int i=0 ; i<N ; i++) {
					farm[i] = sc.next().toCharArray();
			}
			int sum = 0;
			for(int i=0 ; i<N ; i++) {
				for(int j=0 ; j<N ; j++) {
					sum += farm[i][j]-'0';
				}
			}
			for(int i=0 ; i<N/2 ; i++) {
				for(int j=0 ; j<N/2 ; j++) {
					if(i+j<N/2) {
						sum -= farm[i][j]-'0';
						sum -= farm[N-1-i][N-1-j]-'0';
						sum -= farm[i][N-1-j]-'0';
						sum -= farm[N-1-i][j]-'0';
					}
				}
			}
			System.out.println("#"+tc+" "+sum);
		}
	}
}
