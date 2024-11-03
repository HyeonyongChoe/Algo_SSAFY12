import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	static int N, ans, target;
	static ArrayList<Integer>[] tree;
	static boolean[] visited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		
		tree = new ArrayList[N];
		visited = new boolean[N];
		
		for(int i=0 ; i<N ; i++) {
			tree[i]  = new ArrayList<>();
		}
		
		int root = -1;
		
		for(int i=0 ; i<N ; i++) {
			int p = sc.nextInt();
			
			if(p==-1) {
				root = i;
			} else {
				tree[p].add(i);
			}
			
		}
		
		target = sc.nextInt();
		
		if(target==root) {
			System.out.println(0);
		} else {
			
			dfs(root);
			System.out.println(ans);
		}
		
	}
	
	static void dfs(int node) {
		int l = tree[node].size();
		
		int cnt = 0;
		for(int i=0 ; i<l ; i++) {
			int nxt = tree[node].get(i);
			if(visited[nxt] || nxt==target) continue;
			visited[nxt] = true;
			cnt++;
			dfs(nxt);
		}
		if(cnt==0) ans++;
	}
}
