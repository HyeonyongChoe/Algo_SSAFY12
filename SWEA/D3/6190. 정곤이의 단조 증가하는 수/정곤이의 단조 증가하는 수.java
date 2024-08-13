import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc=1 ; tc<=T ; tc++) {
			int N = sc.nextInt();
			
			int[] increNum = new int[N];
			
			for(int i=0 ; i<N ; i++) {
				increNum[i] = sc.nextInt();
			}
			int ans = -1;
			for(int i=N-1 ; i>=0 ; i--) {
				for(int j=i-1 ; j>=0 ; j--) {
					int tmp = -1;
					if( i==j || (increNum[i]*increNum[j])%10==0) {
						continue;
					} else {
						int chk = increNum[i]*increNum[j];
						int num = chk%10;
						chk /= 10;
						boolean flag = true;
						while(chk!=0) {
							if((chk%10)<=num) {
								num = chk%10;
								chk /= 10;
							}
							else {
								flag = false;
								break;
							}
						}
						if (flag==true) {
							tmp = increNum[i]*increNum[j];
						}
					}
					if(ans<tmp) {
						ans = tmp;
					}
				}
			}
			
			System.out.println("#"+tc+" "+ans);
		}
	}
}
