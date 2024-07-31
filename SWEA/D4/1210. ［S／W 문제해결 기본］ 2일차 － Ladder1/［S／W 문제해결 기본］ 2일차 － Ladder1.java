import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = 10;
		for (int tc=1; tc<=T ; tc++) {
			int tCase = sc.nextInt();
			
			int[][] ladder = new int[100][100];
			int pos_x = 0, pos_y = 0;
			for (int i=0; i<100 ; i++) {
				for(int j=0; j<100 ; j++) {
					ladder[i][j] = sc.nextInt();
					if(ladder[i][j]==2) {
						pos_y = i;
						pos_x = j;
					} // 시작점 미리 저장해두기 
					// 어차피 도착점은 정해져 있으니 도착점을 시작점으로 해서 거꾸로 가면
					// 한가지 경우만 해봐도 된다
				}
			} // 사다리 배열 받기
			
			while(pos_y>0) { // 현재 y좌표가 0이 되면 도착, 그때까지 반복
				if(pos_x+1<100 && ladder[pos_y][pos_x+1]==1) { // 오른쪽에 1이 있으면 이동할 수 있는 만큼 이동
					while(true) {
						pos_x++;
						if (pos_x==99 || ladder[pos_y][pos_x+1]==0) { // 경계이거나 0을 만나면 위로 한칸 이동하고 탈출
							pos_y--;
							break;
						}
					}
				} else if(pos_x-1>=0 && ladder[pos_y][pos_x-1]==1) { // 왼쪽에 1이 있으면 이동할 수 있는 만큼 이동
					while(true) {
						pos_x--;
						if (pos_x==0 || ladder[pos_y][pos_x-1]==0) { // 경계이거나 0을 만나면 위로 한칸 이동하고 탈출
							pos_y--;
							break;
						}
					}
				} else { // 양쪽으로 이동할 수 없다면 그대로 위로 이동
					pos_y--;
				}
			}
			System.out.println("#"+tCase+" "+pos_x);
		}
	}
}
