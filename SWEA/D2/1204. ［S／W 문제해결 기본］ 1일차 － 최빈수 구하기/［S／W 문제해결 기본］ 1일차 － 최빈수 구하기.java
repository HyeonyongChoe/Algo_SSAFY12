import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc=1 ; tc<=T ; tc++) {
			int tCase = sc.nextInt(); // 필요없는 줄이지만 입력에 포함되어 있어 안정화를 위해 추가
			int n = 1000;
			int[] score = new int[101];
			
			for(int i=0 ; i<n ; i++) {
				int tmp = sc.nextInt();
				
				score[tmp]++;
			}
			int[] scoreSort = Arrays.copyOfRange(score, 0, 101);
			Arrays.sort(scoreSort);
			int ans = 0;
			for(int i=100 ; i>0 ; i--) {
				if(score[i] == scoreSort[100]) {
					ans = i;
					break;
				}
			}
			System.out.println("#"+tCase+" "+ans);
		}
	}
}
