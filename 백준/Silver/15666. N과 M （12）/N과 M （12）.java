import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int N, M;
	static int[] arr1, arr2, visited1;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		arr1 = new int[N];
		
		for(int i=0 ; i<N ; i++) {
			arr1[i] = sc.nextInt();
		}
		Arrays.sort(arr1);
		visited1 = new int[N];
		arr2 = new int[M];
		
		permu(0,0);
	}
	
	static void permu(int idx,int sidx) {
		if(sidx>=M) {
			for(int i=0 ; i<M ; i++) {
				System.out.print(arr2[i]+" ");
			}
			System.out.println();
			return;
		}
		
		int[] visited2 = new int[N];
		for(int i=idx ; i<N ; i++) {
			if(visited2[i]>0) continue;
			
			arr2[sidx] = arr1[i];
			visited1[i]++;
			for(int j=i ; j<N ; j++) {
				if(arr1[j]==arr1[i]) {
					visited2[j]++;
				}
			}
			permu(i,sidx+1);
			visited1[i]--;
		}
	}
}
