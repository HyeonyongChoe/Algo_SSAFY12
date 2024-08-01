import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int tc=1 ; tc<=10 ; tc++) {
			int pl = sc.nextInt();
			char[][] map = new char[8][];
			
			for(int i=0 ; i<8 ; i++) {
				map[i] = sc.next().toCharArray();
			}
			
			int cnt = 0;
			
			for(int i=0 ; i<8 ; i++) {
				for(int j=0 ; j<8 ; j++) {
					
					if(j<8-pl+1) {
						int chk = 1;
						for(int idx=0 ; idx<pl/2 ; idx++) {
							if (map[i][j+idx]!=map[i][j+pl-idx-1]) {
								chk = 0;
								break;
							}
						}
						cnt +=chk;
					} 

					if(i<8-pl+1) {
						int chk = 1;
						for(int idx=0 ; idx<pl/2 ; idx++) {
							if (map[i+idx][j]!=map[i+pl-idx-1][j]) {
								chk = 0;
								break;
							}
						}
						cnt += chk;
					}
				}
				
			}
			System.out.println("#"+tc+" "+cnt);
		}
	}
}
