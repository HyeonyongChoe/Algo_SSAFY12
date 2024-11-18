import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> x[1] - y[1]);
		pq.offer(new int[]{N, 0});
		boolean[] visited = new boolean[100001];
		int count = 0;
		while (!pq.isEmpty()) {
			int[] now = pq.poll();
			
			int nPosition = now[0];
			count = now[1];
			if (nPosition == K) {
				break;
			}
			visited[nPosition] = true;
			if (nPosition * 2 <= 100000 && !visited[nPosition * 2]) {
				pq.offer(new int[] {nPosition * 2, count});
			}
			if (nPosition < K && nPosition + 1 <= 100000 && !visited[nPosition + 1]) {
				pq.offer(new int[] {nPosition + 1, count + 1});
			}
			if (nPosition - 1 >= 0  && !visited[nPosition - 1]) {
				pq.offer(new int[] {nPosition - 1, count + 1});
			}
		}
		System.out.println(count);
	}
}
