import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = 10;
		Map<Character,Character> dic = new HashMap<>();
		dic.put('(', ')');
		dic.put('{', '}');
		dic.put('[', ']');
		dic.put('<', '>');
		
		for(int tc=1 ; tc<=T ; tc++) {
			int N = sc.nextInt();
			
			Stack<Character> braket = new Stack<>();
			char[] input = sc.next().toCharArray();
			
			int ans = 1;
			for(int i=0 ; i<N ; i++) {
				if(dic.containsKey(input[i]) ) {
					braket.push(input[i]);
				}
				else {
					if(braket.isEmpty()) {
						ans = 0;
						break;
					} else if(dic.get(braket.peek())==input[i]) {
						braket.pop();
					}  else {
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
