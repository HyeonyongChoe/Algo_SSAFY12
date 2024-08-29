import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc=1 ; tc<=T ; tc++) {
			int N = sc.nextInt();
			int X = sc.nextInt();
			
			int[][] ground = new int[N][N];
			
			for(int i=0 ; i<N ; i++) {
				for(int j=0 ; j<N ; j++) {
					ground[i][j] = sc.nextInt();
				}
			}
			
			int ans = 0;
			for(int i=0 ; i<N ; i++) {
				int tmp = 1;
				boolean flag1 = true;
				for(int j=1 ; j<N ; j++) {
					if(ground[i][j]==ground[i][j-1]) {
						tmp++;
					} else if(ground[i][j]-ground[i][j-1]==1) {
						if(tmp>=X) {
							tmp = 1;
							continue;
						} else {
							flag1 = false;
							break;
						}
					} else if(ground[i][j-1]-ground[i][j]==1) {
						int tmp2 = 1;
						j++;
						while(j<N) {
							if(ground[i][j]==ground[i][j-1]) {
								tmp2++;
								j++;
							} else {									
								break;
							}
						}
						if(tmp2>=X) {
							tmp = tmp2-X;
							j--;
						} else {
							flag1 = false;
							break;
						}
					} else {
						flag1 = false;
						break;
					}
				}
				
				if(flag1) ans++;
			}
			
			for(int j=0 ; j<N ; j++) {
				int tmp = 1;
				boolean flag1 = true;
				for(int i=1 ; i<N ; i++) {
					if(ground[i][j]==ground[i-1][j]) {
						tmp++;
					} else if(ground[i][j]-ground[i-1][j]==1) {
						if(tmp>=X) {
							tmp = 1;
							continue;
						} else {
							flag1 = false;
							break;
						}
					} else if(ground[i-1][j]-ground[i][j]==1) {
						int tmp2 = 1;
						i++;
						while(i<N) {
							if(ground[i][j]==ground[i-1][j]) {
								tmp2++;
								i++;
							} else {
								break;
							}
						}
						if(tmp2>=X) {
							tmp = tmp2-X;
							i--;
						} else {
							flag1 = false;
							break;
						}
					} else {
						flag1 = false;
						break;
					}
				}
				
				if(flag1) ans++;
			}
			
			
			System.out.println("#"+tc+" "+ans);
			
		}
	}
}
