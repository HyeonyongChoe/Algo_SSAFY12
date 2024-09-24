import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	static int V, E, K;
	static int[] dist;
	static ArrayList<int[]>[] tree;
	static PriorityQueue<int[]> pq;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		V = sc.nextInt();
		E = sc.nextInt();
		K = sc.nextInt();
		
		tree = new ArrayList[V+1];
		
		for(int i=0 ; i<=V ; i++) {
			tree[i] = new ArrayList<>();
		}
		
		for(int i=0 ; i<E ; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int w = sc.nextInt();
			
			tree[a].add(new int[] {b,w});
		}
		
		dist = new int[V+1];
		Arrays.fill(dist, 987654321);
		
		pq = new PriorityQueue<>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1] - o2[1];
			}
			
		});
		pq.add(new int[] {K,0});
		dist[K] = 0;
		
		while(!pq.isEmpty()) {
			int[] curNode = pq.poll();
			if(curNode[1]>dist[curNode[0]]) continue;
			
			for(int i=0 ; i<tree[curNode[0]].size() ; i++) {
				int[] nxtNode = tree[curNode[0]].get(i);
				
				if(dist[nxtNode[0]]>curNode[1]+nxtNode[1]) {
					dist[nxtNode[0]] = curNode[1]+nxtNode[1];
					pq.add(new int[] {nxtNode[0],curNode[1]+nxtNode[1]});
				}
				
			}
			
		}
		
		for(int i=1 ; i<=V ; i++) {
			if(dist[i]!=987654321) System.out.println(dist[i]);
			else System.out.println("INF");
		}
		
		
	}
}
