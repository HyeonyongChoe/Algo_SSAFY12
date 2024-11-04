import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	static int N, R, Q;
	static int[] size, parent;
	static ArrayList<Integer>[] edge, tree;
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		
		edge = new ArrayList[N+1];
		tree = new ArrayList[N+1];
		size = new int[N+1];
		parent = new int[N+1];
		
		for(int i=1 ; i<=N ; i++) {
			edge[i] = new ArrayList<>();
			tree[i] = new ArrayList<>();
		}
		
		for(int i=1 ; i<N ; i++) {
			st = new StringTokenizer(br.readLine());
			int U = Integer.parseInt(st.nextToken());
			int V = Integer.parseInt(st.nextToken());
			
			edge[U].add(V);
			edge[V].add(U);
		}
		makeTree(R,-1);
		cntSubTree(R);
		for(int i=0 ; i<Q ; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			sb.append(size[u]).append("\n");
		}
		System.out.println(sb);
	}
	
	static void makeTree(int curNode, int p) {
		for(int node : edge[curNode]) {
			if(node!=p) {
				tree[curNode].add(node);
				parent[node] = curNode;
				makeTree(node, curNode);
			}
		}
	}
	
	static void cntSubTree(int curNode) {
		size[curNode] = 1;
		for(int node : tree[curNode]) {
			cntSubTree(node);
			size[curNode] += size[node];
		}
	}
}
