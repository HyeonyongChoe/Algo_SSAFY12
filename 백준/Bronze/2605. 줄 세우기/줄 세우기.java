import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int[] rank = new int[N];
		
		for(int i=0 ; i<N ; i++) {
			rank[i] = i+1;
			int num = sc.nextInt();
			for(int j=i ; j>i-num ; j--) {
				int tmp = rank[j];
				rank[j] = rank[j-1];
				rank[j-1] = tmp;
			}
		}
		for(int i=0 ; i<N ; i++) {
			System.out.print(rank[i]+" ");
		}
		
	}
}
