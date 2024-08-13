import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int[] S = new int[N];
		for(int i=0 ; i<N ; i++) {
			S[i] = sc.nextInt();
		}
		
		int M = sc.nextInt();
		
		for(int i=0 ; i<M ; i++) {
			int gen = sc.nextInt();
			int num = sc.nextInt();
			
			if(gen==1) {
				for(int j=num; j<=N ; j += num) {
					S[j-1] = (S[j-1]+1)%2;
				}
			} else {
				S[num-1] = (S[num-1]+1)%2;
				for(int j=1 ; j<N ; j++) {
					if(num-1-j>=0 && num-1+j<N && S[num-1-j]==S[num-1+j]) {
						S[num-1-j] = (S[num-1-j]+1)%2;
						S[num-1+j] = (S[num-1+j]+1)%2;
					} else if(num-1-j>=0 && num-1+j<N && S[num-1-j]!=S[num-1+j]) {
						break;
					}
				}
			}
		}
		for(int i=0 ; i<N ;i++) {
			System.out.print(S[i]+" ");
			if((i+1)%20==0) {
				System.out.println();
			}
		}
	}
}
