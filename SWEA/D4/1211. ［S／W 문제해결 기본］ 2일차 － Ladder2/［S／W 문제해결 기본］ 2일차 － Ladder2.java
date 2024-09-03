import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int tc=1 ; tc<=10 ; tc++) {
			int tCase = sc.nextInt();
			
			int[][] ladder = new int[100][100];
			int[] start = new int[50];
			
			int idx=0;
			for(int i=0 ; i<100 ; i++) {
				for(int j=0 ; j<100 ; j++) {
					ladder[i][j] = sc.nextInt();
					if(i>0) continue;
					if(ladder[0][j]==1) start[idx++] = j;
				}
			}
			start[idx] = -1;
			int min = 987654321;
			int ans = 0;
			for(int x=0 ; x<50 ; x++) {
				if(start[x]==-1) break;
				
				int cnt = 0;
				int cx = x;
				
				for(int y=0 ; y<100 ; y++) {
					cnt++;						
					if(cx-1>=0 && ladder[y][start[cx]-1]==1) {
						cnt += start[cx]-start[cx-1];
						cx--;
						continue;
					} else if(cx+1<idx && ladder[y][start[cx]+1]==1) {
						cnt += start[cx+1]-start[cx];
						cx++;
					} 
				}
				if(cnt<=min) {
					min = cnt;
					ans = start[x];
				}
				
			}
			System.out.println("#"+tc+" "+ans);
		}
	}
}
