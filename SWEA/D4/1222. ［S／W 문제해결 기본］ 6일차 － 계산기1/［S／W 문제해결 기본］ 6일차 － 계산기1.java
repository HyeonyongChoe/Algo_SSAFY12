import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class Solution {
	static Stack<Character> buffer = new Stack<>();
	static Map<Character, Integer> inComingPriority = new HashMap<>();
	static Map<Character, Integer> inStackPriority = new HashMap<>();
	
	static {
		inComingPriority.put('+', 1);
		inComingPriority.put('-', 1);
		inComingPriority.put('*', 2);
		inComingPriority.put('/', 2);
		inComingPriority.put('(', 0);
		
		inStackPriority.put('+', 1);
		inStackPriority.put('-', 1);
		inStackPriority.put('*', 2);
		inStackPriority.put('/', 2);
		inStackPriority.put('(', 3);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int tc=1 ; tc<=10 ; tc++) {
			int N = sc.nextInt();
			char[] input = sc.next().toCharArray();
			
			input = InfixToPostfix(input);
			
			int ans = Calculator(input);
			System.out.println("#"+tc+" "+ans);
		}
	}
	
	
	
	
	static char[] InfixToPostfix(char[] exp) {
		char[] result = new char[exp.length];
		int idx=0;
		for(int i=0 ; i<exp.length ; i++) {
			if('0' <= exp[i] && exp[i] <= '9') {
				result[idx++] = exp[i];
			} else if(exp[i]=='(') {
				buffer.push(exp[i]);
			}else {
				if(buffer.isEmpty()) {
					buffer.push(exp[i]);
				}else if (exp[i]==')') {
					while(buffer.peek()!='(') {
						result[idx++] = buffer.pop();
					}
					buffer.pop();
				} else {
					while(!buffer.isEmpty() || inStackPriority.get(buffer.peek())>=inComingPriority.get(exp[i])) {
						result[idx++] = buffer.pop();
						if (buffer.isEmpty()) break;
					}
					buffer.push(exp[i]);						
				}
			}
		}
		
		while(!buffer.isEmpty()) {
			result[idx++] = buffer.pop();
		}
		return result;
	}
	
	static int Calculator(char[] exp) {
		for (int i=0 ; i<exp.length ; i++) {
			if('0'<=exp[i] && exp[i]<='9') {
				buffer.push(exp[i]);
			} else {
				int num2 = buffer.pop()-'0';
				int num1 = buffer.pop()-'0';
				int result;
				if (exp[i]=='+') {
					result = num1 + num2;
				} else if (exp[i]=='-') {
					result = num1 - num2;
				} else if (exp[i]=='*') {
					result = num1 * num2;
				} else {
					result = num1 / num2;
				}
				buffer.push((char) (result+'0'));
			}
		}
		return buffer.pop()-'0';
	}
}
