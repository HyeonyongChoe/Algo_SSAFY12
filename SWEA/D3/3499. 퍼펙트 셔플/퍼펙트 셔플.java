import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc=1 ; tc<=T ; tc++) {
			int N = sc.nextInt();
			
			String[] card = new String[N];
			
			for(int i=0; i<N ; i++) {
			
				if(i<N/2+N%2) {
					card[2*i] = sc.next();
				} else {
					card[2*(i-N/2-N%2)+1] = sc.next();
				}
			}
			System.out.print("#"+tc+" ");
			for(int i=0 ; i<N ; i++) {
				System.out.print(card[i]+" ");
			}
			System.out.println();
		}
	}
}
