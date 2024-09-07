import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
	static int N, M, ans;
	static boolean[] visited;
	static ArrayList<Integer>[] tree;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc=1 ; tc<=T ; tc++) {
			N = sc.nextInt();
			M = sc.nextInt();
			
			tree = new ArrayList[N+1];
			visited = new boolean[N+1];
			
			for(int i=0 ; i<N+1 ; i++) {
				tree[i] = new ArrayList<>();
			}
			
			for(int i=0 ; i<M ; i++) {
				int start = sc.nextInt();
				int end = sc.nextInt();
				
				tree[start].add(end);
				tree[end].add(start);
			}
			ans = 0;
			for(int i=1 ; i<=N ; i++) {
				if(!visited[i]) {
					visited[i] = true;
					dfs(i);
					ans++;
				}
			}
			
			System.out.println("#"+tc+" "+ans);
		}
	}
	
	static void dfs(int idx) {
		
		for(int i=0 ; i<tree[idx].size() ; i++) {
			int x = tree[idx].get(i);
			if(!visited[x]) {
				visited[x] = true;
				dfs(x);
			}
		}
	}
}
