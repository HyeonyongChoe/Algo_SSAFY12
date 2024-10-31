import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	static int N;
	static int[] parent;
	static int[][] planet;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		
		planet = new int[N][4];
		parent = new int[N];
		
		for(int i=0 ; i<N ; i++) {
			planet[i][0] = i;
			planet[i][1] = sc.nextInt();
			planet[i][2] = sc.nextInt();
			planet[i][3] = sc.nextInt();
		}
		
		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[2]-o2[2];
			}
		});
		
		Arrays.sort(planet, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1] - o2[1];
			}
		});
		
		int[] start = planet[0];
		for(int i=1 ; i<N ; i++) {
			int[] end = planet[i];
			pq.add(new int[] {start[0], end[0], Math.abs(start[1]-end[1])});
			start = end;
		}
		
		Arrays.sort(planet, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[2] - o2[2];
			}
		});
		
		start = planet[0];
		for(int i=1 ; i<N ; i++) {
			int[] end = planet[i];
			pq.add(new int[] {start[0], end[0], Math.abs(start[2]-end[2])});
			start = end;
		}
		
		Arrays.sort(planet, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[3] - o2[3];
			}
		});
		
		start = planet[0];
		for(int i=1 ; i<N ; i++) {
			int[] end = planet[i];
			pq.add(new int[] {start[0], end[0], Math.abs(start[3]-end[3])});
			start = end;
		}
		
		for(int i=0 ; i<N ; i++) {
			parent[i] = i;
		}
		
		int cnt = 0;
		long ans = 0;
		
		while(!pq.isEmpty()) {
			int[] edge = pq.poll();
			
			int px = findSet(edge[0]);
			int py = findSet(edge[1]);
			
			if(px!=py) {
				cnt++;
				ans += edge[2];
				union(px,py);
			}
			
			if(cnt==N-1) break;
		}
		
		System.out.println(ans);
	}
	
	static int findSet(int a) {
		if(parent[a]!=a) parent[a] = findSet(parent[a]);
		return parent[a];
	}
	
	static void union(int px, int py) {
		parent[px] = parent[py];
	}
}
