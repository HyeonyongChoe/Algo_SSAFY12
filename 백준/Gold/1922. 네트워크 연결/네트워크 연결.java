import java.util.ArrayList;
import java.util.Scanner;

class Edge implements Comparable<Edge>{
	int a;
	int b; 
	int w;
	
	public Edge() {}

	public Edge(int a, int b, int w) {
		super();
		this.a = a;
		this.b = b;
		this.w = w;
	}

	@Override
	public int compareTo(Edge o) {
		return this.w - o.w;
	}

	@Override
	public String toString() {
		return "Edge [a=" + a + ", b=" + b + ", w=" + w + "]";
	}
	
	
	
}

public class Main {
	static int N, M, cnt, ans;
	static int[] p;
 	static ArrayList<Edge> tree;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		tree = new ArrayList<>();
		
		for(int i=0 ; i<M ; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int w = sc.nextInt();
			
			tree.add(new Edge(a,b,w));
		}
		
		tree.sort(null);
		
		p = new int[N+1];
		
		for(int i=0 ; i<=N ; i++) {
			p[i] = i;
		}
		
		cnt = 0;
		ans = 0;
				
		for(int i=0 ; i<tree.size() ; i++) {
			Edge E = tree.get(i);
			
			int px = findSet(E.a);
			int py = findSet(E.b);
			
			if(px!=py) {
				cnt++;
				ans += E.w;
				union(px,py);
			}
			
			if(cnt==N-1) break;
		}
		System.out.println(ans);
	}
	
	static int findSet(int x) {
		if(x != p[x]) p[x] = findSet(p[x]);
		return p[x];
	}
	
	static void union(int px, int py) {
		p[px] = p[py];
	}
}
