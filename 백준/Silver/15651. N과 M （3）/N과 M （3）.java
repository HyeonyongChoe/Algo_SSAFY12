import java.util.Scanner;

public class Main {
	static int N,M;
	static int[] arr;
	static StringBuilder sb;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		sb = new StringBuilder();
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		arr = new int[N];
		permu(0);
		System.out.println(sb);
	}
	
	static void permu(int sidx) {
		if(sidx>=M) {
			for(int i=0 ; i<M ; i++) {
				sb.append(arr[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=1 ; i<=N ; i++) {
			arr[sidx] = i;
			permu(sidx+1);
		}
	}
}
