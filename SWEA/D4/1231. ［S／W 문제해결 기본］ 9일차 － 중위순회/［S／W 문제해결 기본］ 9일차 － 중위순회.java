import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
	static ArrayList<Integer>[] tree;
	static String[] alp;
	static boolean[] visited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int tc=1 ; tc<=10 ; tc++) {
			int N = sc.nextInt();
			alp = new String[N+1];
			tree = new ArrayList[N+1];
			visited = new boolean[N+1];
			
			for(int i=1 ; i<=N ; i++) {
				tree[i] = new ArrayList<>();
			}
			
			sc.nextLine();
			for(int i=0 ; i<N ; i++) {
				String[] now = sc.nextLine().split(" ");
				int idx = Integer.parseInt(now[0]);
				alp[idx] = now[1];
				for(int j=2 ; j<now.length ; j++) {
					tree[idx].add(Integer.parseInt(now[j]));
				}
			}
			System.out.print("#"+tc+" ");
			dfs(1);
			System.out.println();
		}
	}
	
	static void dfs(int node) {
		int s = tree[node].size();
		int idx = 0;
		if(s==0) {
			System.out.print(alp[node]);			
		} else {
			for(int nxt : tree[node]) {
				if(!visited[nxt]) {
					visited[nxt] = true;
					idx++;
					dfs(nxt);
					if(idx==1) System.out.print(alp[node]);
				}
			}			
		}
	}
}
