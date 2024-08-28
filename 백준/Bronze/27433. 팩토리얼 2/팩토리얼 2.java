import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		
		long ans = fac(N);
		System.out.println(ans);
	}
	
	static long fac(int n) {
		if(n<=1) return 1;
		
		return n*fac(n-1);
	}
}
