import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[] dr = {-1,1,2};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		boolean[] visited = new boolean[100001];
		
		Queue<Integer> queue = new LinkedList<>();
		
		visited[N] = true;
		queue.add(N);
		
		int ans = 0;
		
		out :
		while(!queue.isEmpty()) {
			int len = queue.size();
			
			for(int i=0 ; i<len ; i++) {
				int now = queue.poll();
				if(now==K) break out;
				
				dr[2] = now;
				
				for(int d=0 ; d<3 ; d++) {
					int nxt = now + dr[d];
					if(nxt<0 || nxt>100000 || visited[nxt]) continue;
					visited[nxt] = true;
					queue.add(nxt);
					
				}
			}
			
			ans++;
		}
		
		System.out.println(ans);
		
	}
}
