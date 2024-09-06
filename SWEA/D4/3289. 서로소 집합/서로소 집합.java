import java.util.Scanner;

public class Solution {
	static int[] parent, rank;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		int T = sc.nextInt();
		
		for(int tc=1 ; tc<=T ; tc++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			
			parent = new int[n+1];
			rank = new int[n+1];
			
			for(int i=1 ; i<=n ; i++) {
				makeSet(i);
			}
			
			String ans = "";
			for(int i=0 ; i<m ; i++) {
				int cal = sc.nextInt();
				int a = sc.nextInt();
				int b = sc.nextInt();
				
				if(cal==0) {
					union(findSet(a),findSet(b));
				} else {
					if(findSet(a)==findSet(b)) {
						ans += "1";
					} else {
						ans += "0";
					}
				}
			}
			System.out.println("#"+tc+" "+ans);
		}
	}
	
	static void makeSet(int x) {
		parent[x] = x;
		rank[x] = 0;
	}
	
	static int findSet(int x) {
		if(x!=parent[x]) {
			parent[x] = findSet(parent[x]);
		}
		return parent[x];
	}
	
	static void union(int x, int y) {
		if(rank[x]>rank[y]) {
			parent[y] = x;
		} else {
			
			parent[x] = y;
			if(rank[x]==rank[y]) {
				rank[y]++;
			}
		}
	}
}
