import java.util.Scanner;
import java.util.Stack;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc=1 ; tc<=T ; tc++) {
			String[] steel = sc.next().split("");
			Stack<String> chk = new Stack<>();
			
			int cnt = 0;
			for(int i=0 ;i<steel.length ; i++) {
				if(steel[i].equals("(")) {
					chk.push(steel[i]);
					cnt++;
				} else {
					if (steel[i-1].equals("(")) {
						chk.pop();
						cnt--;
						cnt += chk.size();
					} else {
						chk.pop();
					}
				}
			}
			System.out.println("#"+tc+" "+cnt);
		}
	}
}
