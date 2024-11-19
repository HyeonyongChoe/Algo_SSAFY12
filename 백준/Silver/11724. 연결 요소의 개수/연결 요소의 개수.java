import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	static int N, M;
	static ArrayList<Integer>[] tree;
	static boolean[] visited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		tree = new ArrayList[N+1];
		
		for(int i=0 ; i<=N ; i++) {
			tree[i] = new ArrayList<>();
		}
		
		for(int i=0 ; i<M ; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			tree[a].add(b);
			tree[b].add(a);
		}
		
		visited = new boolean[N+1];
		int cnt = 0;
		for(int i=1 ; i<=N ; i++) {
			if(!visited[i]) {
				visited[i]=true;
				dfs(i);
				cnt++;
			}
		}
		
		System.out.println(cnt);
	}
	
	static void dfs(int node) {
		for(int nxt : tree[node]) {
			if(!visited[nxt]) {
				visited[nxt] = true;
				dfs(nxt);
			}
		}
	}
}
