import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int H = sc.nextInt();
		int W = sc.nextInt();
		
		int[][] block = new int[H][W];
		
		for(int i=0 ; i<W ; i++) {
			int tmp = sc.nextInt();
			for(int j=0 ; j<tmp ; j++) {
				block[j][i] = 2;
			}
		}
		
		int ans=0;
		for(int i=0 ; i<H ; i++) {
			for(int j=0 ; j<W ; j++) {
				if(block[i][j]==2) {
					continue;
				} else {
					if(j-1>=0 && block[i][j-1]==2) {
						int tmp = 1;
						int flag = 0;
						for(int k=j+1; k<W ; k++) {
							if(block[i][k]==0) {
								tmp++;
							} else {
								flag = 1;
								j = k;
								break;
							}
						}
						if(flag==1) ans += tmp;
					}
				}
			}
		}
		System.out.println(ans);
	}
}
