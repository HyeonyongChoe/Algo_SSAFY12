import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String word = sc.next();
		for(int i=0 ; i<26 ; i++) {
			
			int ans = word.indexOf('a'+ i);
			System.out.print(ans+" ");
		}
	}
}
