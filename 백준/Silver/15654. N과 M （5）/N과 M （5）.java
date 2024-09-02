import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int N, M;
	static int[] arr, arr2, visited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		arr = new int[N];
		
		for(int i=0 ; i<N ; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		arr2 = new int[M];
		visited = new int[N];
		
		permu(0);
	}
	
	static void permu(int sidx) {
		if(sidx>=M) {
			for(int i=0 ; i<M ; i++) {
				System.out.print(arr2[i]+" ");
			}
			System.out.println();
			return;
		}
		
		for(int i=0 ; i<N ; i++) {
			if(visited[i]==1) continue;
			
			arr2[sidx] = arr[i];
			visited[i]++;
			permu(sidx+1);
			visited[i]--;
		}
	}
}
