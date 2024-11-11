import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		for(int i=0 ; i<N ; i++) {
			pq.add(sc.nextInt());
		}
		
		int ans = 0;
		int tmp = 0;
		while(!pq.isEmpty()) {
			int a = pq.poll();
			tmp += a;
			ans += tmp;
		}
		
		System.out.println(ans);
		
	}
}
