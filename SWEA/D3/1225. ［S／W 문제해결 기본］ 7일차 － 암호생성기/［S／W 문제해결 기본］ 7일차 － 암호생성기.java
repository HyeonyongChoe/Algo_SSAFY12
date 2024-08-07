import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int tc=1 ; tc<=10 ; tc++) {
			int tCase = sc.nextInt();
			Queue<Integer> code = new LinkedList<>();
			
			for(int i=0 ; i<8 ; i++) {
				code.offer(sc.nextInt());
			}
			
			int cnt = 1;
			while(true) {
				int num = code.poll();
				if(num>cnt) {
					num = num-cnt;
					code.offer(num);
					cnt = cnt%5 + 1;
				} else {
					num = 0;
					code.offer(num);
					break;
				}
				
			}
			System.out.print("#"+tCase+" ");
			while(!code.isEmpty()) {
				System.out.print(code.poll()+" ");
			}
			System.out.println();
		}
	}
}
