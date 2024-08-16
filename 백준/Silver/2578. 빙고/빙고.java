import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[][] bingo = new int[26][2];
		
		for(int i=0 ; i<5 ; i++) {
			for(int j=0 ; j<5 ; j++) {
				int num = sc.nextInt();
				bingo[num][0] = i;
				bingo[num][1] = j;
			}
		}
		int[] bingoChk = new int[12]; 
		int ans = 0;
		int cnt = 0;
		for(int t=0 ; t<25 ; t++) {
			cnt++;
			int num = sc.nextInt();
			bingoChk[bingo[num][0]]++;
			bingoChk[5+bingo[num][1]]++;
			if(bingo[num][0]==bingo[num][1]) {
				bingoChk[10]++;
			}
			if(bingo[num][0]+bingo[num][1]==4) {
				bingoChk[11]++;
			}
			
			int chk = 0;
			for(int i=0 ; i<12 ; i++) {
				if(bingoChk[i]==5) {
					chk++;
				}
			}
			if(chk>=3) {
				System.out.println(cnt);
				break;
			}
		}
 	}
}
