import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc=1 ; tc<=T ; tc++) {
			char[] memory = sc.next().toCharArray();
			char[] initial = new char[memory.length];
			
			for(int i=0 ; i<initial.length ; i++) {
				initial[i] = '0';
			}
			
			int ans = 0;
			for(int i=0 ; i<memory.length ; i++) {
				if(memory[i]!=initial[i]) {
					ans++;
					for(int j=i ; j<memory.length ; j++) {
						initial[j] = memory[i];
					}
				}
				
			}
			System.out.println("#"+tc+" "+ans);
		}
	}
}
