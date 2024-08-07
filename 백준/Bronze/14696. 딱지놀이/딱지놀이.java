import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		for(int r=0 ; r<N ; r++) {
			int a = sc.nextInt();
			int[] aCnt = new int[5];
			for(int i=0 ; i<a ; i++) {
				aCnt[sc.nextInt()]++;
			}
			
			int b = sc.nextInt();
			int[] bCnt = new int[5];
			for(int i=0 ; i<b ; i++) {
				bCnt[sc.nextInt()]++;
			}
			
			for(int i=4 ; i>0 ; i--) {
				if(aCnt[i]==bCnt[i]) {
					if(i==1) {
						System.out.println("D");
					} else {
						continue;
					}
				} else if (aCnt[i]>bCnt[i]) {
					System.out.println("A");
					break;
				} else {
					System.out.println("B");
					break;
				}
				
			}
		}
	}
}
