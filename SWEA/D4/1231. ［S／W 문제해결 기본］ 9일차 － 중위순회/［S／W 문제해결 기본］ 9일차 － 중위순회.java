import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int tc=1 ;tc<=10 ; tc++) {
			int N = sc.nextInt();
			String[][] tree = new String[N+1][];
			for(int i=0 ; i<N ; i++) {
				int idx = sc.nextInt();
				tree[idx] = sc.nextLine().split(" ");
			}
			System.out.print("#"+tc+" ");
			inorder(tree,1);
			System.out.println();
		}
	}
	
	static void inorder(String[][] tree, int root) {
		if(root>=tree.length) {
			return;
		}
		if(tree[root].length==2) {
			System.out.print(tree[root][1]);
			return;
		}
		inorder(tree,2*root);
		System.out.print(tree[root][1]);
		inorder(tree,2*root+1);
	}
}

