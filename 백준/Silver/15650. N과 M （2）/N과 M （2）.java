import java.util.Scanner;

public class Main {
	static int N, M;
	static int[] ans;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		ans = new int[M];
		
		combi(1,0);
	}
	
	static void combi(int idx, int sidx) {
		if(idx>N+1) return;
		if(sidx>=M) {
			for(int i=0 ; i<M ; i++) {
				System.out.print(ans[i]+" ");
			}
			System.out.println();
			return;
		}
		
		ans[sidx] = idx;
		combi(idx+1,sidx+1);
		combi(idx+1,sidx);
	}
}
