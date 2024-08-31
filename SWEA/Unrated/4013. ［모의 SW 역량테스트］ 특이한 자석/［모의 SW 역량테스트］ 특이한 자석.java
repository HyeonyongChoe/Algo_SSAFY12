import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	static int[] head, visited;
	static int[][] magnet;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc=1 ; tc<=T ; tc++) {
			int K = sc.nextInt();
			
			magnet = new int[4][8];
			
			for(int i=0 ; i<4 ; i++) {
				for(int j=0 ; j<8 ; j++) {
					magnet[i][j] = sc.nextInt();
				}
			}
			head = new int[4];
			
			for(int i=0 ; i<K ; i++) {
				visited = new int[4];
				int idx = sc.nextInt()-1;
				int d = sc.nextInt();
				visited[idx] += d;
				rotate(idx+1,-d,2,magnet[idx][(2+head[idx])%8]);
				rotate(idx-1,-d,6,magnet[idx][(6+head[idx])%8]);
				
				for(int j=0 ; j<4 ; j++) {
					head[j] =(head[j] + 8 - visited[j])%8;
				}
			}
			
			int ans = 0;
			for(int i=0 ; i<4 ; i++) {
				if(magnet[i][head[i]]!=0) {
					ans += (1<<i);
				}
			}
			
			System.out.println("#"+tc+" "+ans);
		}
	}
	
	static void rotate(int idx, int d, int num, int ns) {
		if(idx<0 || idx>=4 || visited[idx]!=0) return;
		
		if((magnet[idx][(8-num+head[idx])%8]-ns)==0) return;
		
		visited[idx] += d;
		rotate(idx+1, -d, 2, magnet[idx][(2+head[idx])%8]);
		rotate(idx-1, -d, 6, magnet[idx][(6+head[idx])%8]);
	}
}
