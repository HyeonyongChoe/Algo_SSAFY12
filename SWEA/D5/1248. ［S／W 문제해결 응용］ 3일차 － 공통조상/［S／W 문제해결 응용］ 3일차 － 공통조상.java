import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc=1 ; tc<=T ; tc++) {
			int V = sc.nextInt();
			int E = sc.nextInt();
			int p1 = sc.nextInt();
			int p2 = sc.nextInt();
			
			int[][] tree = new int[V+1][2];
			for(int i=0 ; i<E ; i++) {
				int parent = sc.nextInt();
				int child = sc.nextInt();
				if(tree[parent][0]!=0) {
					tree[parent][1] = child;
				} else {
					tree[parent][0] = child;
				}
			}
			
			
			int child = p1;
			int cA=-1;
			find :
			while(true) {
				notFound :
				for(int i=1 ; i<V+1 ; i++) {
					for(int j=0 ; j<2 ; j++) {
						if(tree[i][j]==child) {
							int parent = i;
							if(commonAncestor(tree, parent,p2)==1) {
								cA = parent;
								break find;
							} else {
								child = i;
								break notFound;
							}
						
					}
						
					}
				}
			}
			int ans = treeLevel(tree, cA);
			System.out.println("#"+tc+" "+cA+" "+ans);
		}
	}
	
	static int commonAncestor(int[][] tree, int num, int target) {
		
		if(num==target) {
			return 1;
		}
		if(num==tree.length) {
			return 0;
		}
		int a = 0;
		for(int j=0 ; j<2 ; j++) {
			if(tree[num][j]!=0) 
				a += commonAncestor(tree, tree[num][j], target);
		}
		return a;
	}
	
	static int treeLevel(int[][] tree, int root) {
		int a = 1;
		for(int i=0; i<2 ; i++) {
			if(tree[root][i]!=0) {
				a+=treeLevel(tree, tree[root][i]);
			}
		}
		return a;
	}
}
