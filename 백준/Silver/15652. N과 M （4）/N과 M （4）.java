import java.util.Scanner;

public class Main {
	static int N, M;
	static int[] arr;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		arr = new int[M];
		
		combi(1,0);
	}
	
	static void combi(int idx, int sidx) {
		if(sidx>=M) {
			for(int i=0 ; i<M ; i++) {
				System.out.print(arr[i]+" ");				
			}
			System.out.println();
			return;
		}
		if(idx>N) return;
		
		for(int i=idx ; i<=N ; i++) {
			arr[sidx] = i;
			combi(i, sidx+1);
		}
		
	}
}
