import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int H = sc.nextInt();
		int W = sc.nextInt();
		
		int[][] city = new int[H][W];
		char[][] sky = new char[H][W];
		
		for(int i=0 ; i<H ; i++) {
			sky[i] = sc.next().toCharArray();
			for(int j=0; j<W ; j++) {
				if(sky[i][j]=='c') city[i][j]=0;
				else city[i][j] = -1;
			}
		}
		
		for(int i=0 ; i<H ; i++) {
			for(int j=0 ; j<W ; j++) {
				if(sky[i][j]=='c') {
					int cnt = 1;
					for(int c=j+1 ; c<W ; c++) {
						if(city[i][c]==0) break;
						else {
							city[i][c] = cnt++; 
						}
					}
				}
			}
		}
		
		for(int i=0 ; i<H ; i++) {
			for(int j=0 ; j<W ; j++) {
				System.out.print(city[i][j]+" ");
			}
			System.out.println();
		}
	}
}
