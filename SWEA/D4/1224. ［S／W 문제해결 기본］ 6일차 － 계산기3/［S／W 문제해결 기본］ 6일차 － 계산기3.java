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
		inComingPriority.put('(', 3);
		
		inStackPriority.put('+', 1);
		inStackPriority.put('-', 1);
		inStackPriority.put('*', 2);
		inStackPriority.put('/', 2);
		inStackPriority.put('(', 0);
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
			} else if(buffer.isEmpty()) {
				buffer.push(exp[i]);
			}else {
				if(exp[i]=='(') {
					buffer.push(exp[i]);
				}else if (exp[i]==')') {
					while( buffer.peek()!='(') {
						result[idx++] = buffer.pop();
						if (buffer.peek()=='(') break;
					}
					buffer.pop();
				} else {
					while(!buffer.isEmpty() && inStackPriority.get(buffer.peek())>=inComingPriority.get(exp[i])) {
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
		result[idx++] = '#';
		return result;
	}
	
	static int Calculator(char[] exp) {
		Stack<Integer> stack = new Stack<>();
		for (int i=0 ; i<exp.length ; i++) {
			if(exp[i]=='#') break;
			if('0'<=exp[i] && exp[i]<='9') {
				stack.push(exp[i]-'0');
			} else {
				int num2 = stack.pop();
				int num1 = stack.pop();
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
				stack.push(result);
			}
		}
		return stack.pop();
	}
}
