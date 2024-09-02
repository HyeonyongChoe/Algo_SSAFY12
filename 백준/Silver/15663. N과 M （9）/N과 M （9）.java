import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int N, M;
	static int[] arr, visited, arr2; 
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		arr = new int[N];
		
		for(int i=0 ; i<N ; i++) {
			arr[i] = sc.nextInt();
		}
		visited = new int[N];
		arr2 = new int[M];
		Arrays.sort(arr);
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
		int[] visited2 = new int[N];
		
		for(int i=0 ; i<N ; i++) {
			if(visited[i]==1) continue;
			if(visited2[i]>0) continue;
			
			arr2[sidx] = arr[i];
			visited[i]++;
			
			for(int j=i ; j<N ; j++) {
				if(arr[j]==arr[i]) {
					visited2[j]++;
				}
			}
			permu(sidx+1);
			visited[i]--;
		}
		
	}
}
