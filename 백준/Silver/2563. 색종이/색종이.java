import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[][] whitePaper = new int[100][100];
		
		int N = sc.nextInt();
		
		int ans = 0;
		for(int i=0 ; i<N ; i++) {
			int left = sc.nextInt();
			int bottom = sc.nextInt();
			
			for(int r=bottom ; r<bottom+10 ; r++) {
				for(int c=left ; c<left+10 ; c++) {
					if(whitePaper[r][c]==0) {
						whitePaper[r][c]=1;
						ans++;
					}
				}
			}
		}
		System.out.println(ans);
		
	}
}
