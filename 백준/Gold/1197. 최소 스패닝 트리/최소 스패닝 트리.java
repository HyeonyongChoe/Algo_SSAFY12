import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
	static int[] parent;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int V = sc.nextInt();
		int E = sc.nextInt();
		
		int[][] tree = new int[E][3];
		
		
		for(int i=0 ; i<E ; i++) {
			tree[i][0] = sc.nextInt();
			tree[i][1] = sc.nextInt();
			tree[i][2] = sc.nextInt();
		}
		
		Arrays.sort(tree, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[2]-o2[2];
			}
		});
		
		parent = new int[V+1];
		
		for(int i=0 ; i<=V ; i++) {
			parent[i] = i;
		}
		
		int cnt = 0;
		long ans = 0;
		for(int i=0 ; i<E ; i++) {
			int px = findSet(tree[i][0]);
			int py = findSet(tree[i][1]);
			
			if(px!=py) {
				cnt++;
				ans += tree[i][2];
				union(px,py);
			}
			
			if(cnt==V-1) break;
		}
		
		System.out.println(ans);
	}
	
	static void union(int px, int py) {
		parent[px] = parent[py];
	}
	
	static int findSet(int x) {
		if(parent[x]!=x) parent[x] = findSet(parent[x]);
		return parent[x];
	}
}
