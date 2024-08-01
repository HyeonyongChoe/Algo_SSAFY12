import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int tc=1 ; tc<=10 ; tc++) {
			int tCase = sc.nextInt();
			
			char[][] map = new char[100][];
			
			for(int i=0 ; i<100 ; i++) { // 배열 받기
				map[i] = sc.next().toCharArray();
			}
			
			int max = 1; // 최대길이 초기화 최소 1이므로
			check:
			for(int pl=100 ; pl>=1 ; pl--) { // 길이를 100부터 줄여가면서 검사
				// 정해진 길이로 전체 검사
				for(int i=0 ; i<100 ; i++) {
					for(int j=0 ; j<100 ; j++) {
						if (j<100-pl+1) { // 가로에서 회문 찾기
							int chk = 1;
							for(int idx=0 ; idx<pl/2 ; idx++) {
								if(map[i][j+idx]!=map[i][j+pl-idx-1]) { // 만약 아니면 탈출
									chk = 0;
									break;
								}
							}
							if (chk==1) { // 찾았으면 max 값에 pl 값 저장 후 전체를 탈출
								max=pl;
								break check;
							}
							
						}
						
						if (i<100-pl+1) { // 세로에서 회문 찾기
							int chk = 1;
							for(int idx=0 ; idx<pl/2 ; idx++) {
								if (map[i+idx][j]!=map[i+pl-idx-1][j]) { // 만약 아니면 탈출
									chk = 0;
									break;
								}
							}
							if (chk==1) { // 찾았으면 max 값에 pl 값 저장 후 전체를 탈출
								max=pl;
								break check;
							}
						}
					}
				}
			}
			System.out.println("#"+tCase+" "+max);
		}
	}
}
