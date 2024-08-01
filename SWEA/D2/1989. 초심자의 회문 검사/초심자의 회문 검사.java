import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc=1 ; tc<=T ; tc++) {
			String[] word = sc.next().split("");
			
			int ans = 1;
			for(int i=0 ; i<word.length/2 ; i++) {
				if (!(word[i].equals(word[word.length-i-1]))) {
					ans = 0;
					break;
				}
			}
			System.out.println("#"+tc+" "+ans);
			
		}
	}
}
