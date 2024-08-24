import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int P = sc.nextInt();
		
		for(int tc=1 ; tc<=P ; tc++) {
			int T = sc.nextInt();
			
			int[] student = new int[20];
			
			int ans = 0;
			student[0] = sc.nextInt();
		
			for(int i=1 ; i<20 ; i++) {
				student[i] = sc.nextInt();
				
				if(student[i]<student[i-1]) {
					for(int j=i ; j>0 ; j--) {
						if(student[j]<student[j-1]) {
							int tmp = student[j];
							student[j] = student[j-1];
							student[j-1] = tmp;
							ans++;
						} else {
							break;
						}
					}
				}
			}
			System.out.println(T+" "+ans);
		}
	}
}
