import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
	static int N, M;
	static int[][] map;
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc=1 ; tc<=T ;tc++) {
			N = sc.nextInt();
			M = sc.nextInt();
			
			map = new int[N][N];
			List<int[]> homeList = new ArrayList<>();
			
			for(int i=0 ; i<N ; i++) {
				for(int j=0 ; j<N ; j++) {
					map[i][j] = sc.nextInt();
					if(map[i][j]==1) homeList.add(new int[] {i,j});
				}
			}
			int ans = 0;
			
			out :
			for(int i=N+1 ; i>0 ; i--) {
				for(int r=0 ; r<N ; r++) {
					for(int c=0 ; c<N ; c++) {
						int tmp = 0;
						for(int k=0 ; k<homeList.size() ; k++) {
							int hr = homeList.get(k)[0];
							int hc = homeList.get(k)[1];
							if(Math.abs(r-hr)+Math.abs(c-hc)<=i-1) tmp++;
						}
						if((tmp*M) - ((i*i)+(i-1)*(i-1))>=0) {
							if(ans<tmp) ans = tmp;
						}
					}
				}
				if(ans>0) break out;
			}
			
			System.out.println("#"+tc+" "+ans);
		}
	}
}
