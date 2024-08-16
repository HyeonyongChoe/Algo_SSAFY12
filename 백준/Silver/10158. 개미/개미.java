import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int w = sc.nextInt();
		int h = sc.nextInt();
		int p = sc.nextInt();
		int q = sc.nextInt();
		
		int t = sc.nextInt();
		
		if(((p+t)/w)%2==0) {
			p = (p+t)%w;
		} else {
			p = w-(p+t)%w;
		}
		
		if(((q+t)/h)%2==0) {
			q = (q+t)%h;
		} else {
			q = h-(q+t)%h;
		}
		
		System.out.println(p+" "+q);
	}
}
