import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc=1 ; tc<=T ; tc++) {
			int[][] sudoku = new int[9][9];
			
			int flag = 1;
			for(int i=0 ; i<9 ; i++) {
				int sum = 0;
				for(int j=0 ; j<9 ; j++) {
					sudoku[i][j] = sc.nextInt();
					sum += sudoku[i][j];
				}
				if(sum != 45) {
					flag = 0;
				}
			}
			if(flag == 0) {
				System.out.println("#"+tc+" "+flag);
				continue;
			}
			
			for(int j=0 ; j<9 ; j++) {
				int sum = 0;
				for(int i=0 ; i<9 ; i++) {
					sum += sudoku[i][j];
				}
				if(sum != 45) {
					flag = 0;
					break;
				}
			}
			if(flag == 0) {
				System.out.println("#"+tc+" "+flag);
				continue;
			}
			
			for(int k=0 ; k<9 ; k++) {
				int sum = 0;
				for(int i=0 ; i<3 ; i++) {
					for(int j=0 ; j<3 ; j++) {
						sum += sudoku[3*(k/3)+i][3*(k%3)+j];
					}
				}
				if(sum != 45) {
					flag = 0;
					break;
				}
			}
			System.out.println("#"+tc+" "+flag);
		}
	}
}
