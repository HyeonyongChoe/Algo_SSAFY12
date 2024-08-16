import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int C = sc.nextInt();
		int R = sc.nextInt();
		int K = sc.nextInt();
		
		int[] dr = {1,0,-1,0};
		int[] dc = {0,1,0,-1};
		
		int d=0;
		int[][] snail = new int[R][C];
		
		int cnt = 1;
		int r = 0;
		int c = 0;
		snail[r][c] = cnt;
		if(R*C>=K) {
			
			while(cnt<=K) {
				if(cnt==K) {
					break;
				}
				if(r+dr[d]>=0 && r+dr[d]<R && c+dc[d]>=0 && c+dc[d]<C && snail[r+dr[d]][c+dc[d]]==0) {
					cnt++;
					r += dr[d];
					c += dc[d];
					snail[r][c] = cnt;
				} else {
					d=(d+1)%4;
				}
			}
			r = r+1;
			c = c+1;
			System.out.println(c+" "+r);
		} else {
			System.out.println("0");
		}
	}
}
