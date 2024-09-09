import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
    // 큐로 구현
	static int V, E;
	static int[][] tree;
	static int[] inDegree;
	static Queue<Integer> queue;
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int tc=1; tc<=10 ; tc++) {
			V = sc.nextInt();
			E = sc.nextInt();
			
			queue = new LinkedList<>();
			tree = new int[V+1][V+1];
			inDegree = new int[V+1];
			
			for(int i=0 ; i<E ; i++) {
				int start = sc.nextInt();
				int end = sc.nextInt();
				
				tree[start][end] = 1;
				inDegree[end]++;
			}
			
			for(int i=1 ; i<=V ; i++) {
				if(inDegree[i]==0) queue.add(i);
			}
			
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(tc).append(" ");
			
			while(!queue.isEmpty()) {
				int idx = queue.poll();
				sb.append(idx).append(" ");
				for(int i=1 ; i<=V ; i++) {
					if(tree[idx][i]==1) {
						inDegree[i]--;
						tree[idx][i] = 0;
						if(inDegree[i]==0) queue.add(i);
					}
				}
			}
			System.out.println(sb);
		}
	}
}
