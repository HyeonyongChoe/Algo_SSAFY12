import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int ans = 0;
		int wer = -1;
		for(int i=N/2 ; i<=N ; i++) {
			int cnt=2;
			int num1 = N;
			int num2 = i;
			while(true) {
				int tmp = num1-num2;
				if(tmp<0) {
					break;
				}
				num1 = num2;
				num2 = tmp;
				cnt++;
			}
			if(ans<cnt) {
				ans = cnt;
				wer = i;
			}
		}
		
		
		System.out.println(ans);
		for(int i=0; i<ans ; i++) {
			int tmp = N-wer;
			System.out.print(N+" ");
			N=wer;
			wer=tmp;
			
		}
	}
}
