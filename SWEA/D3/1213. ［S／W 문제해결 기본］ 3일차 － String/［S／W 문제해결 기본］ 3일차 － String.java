import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = 10;
		for(int tc=1 ; tc<=T ; tc++) {
			sc.nextInt();
			char[] target = sc.next().toCharArray();
			char[] word = sc.next().toCharArray();
			
			int p1 = 0;
			int p2 = 0;
			int cnt = 0;
			for(int i=0 ; i<word.length-target.length+1 ; i++) {
				p1 = i;
				p2 = 0;
				check: 
				for (int j=i ; j<target.length+i ; j++) {
					if(word[p1]==target[p2]) {
						if (p1==i+target.length-1) {
							cnt++;
							i = i+target.length;
							break check;
						} else {
							p1++;
							p2++;							
						}
					} else {
						break check;
					}
				}
			}
			System.out.println("#"+tc+" "+cnt);
		}
	}
}
