import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = 10;
		
		for(int tc=1 ; tc<=T ; tc++) {
			int N = sc.nextInt();
			
			Stack<String> braket = new Stack<String>();
			String[] input = sc.next().split("");
			
			int ans = 1;
			for(int i=0 ; i<N ; i++) {
				if(input[i].equals("(") || input[i].equals("{") || input[i].equals("[") || input[i].equals("<") ) {
					braket.push(input[i]);
				}
				else {
					if(braket.isEmpty()) {
						ans = 0;
						break;
					} else if(input[i].equals(")") && braket.peek().equals("(")) {
						braket.pop();
					} else if(input[i].equals("}") && braket.peek().equals("{")) {
						braket.pop();
					} else if(input[i].equals("]") && braket.peek().equals("[")) {
						braket.pop();
					} else if(input[i].equals(">") && braket.peek().equals("<")) {
						braket.pop();
					} else {
						ans = 0;
						break;
					}
				}
			}
			if(!braket.isEmpty()) ans=0;
			System.out.println("#"+tc+" "+ans);
		}
	}
}
