import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc=1 ; tc<=T ; tc++) {
			int N = sc.nextInt();
			PriorityQueue<Integer> tree = new PriorityQueue<>(Collections.reverseOrder());
			
			System.out.print("#"+tc+" ");
			for(int i=0 ; i<N ; i++) {
				int act = sc.nextInt();
				if(act==1) {
					tree.add(sc.nextInt());
				} else {
					if(tree.isEmpty()) {
						System.out.print("-1 ");
					} else {
						int ans = tree.poll();
						System.out.print(ans+" ");
					}
				}
			}
			System.out.println();
		}
	}
}
