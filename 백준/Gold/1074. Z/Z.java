import java.util.Scanner;

public class Main {
	static int N, r, c, cnt;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		r = sc.nextInt();
		c = sc.nextInt();
		
		cnt = 0;
		
		visitZ(N,0,0);
	}
	
	static void visitZ(int n, int startR, int startC) {
		int len = (int) Math.pow(2, n);
		if(len==2) {
			for(int i=0; i<2 ; i++) {
				for(int j=0 ; j<2 ; j++) {
					if(startR+i==r && startC+j==c) {
						System.out.println(cnt);
						return;
					}
					cnt++;
				}
			}
			
			return;
		}
		
		if(r<startR+len/2 && c<startC+len/2) {
			visitZ(n-1, startR, startC);			
		} else if(r<startR+len/2 && c>=startC+len/2) {
			cnt += len*len/4;
			visitZ(n-1, startR, startC+len/2);			
		} else if(r>=startR+len/2 && c<startC+len/2) {
			cnt += len*len/4*2;
			visitZ(n-1, startR+len/2, startC);		
		} else {
			cnt += len*len/4*3;
			visitZ(n-1, startR+len/2, startC+len/2);			
		}
	}
}
