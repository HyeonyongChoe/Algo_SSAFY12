import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int M = sc.nextInt();
		int N = sc.nextInt();
		int[][] map = new int[M][N];
		int[][] arr = new int[M*N][3];
		int[][] dp = new int[M][N];
		int cnt = 0;
		for(int i=0 ; i<M ; i++) {
			for(int j=0 ; j<N ; j++) {
				map[i][j] = sc.nextInt();
				arr[cnt][0] = i;
				arr[cnt][1] = j;
				arr[cnt][2] = map[i][j];
				cnt++;
			}
		}
		Arrays.sort(arr, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o2[2]-o1[2];
			}
		});
		for(int i=0 ; i<cnt ; i++) {
			if(arr[i][0]==0&&arr[i][1]==0) {
				dp[0][0] = 1;
				continue;
			}
			int c = arr[i][0];
			int r = arr[i][1];
			if(r-1>=0 && map[c][r]!=map[c][r-1]) dp[c][r]+=dp[c][r-1];
			if(r+1<N && map[c][r]!=map[c][r+1]) dp[c][r]+=dp[c][r+1];
			if(c-1>=0 && map[c][r]!=map[c-1][r]) dp[c][r]+=dp[c-1][r];
			if(c+1<M && map[c][r]!=map[c+1][r]) dp[c][r]+=dp[c+1][r];
		}
		System.out.println(dp[M-1][N-1]);
	}
}
