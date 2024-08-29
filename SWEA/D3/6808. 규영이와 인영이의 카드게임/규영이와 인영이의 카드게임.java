import java.util.Scanner;

public class Solution {
	static int[] gcard, icard, visited;
	static int win, lose;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc=1 ; tc<=T ; tc++) {
			gcard = new int[9];
			icard = new int[9];
			visited = new int[19];
			
			for(int i=0 ; i<9 ; i++) {
				gcard[i] = sc.nextInt();
				visited[gcard[i]] = 1;
			}
			win = 0;
			lose = 0;
			permu(0);
			
			System.out.println("#"+tc+" "+win+" "+lose);
		}
	}
	
	static void permu(int idx) {
		if(idx>=9) {
			int gscore=0;
			int iscore=0;
			for(int i=0 ; i<9 ; i++) {
				if(gcard[i]>icard[i]) {
					gscore += gcard[i]+icard[i];
				} else {
					iscore += gcard[i]+icard[i];
				}
			}
			if(gscore>iscore) win++;
			if(gscore<iscore) lose++;
			return;
		}
		
		for(int i=1 ; i<19 ; i++) {
			if(visited[i]!=0) continue;
			
			icard[idx] = i;
			visited[i]++;
			permu(idx+1);
			visited[i]--;
		}
	}
}
