import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int tc=1 ; tc<=10 ; tc++) {
			int N = sc.nextInt();
			
			String[][] tree = new String[(N/2+1)*2+1][];
			
			
			for(int i=0 ; i<N ; i++) {
				int idx = sc.nextInt();
				tree[idx] = sc.nextLine().split(" ");
			}
			
			int ans = cal(tree,1);
			System.out.println("#"+tc+" "+ans);
		}
		
	}
	
	static int cal(String[][] tree, int root) {
//		if(root>(tree.length%2+1)*2) {
//			return 0;
//		}
		if(tree[root][1].equals("+")) {
			return cal(tree,Integer.parseInt(tree[root][2]))+cal(tree,Integer.parseInt(tree[root][3]));
		}
		if(tree[root][1].equals("-")) {
			return cal(tree,Integer.parseInt(tree[root][2]))-cal(tree,Integer.parseInt(tree[root][3]));
		}
		if(tree[root][1].equals("/")) {
			return cal(tree,Integer.parseInt(tree[root][2]))/cal(tree,Integer.parseInt(tree[root][3]));
		}
		if(tree[root][1].equals("*")) {
			return cal(tree,Integer.parseInt(tree[root][2]))*cal(tree,Integer.parseInt(tree[root][3]));
		}
		return Integer.parseInt(tree[root][1]);
	}
}
