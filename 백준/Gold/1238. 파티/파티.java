import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		int X = sc.nextInt();
		
		ArrayList<int[]>[] tree = new ArrayList[N+1];
		
		for(int i=0 ; i<=N ; i++) {
			tree[i] = new ArrayList<>();
		}
		
		for(int i=0 ; i<M ; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int w = sc.nextInt();
			
			tree[a] .add(new int[] {b,w});
		}
		
		int[] ans = new int[N+1];
		
		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1] - o2[1];
			}
		});
		
		for(int i=0 ; i<=N ; i++) {
			ans[i] = Integer.MAX_VALUE;
		}
		
		pq.add(new int[] {X,0});
		ans[X] = 0;
		
		while(!pq.isEmpty()) {
			int[] now = pq.poll();
			
			for(int[] nxt: tree[now[0]]) {
				if(now[1]+nxt[1]>ans[nxt[0]]) continue;
				ans[nxt[0]] = now[1]+nxt[1];
				pq.add(new int[] {nxt[0],ans[nxt[0]]});
			}
		}
		
		for(int i=1 ; i<=N ; i++) {
			if(i==X) continue;
			pq.clear();
			int[] dist = new int[N+1];
			
			for(int j=0 ; j<=N ; j++) {
				dist[j] = Integer.MAX_VALUE;
			}
			
			dist[i] = 0;
			pq.add(new int[] {i,0});
			
			while(!pq.isEmpty()) {
				int[] now = pq.poll();
				if(now[0]==X) {
					ans[i] += dist[X];
					break;
				}
				for(int[] nxt: tree[now[0]]) {
					if(now[1]+nxt[1]>dist[nxt[0]]) continue;
					dist[nxt[0]] = now[1]+nxt[1];
					pq.add(new int[] {nxt[0],dist[nxt[0]]});
				}
			}
		}
		int max = 0;
		for(int i=1 ; i<=N ; i++) {
			if(max<ans[i]) max = ans[i];
		}
		System.out.println(max);
	}
}
