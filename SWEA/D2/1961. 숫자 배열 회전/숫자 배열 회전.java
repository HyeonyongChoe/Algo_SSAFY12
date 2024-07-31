import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc=1 ; tc<=T ; tc++) {
			int N = sc.nextInt();
			
			int[][] mat = new int[N][N];
			
			for(int i=0 ; i<N ; i++) {
				for(int j=0 ; j<N ; j++) {
					mat[i][j] = sc.nextInt();
				}
			}
			int[][] mat90 = Rot90(mat);
			int[][] mat180 = Rot90(mat90);
			int[][] mat270 = Rot90(mat180);
			
			System.out.println("#"+tc);
			for(int i=0 ; i<N ; i++) {
				for(int j=0 ; j<N ; j++) {
					System.out.print(mat90[i][j]);
				}
				System.out.print(" ");
				for(int j=0 ; j<N ; j++) {
					System.out.print(mat180[i][j]);
				}
				System.out.print(" ");
				for(int j=0 ; j<N ; j++) {
					System.out.print(mat270[i][j]);
				}
				System.out.println();
			}
		}
	}
	
	public static int[][] Rot90(int[][] arr) {
		int[][] result = new int[arr.length][arr.length];
		for(int i=0 ; i<arr.length ; i++) {
			for(int j=0 ; j<arr.length ; j++) {
				result[j][arr.length-i-1] = arr[i][j];
			}
		}
		return result;
	}
}
