import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int L = sc.nextInt();
		int N = sc.nextInt();
		
		int[] rollCake = new int[L+1];
		int emax = 0;
		int eidx = 0;
		
		int rmax = 0;
		int ridx = 0;
		
		int now = 0;
		for(int i=1 ; i<=N ; i++) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			
			int tmp = end-start+1;
			
			if(tmp>emax) {
				emax = tmp;
				eidx = i;
			}
			int cnt=0;
			for(int j=start; j<=end ; j++) { 
				if(rollCake[j]==0) {
					cnt++;
					rollCake[j]=i;
				}
			}
			
			if(end>now) {
				now = end;				
			}
			if(cnt>rmax) {
				rmax = cnt;
				ridx = i;
			}
			
		}
		System.out.println(eidx);
		System.out.println(ridx);
		
	}
}
