import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N, K, M;
	static ArrayList<Integer>[] hyperTube;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		K = sc.nextInt();
		M = sc.nextInt();
		
		hyperTube = new ArrayList[N+M+1];
		
		for(int i=0 ; i<=N ; i++) {
			hyperTube[i] = new ArrayList<>();
		}
		
		for(int i=N+1 ; i<=N+M ; i++) {
			hyperTube[i] = new ArrayList<>();
			for(int j=0 ; j<K ; j++) {
				int node = sc.nextInt();
				hyperTube[i].add(node);
				hyperTube[node].add(i);
			}
		}
		
		Queue<Integer> queue = new LinkedList<>();
		boolean[] visited = new boolean[N+M+1];
		
		queue.add(1);
		visited[1] = true;
		
		int ans = 1;
		boolean flag = false;
		out :
		while(!queue.isEmpty()) {
			int l = queue.size();
			
			for(int i=0 ; i<l ; i++) {
				int now = queue.poll();
				if(now==N) {
					flag = true;
					break out;
				}
				
				for(int j: hyperTube[now]) {
					if(visited[j]) continue;
					visited[j] = true;
					queue.add(j);
				}
			}
			
			int m = queue.size();
			
			for(int j=0 ; j<m ; j++) {
				int nowTube = queue.poll();
				
				for(int k : hyperTube[nowTube]) {
					if(visited[k]) continue;
					visited[k] = true;
					queue.add(k);
				}
			}
			ans++;
		}
		
		if(flag) {
			System.out.println(ans);
		} else {
			System.out.println(-1);
		}
		
	}
}
