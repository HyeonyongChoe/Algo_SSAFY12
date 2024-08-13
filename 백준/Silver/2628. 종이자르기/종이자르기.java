import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int C = sc.nextInt();
		int R = sc.nextInt();
		int N = sc.nextInt();
		
		int[][] cnt = new int[2][N+1];
		
		int idx1 = 0;
		int idx2 = 0;
		for(int i=0 ; i<N ; i++) {
			int rc = sc.nextInt();
			int num = sc.nextInt();
			if(rc==0) {
				cnt[rc][idx1++]=num;
			} else {
				cnt[rc][idx2++]=num;
			}
		}
		Arrays.sort(cnt[0]);
		Arrays.sort(cnt[1]);
		
		int max1 = R-cnt[0][N];
		int max2 = C-cnt[1][N];
		if(idx1>0) {
			for(int i=N ; i>N-idx1 ;i--) {
				int tmp = cnt[0][i]-cnt[0][i-1];
				if(max1<tmp) max1=tmp;
			}
			if(max1<cnt[0][0]) max1 = cnt[0][0];
		}
		
		if(idx2>0) {
			for(int i=N ; i>N-idx2 ;i--) {
				int tmp = cnt[1][i]-cnt[1][i-1];
				if(max2<tmp) max2=tmp;
			}
			if(max2<cnt[1][0]) max2 = cnt[1][0];
		}
		
		System.out.println(max1*max2);
	}
}
