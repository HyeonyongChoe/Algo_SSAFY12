import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int tc=1 ; tc<=T ; tc++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			int[][] arr = new int[N][N];
			
			for(int i=0 ; i<N ; i++) {
				for(int j=0 ; j<N ; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			int max = -1;
			for(int i=0 ; i<N-M+1 ; i++) {
				for(int j=0 ; j<N-M+1 ; j++) {
					int cnt=0;
					for(int ii=i ; ii<i+M ; ii++) {
						for(int jj=j ; jj<j+M ; jj++) {
							cnt += arr[ii][jj];
						}
					}
					if(cnt>max) max = cnt;
				}
			}
			System.out.println("#"+tc+" "+max);
		}
	}
}
