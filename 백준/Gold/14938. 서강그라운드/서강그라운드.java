import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	static int n, m, r, ans, cnt;
	static int[] node;
	static boolean[] visited;
	static ArrayList<int[]>[] tree;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		r = sc.nextInt();
		
		node = new int[n+1];
		tree = new ArrayList[n+1];
		
		for(int i=1 ; i<=n ; i++) {
			node[i] = sc.nextInt();
		}
		
		for(int i=0 ; i<=n ; i++) {
			tree[i] = new ArrayList<>();
		}
		
		for(int i=0 ; i<r ; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int w = sc.nextInt();
			tree[a].add(new int[] {b,w});
			tree[b].add(new int[] {a,w});
		}
		ans = 0;
		for(int i=1 ; i<=n ; i++) {
			visited = new boolean[n+1];
			visited[i] = true;
			cnt = node[i];
			dfs(i,m);
			if(ans<cnt) ans = cnt;
		}
		
		System.out.println(ans);
	}
	
	static void dfs(int v, int dis) {
		
		for(int i=0 ; i<tree[v].size() ; i++) {
			if(tree[v].get(i)[1]<=dis) {
				if(!visited[tree[v].get(i)[0]]) cnt += node[tree[v].get(i)[0]];
				visited[tree[v].get(i)[0]] = true;
				dfs(tree[v].get(i)[0],dis-tree[v].get(i)[1]);
			}
		}
	}
}
