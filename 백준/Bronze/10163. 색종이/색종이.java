import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int[][] ground = new int[1001][1001];
		int[] cnt = new int[N+1];
		
		for(int i=1 ; i<=N ; i++) {
			int pc = sc.nextInt();
			int pr = sc.nextInt();
			int bc = sc.nextInt();
			int br = sc.nextInt();
			
			for(int r=pr ; r<pr+br ; r++) {
				for(int c=pc ; c<pc+bc ; c++) {
					ground[r][c] = i;
				}
			}
		}
		for(int i=0 ; i<1001 ; i++) {
			for(int j=0 ; j<1001 ; j++) {
				cnt[ground[i][j]]++;
			}
		}
		for(int i=1 ; i<=N ; i++) {
			System.out.println(cnt[i]);
		}
	}
}
