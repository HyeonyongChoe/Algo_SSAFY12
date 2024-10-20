import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int H = sc.nextInt();
		int M = sc.nextInt();
		
		if(M-45<0) {
			H = (H-1+24)%24;
			M += 15;
			
			
		} else {
			M -= 45;
		}
		
		System.out.println(H+" "+M);
	}
}
