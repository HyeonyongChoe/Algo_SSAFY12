import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int[][] star = new int[N][N];
		int cnt = 1;
		for(int i=0 ; i<N ; i++) {
			for(int j=0 ; j<N ; j++) {
				if(N-j<=cnt) {
					System.out.print("*");
				} else {
					System.out.print(" ");
				}
			}
			cnt++;
			System.out.println();
		}
	}
}
