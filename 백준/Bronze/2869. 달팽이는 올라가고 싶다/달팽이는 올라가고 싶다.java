import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int A = sc.nextInt();
		int B = sc.nextInt();
		int V = sc.nextInt();
		
		int cnt = 1;
		
		V -= A;
		cnt += V/(A-B);
		
		if(V%(A-B)>0) cnt++;
		System.out.println(cnt);
	}
}
