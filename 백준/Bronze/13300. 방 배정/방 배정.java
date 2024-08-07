import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		int cnt = 0;
		int[] bStudent = new int[7];
		int[] gStudent = new int[7];
		
		for(int i=0 ; i<N ; i++) {
			int S = sc.nextInt();
			int Y = sc.nextInt();
			
			if(S==0) {
				gStudent[Y]++;
			} else {
				bStudent[Y]++;
			}
			
		}
		for(int i=1 ; i<=6 ;i++) {
			if(gStudent[i]!=0) {				
				cnt += gStudent[i]/K;
				if(gStudent[i]%K!=0) cnt++;
			}
			if(bStudent[i]!=0) {				
				cnt += bStudent[i]/K;
				if(bStudent[i]%K!=0) cnt++;
			}
			
		}
		System.out.println(cnt);
	}
}
