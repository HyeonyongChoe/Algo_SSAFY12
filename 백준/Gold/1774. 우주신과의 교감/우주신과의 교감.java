import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Vertex implements Comparable<Vertex> {
	int a;
	int b;
	double w;
	
	public Vertex() {}

	public Vertex(int a, int b, double w) {
		super();
		this.a = a;
		this.b = b;
		this.w = w;
	}

	@Override
	public int compareTo(Vertex o) {
		return Double.compare(this.w, o.w);
	}
	
	
	
}
public class Main {
	static int[] parent;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		int[][] roc = new int[N+1][2];
		
		for(int i=1 ; i<=N ; i++) {
			roc[i][0] = sc.nextInt();
			roc[i][1] = sc.nextInt();			
		}
		
		ArrayList<Vertex> tree = new ArrayList<>();
		
		for(int i=1 ; i<=N ; i++) {
			for(int j=i+1 ; j<=N ; j++) {
				
				double w = Math.sqrt(Math.pow(roc[i][0]-roc[j][0],2) + Math.pow(roc[i][1]-roc[j][1],2));
				Vertex v = new Vertex(i,j,w);
				tree.add(v);
			}
		}
		
		Collections.sort(tree);
		
		parent = new int[N+1];
		
		for(int i=0 ; i<=N ; i++) {
			parent[i] = i;
		}
		
		
		for(int i=0 ; i<M ; i++) {
			int a = sc.nextInt();
			int	b = sc.nextInt();
			int px = findSet(a);
			int py = findSet(b);
			
			if(px!=py) {
				union(px,py);
			}
		}
		
		double ans = 0.0;
		
		
		for(int i=0 ; i<tree.size() ; i++) {
			int px = findSet(tree.get(i).a);
			int py = findSet(tree.get(i).b);
			
			if(px!=py) {
				ans += tree.get(i).w;
				union(px,py);
			}
		}

		
		System.out.printf("%.2f",ans);
	}
	
	static void union(int px, int py) {
		parent[px] = parent[py];
	}
	
	static int findSet(int x) {
		if(parent[x]!=x) parent[x] = findSet(parent[x]);
		return parent[x];
	}
}
