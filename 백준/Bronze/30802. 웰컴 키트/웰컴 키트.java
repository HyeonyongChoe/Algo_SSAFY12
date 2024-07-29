import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] shirts = new int[6];
		for (int i=0 ; i<6 ; i++) {
			shirts[i] = sc.nextInt();
		}
		int T = sc.nextInt();
		int P = sc.nextInt();
		int cnt = 0;
		for(int i=0 ; i<6 ; i++) {
			if (shirts[i]%T ==0 ) {
				cnt += shirts[i]/T;
			} else {
				cnt += shirts[i]/T+1;
			}
		}
		System.out.println(cnt);
		System.out.println(N/P+" "+N%P);
	}
}
