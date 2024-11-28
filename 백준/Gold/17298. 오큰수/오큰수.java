import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		
		int[] num = new int[N];
		Stack<Integer> stack = new Stack();
		
		st = new StringTokenizer(br.readLine());
		for(int i=0 ; i<N ; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] NGE = new int[N];
		
		for(int i=0 ; i<N ; i++) {
			while(!stack.isEmpty() && num[stack.peek()]<num[i]) {
				num[stack.pop()] = num[i];
			}
			stack.push(i);
		}
		
		while(!stack.isEmpty()) {
			num[stack.pop()] = -1;
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=0 ; i<N ; i++) {
			sb.append(num[i]).append(" ");
		}
		
		System.out.println(sb);
	}
}
