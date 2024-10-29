import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	static int N ,M, K;
	static int[] know;	
	static ArrayList<Integer>[] arr, party;
	static boolean[] visited;
			
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		K = sc.nextInt();
		
		know = new int[K];
		
		for(int i=0 ; i<K ; i++) {
			know[i] = sc.nextInt();
		}
		
		arr = new ArrayList[N+1];
		party = new ArrayList[M];
		
		for(int i=1 ; i<=N ; i++) {
			arr[i] = new ArrayList<>();
		}
		for(int i=0 ; i<M ; i++) {
			int V = sc.nextInt();
			party[i] = new ArrayList<>();
			
			for(int j=0 ; j<V ; j++) {
				party[i].add(sc.nextInt());
			}
			
			for(int j=0 ; j<V ; j++) {
				for(int k=0 ; k<V ; k++) {
					int a = party[i].get(j);
					int b = party[i].get(k);
					if(a!=b) {
						arr[a].add(b);
						arr[b].add(a);
					}
				}
			}
		}
		
		visited = new boolean[N+1];
		
		for(int i=0 ; i<K ; i++) {
			visited[know[i]] = true;
			for(int p : arr[know[i]]) {
				if(visited[p]) continue;
				visited[p] = true;
				dfs(p);
			}
		}
		int ans = M;
		for(ArrayList<Integer> part : party) {
			for(int p: part) {
				if(visited[p]) {
					ans--;
					break;
				}
			}
		}
		
		System.out.println(ans);
	}
	
	static void dfs(int p) {
		for(int next : arr[p]) {
			if(visited[next]) continue;
			visited[next] = true;
			dfs(next);
		}
	}
}
