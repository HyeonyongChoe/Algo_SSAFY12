import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			char[] n = sc.next().toCharArray();
			
			if(n.length==1 && n[0]=='0') break;
			
			boolean flag = true;
			int len = n.length;
			for(int i=0 ; i<len/2 ; i++) {
				if(n[i]==n[len-i-1]) continue;
				else {
					flag = false;
					break;
				}
			}
			
			if(flag) System.out.println("yes");
			else System.out.println("no");
		}
	}
}
