import java.util.Scanner;

public class Solution {
	static int N, max, min;
	static int[] visited, result, num;	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc=1 ; tc<=T ; tc++) {
			N = sc.nextInt();
			visited = new int[4];
			result = new int[N-1];
			num = new int[N];
			
			for(int i=0 ; i<4 ; i++) {
				visited[i] = sc.nextInt();
			}
			
			for(int i=0 ; i<N ; i++) {
				num[i] = sc.nextInt();
			}
			
			max = -100000001;
			min = 100000001;
			permu(0);
			
			int ans = max-min;
			System.out.println("#"+tc+" "+ans);
		}
	}
	
	static void permu(int idx) {
		if(idx>=N-1) {
			int ans = num[0];
			for(int i=1 ; i<N ; i++) {
				if(result[i-1]==0) {
					ans += num[i];
				} else if(result[i-1]==1) {
					ans -= num[i];
				} else if(result[i-1]==2) {
					ans *= num[i];
				} else {
					ans /= num[i];
				}
			}
			if(ans>max) max = ans;
			if(ans<min) min = ans;
			return;
		}
		
		for(int i=0 ; i<4 ; i++) {
			if(visited[i]==0) continue;
			
			visited[i]--;
			result[idx]=i;
			permu(idx+1);
			visited[i]++;
		}
		
	}
}
