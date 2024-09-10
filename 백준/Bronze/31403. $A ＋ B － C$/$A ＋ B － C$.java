import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();
		
		
		int ans1 = A+B-C;
		String ans2 = (A+""+B);
		int ans3 = Integer.valueOf(ans2)-C;
		System.out.println(ans1);
		System.out.println(ans3);
		
	}
}
