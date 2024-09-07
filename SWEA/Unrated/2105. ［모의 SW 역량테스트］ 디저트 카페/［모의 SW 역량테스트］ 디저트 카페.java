import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	static int N;
	static int[][] dessert;
	static int[] dessertList = new int[101];
	static int[] dr = {1,1,-1,-1};
	static int[] dc = {1,-1,-1,1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc=1 ; tc<=T ; tc++) {
			N = sc.nextInt();
			
			dessert = new int[N][N];
			
			for(int i=0 ; i<N ; i++) {
				for(int j=0 ; j<N ; j++) {
					dessert[i][j] = sc.nextInt();
				}
			}
			
			int ans = -1;
			
			out :
			for(int l=N-1 ; l>=2 ; l--) {
				for(int r=0 ; r<N-1 ; r++) {
					for(int c=1 ; c<N-1 ; c++) {
						for(int i=1 ; i<l ; i++) {
							int w = i;
							int h = l-i;
							if(w<=c && c+h<=N-1 && r+l<=N-1) {
								int tmp = chk(w,h,r,c);
								Arrays.fill(dessertList, 0);
								if (tmp!=0) {
									ans = tmp;
									break out;
								}
							}
							
						}
					}
				}
			}
			System.out.println("#"+tc+" "+ans);
		}
	}
	
	static int chk(int w, int h, int r, int c) {
		
		int cnt = 0;
		for(int d=0 ; d<4 ; d++) {
			if(d%2==0) {
				for(int i=0 ; i<h ; i++) {
					int nr = r+dr[d];
					int nc = c+dc[d];
					if(dessertList[dessert[nr][nc]]!=0) return 0;
					dessertList[dessert[nr][nc]]++;
					cnt++;
					r = nr;
					c = nc;
				}
			} else {
				for(int i=0 ; i<w ; i++) {
					int nr = r+dr[d];
					int nc = c+dc[d];
					if(dessertList[dessert[nr][nc]]!=0) return 0;
					dessertList[dessert[nr][nc]]++;
					cnt++;
					r = nr;
					c = nc;
				}
			}
		}
		return cnt;
	}
}
