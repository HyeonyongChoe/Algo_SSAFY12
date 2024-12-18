import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
	static ArrayList<Integer>[] tree, dist;
	static boolean[] visited;
	static int[] parent;
	static int V, E, start, end, treeSize;
	static boolean flag;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc=1 ; tc<=T ; tc++) {
			V = sc.nextInt();
			E = sc.nextInt();
			start = sc.nextInt();
			end = sc.nextInt();
			
			dist = new ArrayList[V+1];
			tree = new ArrayList[V+1];
			visited = new boolean[V+1];
			parent = new int[V+1];
			
			for(int i=0 ; i<=V ; i++) {
				tree[i] = new ArrayList<>();
				dist[i] = new ArrayList<>();
			}
			
			for(int i=0 ; i<E ; i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				tree[a].add(b);
				tree[b].add(a);
				parent[b] = a;
			}
			
			flag = false;
			visited[start] = true;
			ArrayList<Integer> list = new ArrayList<>();
			findPath(start, list);
			
			int ans = start;
			for(int node : dist[end]) {
				if(node==start) continue;
				if(parent[ans]==node) ans = node;
				else break;
			}
			
			treeSize = 0;
			visited = new boolean[V+1];
			visited[ans] = true;
			
			findSize(ans);
			
			System.out.println("#"+tc+" "+ans+" "+treeSize);
		}
	}
	
	static void findPath(int node, ArrayList list) {
		list.add(node);
		if(node==end) flag = true;
		dist[node] = (ArrayList<Integer>) list.clone();
		if(flag) return;
		for(int nxt : tree[node]) {
			if(visited[nxt]) continue;
			visited[nxt] = true;
			ArrayList<Integer> nxtList = (ArrayList<Integer>) list.clone();
			findPath(nxt, nxtList);
		}
	}
	
	static void findSize(int node) {
		treeSize++;
		for(int nxt : tree[node]) {
			if(visited[nxt] || parent[node]==nxt) continue;
			visited[nxt] = true;
			findSize(nxt);
		}
	}
}
