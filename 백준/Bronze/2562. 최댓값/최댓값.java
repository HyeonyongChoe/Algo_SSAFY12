import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int ans = 0;
		int idx = 0;
		for(int i=1; i<10 ; i++) {
			int num = sc.nextInt();
			if(num>ans) {
				ans = num;
				idx = i;
			}
		}
		System.out.println(ans);
		System.out.println(idx);
	}
}
