import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc=1 ; tc<=T ; tc++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int K = sc.nextInt();
			
			int targetA = sc.nextInt();
			int targetB = sc.nextInt();
			
			int[] aTime = new int[N+1];
			int[] bTime = new int[M+1];
			int[] kTime = new int[K+1];
			
			for(int i=1 ; i<=N ; i++) {
				aTime[i] = sc.nextInt();
			}
			
			for(int j=1 ; j<=M ; j++) {
				bTime[j] = sc.nextInt();
			}
			
			for(int k=1 ; k<=K ; k++) {
				kTime[k] = sc.nextInt();
			}
			
			Queue<Integer> aQueue = new LinkedList<>();
			Queue<Integer> bQueue = new LinkedList<>();
			
			int[][] kInfo = new int[K+1][2];
			int[][] aVisited = new int[N+1][2];
			int[][] bVisited = new int[M+1][2];
			
			int t=0;
			int aidx=1;
			int bidx=1;
			
			while(true) {
				if(aidx<=K && kTime[aidx]==t) {
					while(aidx<=K && kTime[aidx]==t) {
						aQueue.offer(aidx);
						aidx++;
					}
				}
				
				for(int i=1 ; i<=N ; i++) {
					if(aVisited[i][0]!=0 && aVisited[i][1]==0) {
						bQueue.offer(aVisited[i][0]);
						bidx++;
						aVisited[i][0] = 0;
					}
				}
				
				for(int i=1 ; i<=N ; i++) {
					if(aQueue.isEmpty()) break;
					if(aVisited[i][0] == 0) {
						aVisited[i][0] = aQueue.poll();
						aVisited[i][1] = aTime[i];
						kInfo[aVisited[i][0]][0] = i;
					}
				}
				
				for(int i=1 ; i<=M ; i++) {
					if(bQueue.isEmpty()) break;
					if(bVisited[i][0] == 0) {
						bVisited[i][0] = bQueue.poll();
						bVisited[i][1] = bTime[i];
						kInfo[bVisited[i][0]][1] = i;
					}
				}
				
				for(int i=1 ; i<=N ; i++) {
					if(aVisited[i][0]!=0) {
						aVisited[i][1]--;
					}
				}
				
				for(int i=1 ; i<=M ; i++) {
					if(bVisited[i][0]!=0) {
						bVisited[i][1]--;
					}
					if(bVisited[i][1]==0 && bVisited[i][0]!=0) {
						bVisited[i][0] = 0;
					}
				}
				
				t++;
				if(aidx>K && bidx>K && aQueue.isEmpty() && bQueue.isEmpty()) break;
			}
			
			int ans = 0;
			for(int i=1 ; i<=K ; i++) {
				if(kInfo[i][0]==targetA && kInfo[i][1]==targetB) {
					ans += i;
				}
			}
			
			if(ans==0) ans = -1;
			System.out.println("#"+tc+" "+ans);
		}
	}
}
