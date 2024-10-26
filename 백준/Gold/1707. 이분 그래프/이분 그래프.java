import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int K = sc.nextInt();
		
		for(int tc=0 ; tc<K ; tc++) {
			int V = sc.nextInt();
			int E = sc.nextInt();
			
			ArrayList<Integer>[] arr = new ArrayList[V+1];
			
			for(int i=1 ; i<=V ; i++) {
				arr[i] = new ArrayList<>();
			}
			
			for(int i=0 ; i<E ; i++) {
				int u = sc.nextInt();
				int v = sc.nextInt();
				
				arr[u].add(v);
				arr[v].add(u);
			}
			
			
			int[] visited = new int[V+1];
			Queue<Integer> queue = new LinkedList<>();
			
			
			String ans = "YES";
			
			out :
			for(int j=1 ; j<=V ; j++) {
				if(visited[j]!=0) continue;
				visited[j] = 1;
				queue.add(j);
				
					while(!queue.isEmpty()) {
						int start = queue.poll();
						for(int end : arr[start]) {
							if(visited[start]==visited[end]) {
								ans = "NO";
								break out;
							} else {
								if(visited[end]!=0) continue;
								visited[end] = visited[start]*-1;
								queue.add(end);
							}
						}
						
						
					}
				
			}
			
			System.out.println(ans);
		}
	}
}
