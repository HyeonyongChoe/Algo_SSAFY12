import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] score = new int[N];
		double max = 0;
		
		for(int i=0 ; i<N ; i++) {
			score[i] = sc.nextInt();
			if(max<score[i]) max = score[i];
		}
		
		double ans = 0;
		for(int i=0 ; i<N ; i++) {
			double tmp = (score[i]/max) *100; 
			ans += tmp;
		}
		System.out.println(ans/N);
	}
}
