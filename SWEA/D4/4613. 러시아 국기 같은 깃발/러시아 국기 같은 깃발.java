import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc=1 ; tc<=T ; tc++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			char[][] flag = new char[N][M];
			int[][] cnt = new int[N][3];
			
			int ans = N*M;
			
			for(int i=0 ; i<N ; i++) {
				String line = sc.next();
				for(int j=0 ; j<M ; j++) {
					flag[i][j] = line.charAt(j);
					if(line.charAt(j)=='W') cnt[i][0]++;
					if(line.charAt(j)=='B') cnt[i][1]++;
					if(line.charAt(j)=='R') cnt[i][2]++;
					
				}
			}
			
			
			for(int i=0 ; i<N-2 ; i++) {
				for(int j=i+1 ; j<N-1; j++) {
					int sum = 0;
					for(int k=0 ; k<N ; k++) {
						if(k<=i) {
							sum += M-cnt[k][0];
						} else if(k>i && k<=j) {
							sum += M-cnt[k][1];
						} else {
							sum += M-cnt[k][2];
						}
					}
					if (sum<ans) ans = sum;
				}
			}
			System.out.println("#"+tc+" "+ans);
			 
		}
	}
}
