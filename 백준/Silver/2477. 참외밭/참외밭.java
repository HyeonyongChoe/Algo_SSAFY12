import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int K = sc.nextInt();
		
		Queue<int[]> queue = new LinkedList<>();
		
		int maxh = 0;
		int maxw = 0;
		for(int i=0 ; i<6 ; i++) {
			int[] tmp = new int[2];
			
			tmp[0] = sc.nextInt();
			tmp[1] = sc.nextInt();
			
			if((tmp[0]==1 || tmp[0]==2) && maxw<tmp[1]) maxw=tmp[1];
			if((tmp[0]==3 || tmp[0]==4) && maxh<tmp[1]) maxh=tmp[1];
			queue.add(tmp);
		}
		int flag = 0;
		find :
		while(flag<2) {
			if((queue.peek()[1]==maxh || queue.peek()[1]==maxw) ) {
				if(flag<1) {
				flag++;
				queue.add(queue.poll());
				} else {
					for(int i=0 ; i<5 ; i++) {
						queue.add(queue.poll());
					}
					break find;
				}
			} else {
				flag=0;
				queue.add(queue.poll());
			}
		}
		
		int ans = queue.poll()[1]*queue.poll()[1];
		queue.poll();
		ans -= queue.poll()[1]*queue.poll()[1];
		
		System.out.println(K*ans);
	}
}
