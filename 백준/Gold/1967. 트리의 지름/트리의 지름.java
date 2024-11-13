import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int n;
	static ArrayList<int[]>[] tree;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		
		tree = new ArrayList[n+1];
		
		for(int i=0 ; i<=n ; i++) {
			tree[i] = new ArrayList<>();
		}
		
		for(int i=1 ; i<n ; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int w = sc.nextInt();
			
			tree[a].add(new int[] {b,w});
			tree[b].add(new int[] {a,w});
		}
		
		boolean[] visited = new boolean[n+1];
		Queue<int[]> queue = new LinkedList<>();
		
		queue.add(new int[] {1,0});
		visited[1] = true;
		
		int[] max = {0,0};
		
		while(!queue.isEmpty()) {
			int[] now = queue.poll();
			if(max[1]<now[1]) {
				max[0] = now[0];
				max[1] = now[1];
			}
			int len = tree[now[0]].size();
			for(int i=0 ; i<len ; i++) {
				int[] nxt = tree[now[0]].get(i);
				if(visited[nxt[0]]) continue;
				visited[nxt[0]] = true;
				
				queue.add(new int[] {nxt[0],now[1]+nxt[1]});
				
			}
		}
		
		visited = new boolean[n+1];
		queue.add(new int[] {max[0],0});
		visited[max[0]] = true;
		
		max[0] = 0;
		max[1] = 0;
		while(!queue.isEmpty()) {
			int[] now = queue.poll();
			if(max[1]<now[1]) {
				max[0] = now[0];
				max[1] = now[1];
			}
			int len = tree[now[0]].size();
			for(int i=0 ; i<len ; i++) {
				int[] nxt = tree[now[0]].get(i);
				if(visited[nxt[0]]) continue;
				visited[nxt[0]] = true;
				
				queue.add(new int[] {nxt[0],now[1]+nxt[1]});
				
			}
		}
		
		System.out.println(max[1]);
	}
}
