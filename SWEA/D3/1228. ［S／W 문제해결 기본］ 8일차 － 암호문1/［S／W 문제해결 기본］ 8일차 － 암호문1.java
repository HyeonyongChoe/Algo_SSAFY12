import java.util.LinkedList;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = 10;
		
		for(int tc=1 ; tc<=T ; tc++) {
			int N = sc.nextInt();
			
			LinkedList<String> code = new LinkedList<>();
			
			for(int i=0 ; i<N ; i++) {
				code.add(sc.next());
			}
			int K = sc.nextInt();
			
			for(int i=0 ; i<K ; i++) {
				sc.next();
				int idx = sc.nextInt();
				int M = sc.nextInt();
				for(int j=idx ; j<M+idx ; j++) {
					code.add(j, sc.next());
				}
			}
			
			System.out.print("#"+tc+" ");
			for(int i=0 ; i<10 ; i++) {
				System.out.print(code.get(i)+" ");
			}
			System.out.println();
		}
	}
}
