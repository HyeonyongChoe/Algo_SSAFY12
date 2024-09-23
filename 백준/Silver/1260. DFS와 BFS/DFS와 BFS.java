import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N, M, V;
	static ArrayList<Integer>[] arr;
	static Queue<Integer> queue;
	static boolean[] visited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		V = sc.nextInt();
		
		arr = new ArrayList[N+1];
		for(int i=0 ; i<=N ; i++) {
			arr[i] = new ArrayList<>();
		}
		
		visited = new boolean[N+1];
		
		for(int i=0 ; i<M ; i++) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			arr[start].add(end);
			arr[end].add(start);
		}
		
		for(int i=0 ; i<=N ; i++) {
			arr[i].sort(null);
		}
		
		visited[V] = true;
		dfs(V);
		System.out.println();
		
		queue = new LinkedList<>();
		Arrays.fill(visited, false);
	
		visited[V] = true;
		queue.offer(V);
		
		while(!queue.isEmpty()) {
			int node = queue.poll();
			System.out.print(node+" ");
			
			for(int i=0 ; i<arr[node].size() ; i++) {
				if(visited[arr[node].get(i)]) continue;
				visited[arr[node].get(i)] = true;
				queue.offer(arr[node].get(i));
			}
		}
	}
	
	static void dfs(int node) {
		System.out.print(node+" ");
		for(int i=0 ; i<arr[node].size() ; i++) {
			if(visited[arr[node].get(i)]) continue;
			visited[arr[node].get(i)] = true;
			dfs(arr[node].get(i));
		}
	}
}
