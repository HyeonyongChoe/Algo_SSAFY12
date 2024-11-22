import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		int[] tree = new int[N];
		
		int left = 0;
		int right = 0;
		
		for(int i=0 ; i<N ; i++) {
			tree[i] = sc.nextInt();
			if(right<tree[i]) right = tree[i];
		}
		
		while(left<right) {
			int mid = (left+right+1)/2;
			
			long tmp = 0;
			for(int i=0 ; i<N ; i++) {
				if(tree[i]>mid) {
					tmp += tree[i]-mid;
				}
			}
			if(tmp<M) {
				right = mid-1;
			} else {
				left = mid;
			}
		}
		
		System.out.println(left);
	}
}
