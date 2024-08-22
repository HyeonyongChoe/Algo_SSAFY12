import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int[][] paper = new int[100][100];
		
		for(int i=0 ; i<N ; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			
			for(int r=0 ; r<10 ; r++) {
				for(int c=0 ; c<10 ; c++) {
					paper[y+r][x+c] = 1;
				}
			}	
		}
		
		int[] dr = {-1,0,1,0};
		int[] dc = {0,1,0,-1};
		
		int ans = 0;
		for(int r=0 ; r<100 ; r++) {
			for(int c=0 ; c<100 ; c++) {
				if(paper[r][c]==1) {
					int tmp=0;
					for(int d=0 ; d<4 ; d++) {
						if(r+dr[d]<0 || r+dr[d]>=100 || c+dc[d]<0 || c+dc[d]>=100) {
							tmp++;
						} else if (paper[r+dr[d]][c+dc[d]]==0) {
							tmp++;
						}
					}
					ans += tmp;
				}
			}
		}
		System.out.println(ans);
	}
}
