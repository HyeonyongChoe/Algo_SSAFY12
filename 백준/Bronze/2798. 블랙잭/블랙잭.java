import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		int[] cards = new int[N];
		
		for(int i=0 ; i<N ; i++) {
			cards[i] = sc.nextInt();
		}
		Arrays.sort(cards);
		
		int ans = 0;
		
		check :
		for(int i=N-1 ; i>=2 ; i--) {
			for(int j=i-1 ; j>=1 ; j--) {
				for(int k=j-1 ; k>=0 ; k--) {
					int tmp = cards[i] + cards[j] + cards[k];
					if(tmp<=M) {
						if(ans<tmp) {
							ans = tmp;
						}
					}
				}
			}
		}
		System.out.println(ans);
	}
}
