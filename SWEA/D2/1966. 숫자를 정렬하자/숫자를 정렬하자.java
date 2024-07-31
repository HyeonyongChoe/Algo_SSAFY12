import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc=1 ; tc<=T ; tc++) {
			int N = sc.nextInt();
			
			int[] arr = new int[N];
			
			for(int i=0 ; i<N ; i++) {
				arr[i] = sc.nextInt();
			}
			
			for(int i=0 ; i<N ; i++) {
				for(int j=i+1; j<N ; j++) {
					if (arr[i]>arr[j]) {
						int tmp = arr[j];
						arr[j] = arr[i];
						arr[i] = tmp;
					}
				}
			}
			
			System.out.print("#"+tc+" ");
			for(int i=0 ; i<N ; i++) {
				System.out.print(arr[i]+" ");
			}
			System.out.println();
		}
	}
}
