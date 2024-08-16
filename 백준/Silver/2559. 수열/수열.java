import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		int[] tem = new int[N+1];
		
		for(int i=1 ; i<=N ; i++) {
			int tmp = sc.nextInt();
			tem[i] = tem[i-1] + tmp;
		}
		int ans = -100*K;
		for(int i=0 ; i<N-K+1 ; i++) {
			int tmp = tem[i+K] - tem[i];
			if(ans<tmp) ans = tmp;
		}
		System.out.println(ans);
	}
}
